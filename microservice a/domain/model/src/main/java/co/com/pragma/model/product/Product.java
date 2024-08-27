package co.com.pragma.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product {

    private String id;
    private String name;
    private Integer price;
    private Integer stock;
}
