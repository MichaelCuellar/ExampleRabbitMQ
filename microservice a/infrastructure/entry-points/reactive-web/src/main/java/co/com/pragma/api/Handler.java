package co.com.pragma.api;

import co.com.pragma.model.product.Product;
import co.com.pragma.usecase.person.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final ProductUseCase productUseCase;

    public Mono<ServerResponse> sellProductUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Product.class)
                .flatMap(productUseCase::sellProduct)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }
}
