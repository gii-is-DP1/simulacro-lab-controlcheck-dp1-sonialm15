package org.springframework.samples.petclinic.product;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.PetValidator;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

	private final ProductService productService;
  

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}


	@GetMapping(value = "/create")
	public String initCreationForm(ModelMap model) {
		model.addAttribute("product", new Product());
		model.addAttribute("productType", productService.getAllProductTypes());
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {		
		String view = "welcome";
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("productType", productService.getAllProductTypes());
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
        productService.save(product);
        model.addAttribute("message", "Product succesfully saved!");
        return view;
		}
		
	}


 
}
