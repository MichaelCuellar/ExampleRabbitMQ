package co.com.pragma.usecase.person;

import co.com.pragma.model.events.gateways.EventsGateway;
import co.com.pragma.model.product.Product;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductUseCase {

    private final EventsGateway eventsGateway;

    public Mono<Product> sellProduct(Product product) {
        return Mono.just(product)
                .doOnNext(this::emitEvent);
    }

    private void emitEvent(Product product) {
        eventsGateway.emit(product).subscribe();
    }

}
