package br.com.alunoonline.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "disciplina")
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private Integer cargaHoraria;

    @ManyToOne /*Muitas Disciplinas para um professor*/
    @JoinColumn (name = "professor_id") /* Junta as colunas identicas em disciplina/professor*/
    private Professor professor;
}
