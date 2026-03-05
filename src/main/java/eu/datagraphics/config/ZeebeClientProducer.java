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
                .gatewayAddress("localhost:26500")
                .usePlaintext()
                .build();
    }
}
