package hdn.example.catservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Produit
 */

@Entity
@Table(name = "Product")
@Data
@EqualsAndHashCode(callSuper=false)
public class ProductJpa extends Product {

	private static final long serialVersionUID = 2083534115856188791L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String designation;
	
}

