package com.chaima.cosmetics.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.chaima.cosmetics.entities.Cosmetic;

public interface CosmeticService {
	Cosmetic saveCosmetic(Cosmetic c);
	Cosmetic updateCosmetic(Cosmetic c);
	void deleteCosmetic(Cosmetic c);
	 void deleteCosmeticById(Long id);
	Cosmetic getCosmetic(Long id);
	List<Cosmetic> getAllCosmetics();
	Page<Cosmetic> getAllCosmeticsParPage(int page, int size);


}
