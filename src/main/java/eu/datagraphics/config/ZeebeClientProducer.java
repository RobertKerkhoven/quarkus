package eu.datagraphics.config;

import io.camunda.zeebe.client.ZeebeClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ZeebeClientProducer {

    @Produces
    @ApplicationScoped
    ZeebeClient zeebeClient() {
        return ZeebeClient.newClientBuilder()
                .gatewayAddress("127.0.0.1:26500")
                .usePlaintext()
                .build();
    }
}
