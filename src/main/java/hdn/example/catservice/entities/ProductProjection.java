package hdn.example.catservice.entities;

import org.springframework.data.rest.core.config.Projection;

/**
 * ProduitProjection
 */

 @Projection(name = "P1", types = Product.class)
public interface ProductProjection {

    public double getPrice();
}