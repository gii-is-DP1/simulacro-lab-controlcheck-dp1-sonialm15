package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
	
	@Column(name = "name")
	@NotNull
	@Size(min = 3, max = 50)
    String name;
	
	@Column(name = "price")
	@NotNull
	@Min(0)
    double price;
	
	
	@ManyToOne(optional = true)
    @JoinColumn(name = "productType")
    private ProductType productType;
}
