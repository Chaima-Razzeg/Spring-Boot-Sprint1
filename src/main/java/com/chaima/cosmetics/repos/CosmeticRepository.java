package com.chaima.cosmetics.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.chaima.cosmetics.entities.Cosmetic;

public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {

}
