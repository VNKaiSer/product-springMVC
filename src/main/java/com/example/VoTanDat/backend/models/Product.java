package com.example.VoTanDat.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "products")
//@NamedQueries({
//        @NamedQuery(name = "product.findProductByCategory", query = "select p from Product p where p.category.id = :id")
//})
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(long id, String name, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(long id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + (category == null ? null : category.getId()) +
                '}';
    }
}
