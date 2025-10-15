package com.mamta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mamta.entity.Product;
import com.mamta.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> findAllProduct(){
		return repo.findAll();
	}
	
	public List<Product> findProductWithSorting(String field){
		return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public Page<Product> findProductWithPagination(Integer pageNo,Integer pageSize){
		Page<Product> products=repo.findAll(PageRequest.of(pageNo, pageSize));
		return products;
	}
	
	public Page<Product> findProductWithPaginationAndSorting(Integer pageNo,Integer pageSize,String field){
		Page<Product> products=repo.findAll(PageRequest.of(pageNo, pageSize).withSort(Sort.by(field)));
		return products;
	}
	
	public Page<Product> findProductWithPaginationSortDir(Integer page,Integer size,String sortBy,String sortDir){
		Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		Pageable pageable=PageRequest.of(page,size,sort);
		return repo.findAll(pageable);
		
	}

}
