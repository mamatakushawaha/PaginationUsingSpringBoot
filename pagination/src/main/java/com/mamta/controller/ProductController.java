package com.mamta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamta.dto.ProductDto;
import com.mamta.entity.Product;
import com.mamta.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping
	private ProductDto<List<Product>> getProducts(){
		List<Product> allProducts=service.findAllProduct();
		return new ProductDto<>(allProducts.size(),allProducts);
	}
	
	@GetMapping("/{field}")
	private ProductDto<List<Product>> getProductsWithSort(@PathVariable String field){
		List<Product> allProduct=service.findProductWithSorting(field);
		return new ProductDto<>(allProduct.size(),allProduct);
	}
	
	@GetMapping("pagination/{pageNo}/{pageSize}")
	private ProductDto<Page<Product>> getProductwithPagination(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		Page<Product> productWithPagination=service.findProductWithPagination(pageNo, pageSize);
		return new ProductDto<>(productWithPagination.getSize(),productWithPagination);
	}
	
	@GetMapping("paginationwithsort/{offset}/{pageSize}/{field}")
	private ProductDto<Page<Product>> getProductwithPaginationAndSort(@PathVariable Integer pageNo,@PathVariable Integer pageSize,@PathVariable String field){
		Page<Product> productWithPaginationAndSort=service.findProductWithPaginationAndSorting(pageNo, pageSize, field);
				return new ProductDto<>(productWithPaginationAndSort.getSize(),productWithPaginationAndSort);
	}

}
