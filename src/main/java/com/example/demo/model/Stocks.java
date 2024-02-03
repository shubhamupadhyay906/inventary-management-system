package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Stocks implements Comparator<Stocks>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private int perPrice;
    private String type;
    private int totalStock;

    @Override
    public int compare(Stocks o1, Stocks o2) {
        int compareTo = o1.productName.compareTo(o2.productName);
        if (compareTo == 0) {
            return o1.perPrice - o2.perPrice;
        }
        return compareTo;
    }
}
