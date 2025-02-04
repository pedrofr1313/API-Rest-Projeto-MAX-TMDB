package com.example.demo.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Filme;
public interface FilmeRepository extends JpaRepository<Filme, Long>{
    Optional<Filme> findByCodigo(int codigo);
    void deleteByCodigo(int codigo);
}
