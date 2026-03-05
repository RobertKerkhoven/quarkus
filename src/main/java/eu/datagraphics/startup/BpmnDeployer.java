package eu.datagraphics.startup;

import io.camunda.zeebe.client.ZeebeClient;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class BpmnDeployer {

    private final ZeebeClient client;

    public BpmnDeployer(ZeebeClient client) {
        this.client = client;
    }

    void onStart(@Observes StartupEvent ev) {

        //Test presence bpmn file.
        var res = Thread.currentThread().getContextClassLoader()
                .getResource("bpmn/Hello_camunda1.bpmn");
        System.out.println("Resource = " + res);

        client.newDeployResourceCommand()
                //TODO: reading file from classpath not possible/enabled...! Fix?
                //.addResourceFromClasspath("bpmn/Hello_camunda1.bpmn")
                .addResourceFile("src/main/resources/bpmn/Hello_camunda1.bpmn")
                .send()
                .join();
    }
}
