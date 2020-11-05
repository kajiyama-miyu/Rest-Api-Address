package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.domain.Address;
import com.example.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressService {

	private final AddressRepository addressRepository;
	
	
	public List<Address> findAll() {
		return addressRepository.findAll();
	}
	
	public void save(Address address) {
		addressRepository.save(address);
	}
	public void delete(Long id) {
		addressRepository.findById(id).ifPresent(address -> addressRepository.delete(address));
		//ifPresentはnullでない場合のみ引数に指定した処理を行うOptionalクラスのメソッド。ifを使わずに簡潔に条件分岐処理をしてくれる。
	}
	public void update(Address address) {
		addressRepository.save(address);
	}
}
