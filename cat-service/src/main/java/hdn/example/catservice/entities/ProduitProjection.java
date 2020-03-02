package hdn.example.catservice.entities;

import org.springframework.data.rest.core.config.Projection;

/**
 * ProduitProjection
 */

 @Projection(name = "P1", types = Produit.class)
public interface ProduitProjection {

    public double getPrice();
}