package shopping.spree.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name.trim();
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            System.out.printf("%s can't afford %s%s",
                    this.name, product.getName(), System.lineSeparator());
        } else {
            this.setMoney(this.money - product.getCost());
            this.products.add(product);

            System.out.printf("%s bought %s%s",
                    this.name, product.getName(), System.lineSeparator());
        }
    }

    @Override
    public String toString() {
        String products = this.products
                .stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        if (products.isEmpty()) {
            return this.name + " - Nothing bought";
        }

        return String.format("%s - %s", this.name, products);
    }
}
