package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
	@Column(name = "id")
    Integer id;
	
	@Column(name = "name")
	@NotNull
	@Size(min = 3, max = 50, message = "must be between 3 and 50 characters")
    String name;
	
	@Column(name = "price")
	@NotNull
	@Min(value = 0, message = "must be positive values")
    double price;
	
	@ManyToOne(optional = true)
    @JoinColumn(name = "productTypeS")
    private ProductType productType;
}
