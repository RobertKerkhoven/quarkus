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
        client.newDeployResourceCommand()
                .addResourceFromClasspath("bpmn/* .bpmn")
                .send()
                .join();
        System.out.println("BPMN deployed");
    }
}

