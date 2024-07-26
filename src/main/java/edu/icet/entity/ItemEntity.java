package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class ItemEntity {
    private Integer id;
    private String name;
    private Double rentalPerDay;
    private boolean availability;
    private Double finePerDay;
}
