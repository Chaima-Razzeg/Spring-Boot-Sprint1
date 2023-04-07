package com.chaima.cosmetics;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.repos.CosmeticRepository;
import com.chaima.cosmetics.service.CosmeticService;

@SpringBootTest
class CosmeticsApplicationTests {

	@Autowired
	private CosmeticRepository cosmeticRepository;
	@Autowired
	private CosmeticService cosmeticService;
	@Test
	public void testCreateCosmetic() {
	Cosmetic cosm = new Cosmetic("Ecran solaire",75.900,new Date());
	cosmeticRepository.save(cosm);
	}
	@Test
	public void testFindProduit()
	{
		Cosmetic c = cosmeticRepository.findById(1L).get(); 
		System.out.println(c);
	}
	@Test
	public void testUpdateCosmetic()
	{
		Cosmetic c = cosmeticRepository.findById(1L).get();
		c.setItemPrice(45.0);
		cosmeticRepository.save(c);
	}
	@Test
	public void testDeleteCosmetic()
	{
		cosmeticRepository.deleteById(1L);;
	}
	 
	@Test
	public void testListerTousCosmetics()
	{
		List<Cosmetic> cosms = cosmeticRepository.findAll();
	for (Cosmetic c : cosms)
	{
		System.out.println(c);
	}
	}
	@Test
	public void testFindByCosmeticNameContains()
	{
	Page<Cosmetic> prods = cosmeticService.getAllCosmeticsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());});
	}
}