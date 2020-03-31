package br.com.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.data.dto.ProductDTO;
import br.com.spring.data.entity.Product;
import br.com.spring.data.service.ProductService;
import br.com.spring.data.service.utils.EntityUtils;

@RestController
@RequestMapping("${product.servlet.path}")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		List<Product> products = productService.findAll();

		List<ProductDTO> dtos = EntityUtils.mapAll(products, ProductDTO.class);

		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Integer id) {
		Product product = productService.findById(id);

		return ResponseEntity.ok().body(EntityUtils.map(ProductDTO.class, product));
	}

	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDto) {
		Product product = EntityUtils.map(Product.class, productDto);

		Product createdProduct = productService.create(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(EntityUtils.map(ProductDTO.class, createdProduct));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDto,
			@PathVariable("id") Integer id) {
		Product product = EntityUtils.map(Product.class, productDto);

		product.setId(id);

		product = productService.update(product);

		return ResponseEntity.ok().body(EntityUtils.map(ProductDTO.class, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable("id") Integer id) {
		Product product = productService.findById(id);

		productService.deleteById(id);

		return ResponseEntity.ok().body(EntityUtils.map(ProductDTO.class, product));
	}
}
