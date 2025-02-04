package com.example.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Entity
@Table(name="Filme")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Filme {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="poster_path")
    private String poster_path;

    @Column(name="codigo")
    private int codigo;
    
    @Column(name="EFilme")
    private boolean EFilme;
}
