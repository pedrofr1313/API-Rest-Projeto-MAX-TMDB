package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import jakarta.transaction.Transactional;
import com.example.demo.repositories.FilmeRepository;
import com.example.demo.models.Filme;
@Service
public class FilmeService {
  @Autowired
  private FilmeRepository filmeRepository;

  public Iterable<Filme> findAll()
  {
    return filmeRepository.findAll();
  }
@Transactional
  public void save(Filme filme)
  {
    Optional<Filme> procurado = findByCodigo(filme.getCodigo());
    if(procurado.isPresent())
    {
      throw new RuntimeException("Filme já esta salvo!");
    }
   else{
   
    filmeRepository.save(filme);
   }
  }

  public Optional<Filme> findByCodigo(int codigo)
  {
    Optional<Filme> filme = filmeRepository.findByCodigo(codigo);
    
    return filme;
  }
  @Transactional
  public void deleteByCodigo(int codigo)
  {
    filmeRepository.deleteByCodigo(codigo);
  }
}
