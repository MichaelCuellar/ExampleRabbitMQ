package co.com.pragma.usecase.product;

import co.com.pragma.model.product.Product;
import co.com.pragma.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductRepository productRepository;


    public Mono<Void> updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }
}
