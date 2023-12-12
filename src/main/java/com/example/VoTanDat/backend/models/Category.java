package com.example.VoTanDat.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<Product> products;

    public Category(long id){
        this.id = id;
    }

    public Category(int i, String s) {
        this.id = i;
        this.name = s;
    }
}
