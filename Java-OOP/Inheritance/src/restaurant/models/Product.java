package restaurant.models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }
}
