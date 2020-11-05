package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Address;
import com.example.service.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
//VueとSpringを起動した時に同じソースであってもポート番号が違うためエラーが出るので、それを許可するためのアノテーション
@RequiredArgsConstructor
//finalのメンバへ値をセットするための引数付きコンストラクタを自動生成することができる。
public class AddressController {

	private final AddressService addressService;
	
	@GetMapping("/")
	public List<Address> findAll(){
		List<Address> addresses = addressService.findAll();
		System.out.println(addresses);
		return addresses;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Address addresses) {
		//@RequestBodyでsonで受信
		addressService.save(addresses);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		//URLに含まれる動的なパラメータを受け取ることができる。
		System.out.println(id);
		addressService.delete(id);
	}
	
	@PutMapping("/{id}")
	
	public void updateItem(@PathVariable Long id, @RequestBody Address address) {
		address.setId(id);
		addressService.update(address);
	}
	
}
