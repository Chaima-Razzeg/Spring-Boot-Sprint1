package com.chaima.cosmetics.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chaima.cosmetics.entities.Cosmetic;
import com.chaima.cosmetics.service.CosmeticService;

@Controller
public class CosmeticController {
	@Autowired
	CosmeticService cosmeticService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createCosmetic";
	}
	@RequestMapping("/saveCosmetic")
	public String saveCosmetic(@ModelAttribute("cosmetic") Cosmetic cosmetic, 
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws
	ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 cosmetic.setExpirationDate(dateCreation);
	 
	Cosmetic saveCosmetic = cosmeticService.saveCosmetic(cosmetic);
	String msg ="Cosmetic product registered with Reference "+saveCosmetic.getCosmeticReference();
	modelMap.addAttribute("msg", msg);
    return "redirect:/ListCosmetics";
	}
	@RequestMapping("/ListCosmetics")
	public String listCosmetics(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Cosmetic> cosms = cosmeticService.getAllCosmeticsParPage(page, size);
	modelMap.addAttribute("cosmetics", cosms);
	 modelMap.addAttribute("pages", new int[cosms.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listCosmetics";
	}
	@RequestMapping("/supprimerCosmetic")
	public String supprimerCosmetic(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	cosmeticService.deleteCosmeticById(id);
	Page<Cosmetic> cosms = cosmeticService.getAllCosmeticsParPage(page, 
	size);
	modelMap.addAttribute("cosmetics", cosms);
	modelMap.addAttribute("pages", new int[cosms.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listCosmetics";
	}
    @RequestMapping("/modifierCosmetic")
    public String editerCosmetic(@RequestParam("id") Long id,ModelMap modelMap)
    {
       Cosmetic p= cosmeticService.getCosmetic(id);
        modelMap.addAttribute("cosmetic", p);
        return "editerCosmetic";
    }
    @RequestMapping("/updateCosmetic")
    public String updateCosmetic(@ModelAttribute("cosmetic") Cosmetic cosmetic, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
      cosmetic.setExpirationDate(dateCreation);

        cosmeticService.updateCosmetic(cosmetic);
        return "redirect:/ListCosmetics";
    }

}
