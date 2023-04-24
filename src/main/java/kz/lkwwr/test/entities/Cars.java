package kz.lkwwr.test.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "volume", nullable = false)
    private double volume;

    @Column(name = "price", nullable = false)
    private int price;

    @OneToMany(fetch = FetchType.EAGER)
    private ArrayList<Transmissions> transmission;

    @ManyToOne(fetch = FetchType.EAGER)
    private Countries country;
}
