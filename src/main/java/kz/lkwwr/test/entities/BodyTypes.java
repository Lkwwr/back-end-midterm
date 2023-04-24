package kz.lkwwr.test.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "body-types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BodyTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity-of-doors")
    private int quantityOfDoors;
}
