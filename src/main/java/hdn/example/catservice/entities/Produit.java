package hdn.example.catservice.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Produit
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString()
@Document(collection = "products")
public class Produit implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;

    private double price;

    private int quantite;
    
    private static final long serialVersionUID = 1L;
}

