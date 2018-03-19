package com.maciejak.futurum_task.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double emeraldAccount;

    @OneToMany(mappedBy = "owner")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getEmeraldAccount() {
        return emeraldAccount;
    }

    public void setEmeraldAccount(Double emeraldAccount) {
        this.emeraldAccount = emeraldAccount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
