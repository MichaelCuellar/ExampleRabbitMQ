package co.com.pragma.events;

import co.com.pragma.model.events.gateways.EventsGateway;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static reactor.core.publisher.Mono.from;


@RequiredArgsConstructor
@EnableDomainEventBus
public class ReactiveEventsGateway implements EventsGateway {

    public static final String PRODUCT_EVENT = "product.event.update";
    private final DomainEventBus domainEventBus;

    @Override
    public Mono<Void> emit(Object event) {
        return from(domainEventBus.emit(new DomainEvent<>(PRODUCT_EVENT, UUID.randomUUID().toString(), event)));
    }
}
