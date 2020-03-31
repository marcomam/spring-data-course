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

import br.com.spring.data.dto.MerchantDTO;
import br.com.spring.data.entity.Merchant;
import br.com.spring.data.service.MerchantService;
import br.com.spring.data.service.utils.EntityUtils;

@RestController
@RequestMapping("${merchant.servlet.path}")
public class MerchantController {

	private MerchantService merchantService;

	@Autowired
	public MerchantController(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@GetMapping
	public ResponseEntity<List<MerchantDTO>> getAllMerchants() {
		List<Merchant> merchants = merchantService.findAll();

		List<MerchantDTO> dtos = EntityUtils.mapAll(merchants, MerchantDTO.class);

		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MerchantDTO> getMerchant(@PathVariable("id") Integer id) {
		Merchant merchant = merchantService.findById(id);

		return ResponseEntity.ok().body(EntityUtils.map(MerchantDTO.class, merchant));
	}

	@PostMapping
	public ResponseEntity<MerchantDTO> createMerchant(@RequestBody MerchantDTO merchantDto) {
		Merchant merchant = EntityUtils.map(Merchant.class, merchantDto);

		Merchant createdMerchant = merchantService.create(merchant);

		return ResponseEntity.status(HttpStatus.CREATED).body(EntityUtils.map(MerchantDTO.class, createdMerchant));
	}

	@PutMapping("/{id}")
	public ResponseEntity<MerchantDTO> updateMerchant(@RequestBody MerchantDTO merchantDto,
			@PathVariable("id") Integer id) {
		Merchant merchant = EntityUtils.map(Merchant.class, merchantDto);

		merchant.setId(id);

		merchant = merchantService.update(merchant);

		return ResponseEntity.ok().body(EntityUtils.map(MerchantDTO.class, merchant));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<MerchantDTO> deleteMerchant(@PathVariable("id") Integer id) {
		Merchant merchant = merchantService.findById(id);

		merchantService.deleteById(id);

		return ResponseEntity.ok().body(EntityUtils.map(MerchantDTO.class, merchant));
	}
}
