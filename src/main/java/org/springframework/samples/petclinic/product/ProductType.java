package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ProductTypes")
public class ProductType {
	
	@Column(name = "id")
    Integer id;
    
	@Column(name = "name", unique= true)
	@Size(min = 3, max = 50, message = "must be between 3 and 50 characters")
	String name;
}
