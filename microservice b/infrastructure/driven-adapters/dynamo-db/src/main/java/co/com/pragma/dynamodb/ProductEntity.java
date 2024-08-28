package co.com.pragma.dynamodb;

import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@DynamoDbBean
@Setter
@Getter
public class ProductEntity {


    private String id;
    private String name;
    private String price;
    private String stock;

    public ProductEntity() {
    }

    public ProductEntity(String id, String name, String price, String stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
