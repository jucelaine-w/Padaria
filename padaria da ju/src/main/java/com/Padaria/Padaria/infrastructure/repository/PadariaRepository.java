package com.Padaria.Padaria.infrastructure.repository;

import com.Padaria.Padaria.infrastructure.entitys.Padaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PadariaRepository extends JpaRepository<Padaria,Long> {
}
