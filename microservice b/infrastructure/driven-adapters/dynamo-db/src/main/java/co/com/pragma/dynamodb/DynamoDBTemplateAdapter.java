package co.com.pragma.dynamodb;

import co.com.pragma.dynamodb.helper.TemplateAdapterOperations;
import co.com.pragma.model.product.Product;
import co.com.pragma.model.product.gateways.ProductRepository;
import lombok.extern.java.Log;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;


@Repository
@Log
public class DynamoDBTemplateAdapter extends TemplateAdapterOperations<Product, String, ProductEntity>
        implements ProductRepository {

    public DynamoDBTemplateAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper) {
        super(connectionFactory, mapper, d -> mapper.map(d, Product.class), "products");
    }

    @Override
    public Mono<Void> updateProduct(Product product) {
        return this.save(product)
                .doAfterTerminate(() -> log.info("Product Saved: " + product.getName()))
                .then();
    }
}
