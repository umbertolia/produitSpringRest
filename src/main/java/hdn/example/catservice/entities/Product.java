/**
 * 
 */
package hdn.example.catservice.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Gandalf
 *
 */

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2688380255865910604L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String designation;

	private double price;

	private int quantite;
	
	

}
