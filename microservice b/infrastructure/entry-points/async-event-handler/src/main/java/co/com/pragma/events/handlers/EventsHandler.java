package co.com.pragma.events.handlers;

import co.com.pragma.model.product.Product;
import co.com.pragma.usecase.product.ProductUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@Log
@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {
    private final ProductUseCase productUseCase;

    public Mono<Void> handleEventUpdateProduct(DomainEvent<Product> event) {
        return productUseCase.updateProduct(event.getData())
                .doAfterTerminate(() -> log.info("Event heard: " + event.getData().getName()));
    }
}
