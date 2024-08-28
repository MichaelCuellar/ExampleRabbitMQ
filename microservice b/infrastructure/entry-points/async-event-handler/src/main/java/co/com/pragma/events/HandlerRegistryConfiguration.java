package co.com.pragma.events;

import co.com.pragma.events.handlers.EventsHandler;
import co.com.pragma.model.product.Product;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {


    @Bean
    public HandlerRegistry handlerRegistry(EventsHandler events) {
        return HandlerRegistry.register()
                .listenEvent("product.event.update", events::handleEventUpdateProduct, Product.class);
    }
}
