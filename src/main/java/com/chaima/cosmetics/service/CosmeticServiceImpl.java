package com.chaima.cosmetics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.repos.CosmeticRepository;

@Service
public class CosmeticServiceImpl implements CosmeticService {

	@Autowired
	CosmeticRepository cosmeticRepository;
	@Override
	public Cosmetic saveCosmetic(Cosmetic c) {
		return cosmeticRepository.save(c);
	}

	@Override
	public Cosmetic updateCosmetic(Cosmetic c) {
		return cosmeticRepository.save(c);
	}

	@Override
	public void deleteCosmetic(Cosmetic c) {
		cosmeticRepository.delete(c);		
	}

	@Override
	public void deleteCosmeticById(Long id) {
		cosmeticRepository.deleteById(id);
		
	}

	@Override
	public Cosmetic getCosmetic(Long id) {
		return cosmeticRepository.findById(id).get();
	}

	@Override
	public List<Cosmetic> getAllCosmetics() {
		return cosmeticRepository.findAll();
	}
	@Override
	public Page<Cosmetic> getAllCosmeticsParPage(int page, int size) {
	return cosmeticRepository.findAll(PageRequest.of(page, size));
	}

}
