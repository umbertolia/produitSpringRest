package hdn.example.catservice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Produit
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;

    private double price;

    private int quantite;
    
    private static final long serialVersionUID = 1L;

}

