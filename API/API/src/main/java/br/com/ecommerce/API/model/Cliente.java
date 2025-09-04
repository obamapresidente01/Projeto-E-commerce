package br.com.ecommerce.API.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "cliente", schema = "ecommerce")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", nullable = false)
    private Integer id;

    @Column(name = "nome_completo", nullable = false, length = Integer.MAX_VALUE)
    private String nomeCompleto;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "telefone", nullable = false, length = Integer.MAX_VALUE)
    private String telefone;

    @Column(name = "data_cadastro", nullable = false)
    private OffsetDateTime dataCadastro;

}