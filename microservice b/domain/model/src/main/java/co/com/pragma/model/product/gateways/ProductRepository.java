package co.com.pragma.model.product.gateways;

import co.com.pragma.model.product.Product;
import reactor.core.publisher.Mono;

public interface ProductRepository {

    Mono<Void> updateProduct(Product product);
}
