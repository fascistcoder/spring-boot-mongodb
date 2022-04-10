package com.example.springbootmongodb.controllers;

import com.example.springbootmongodb.commands.ProductForm;
import com.example.springbootmongodb.converters.ProductToProductForm;
import com.example.springbootmongodb.domain.Product;
import com.example.springbootmongodb.services.ProductService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/04/22
 */
@RestController
public class ProductController {
	private ProductService productService;

	private ProductToProductForm productToProductForm;

	@RequestMapping("/")
	public String redirToList(){
		return "redirect:/product/list";
	}

	@RequestMapping({"/product/list", "/product"})
	public String listProducts(Model model){
		model.addAttribute("products", productService.listAll());
		return "product/list";
	}

	@RequestMapping("/product/show/{id}")
	public String getProduct(@PathVariable String id, Model model){
		model.addAttribute("product", productService.getById(id));
		return "product/show";
	}

	@RequestMapping("product/edit/{id}")
	public String edit(@PathVariable String id, Model model){
		Product product = productService.getById(id);
		ProductForm productForm = productToProductForm.convert(product);

		model.addAttribute("productForm", productForm);
		return "product/productform";
	}

	@RequestMapping("/product/new")
	public String newProduct(Model model){
		model.addAttribute("productForm", new ProductForm());
		return "product/productform";
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveOrUpdateProduct(@Validated ProductForm productForm, BindingResult bindingResult){

		if(bindingResult.hasErrors()){
			return "product/productform";
		}

		Product savedProduct = productService.saveOrUpdateProductForm(productForm);

		return "redirect:/product/show/" + savedProduct.getId();
	}

	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable String id){
		productService.delete(id);
		return "redirect:/product/list";
	}
}
