package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TP_ACAO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_TP_ACAO", columnNames = "NM_TP_ACAO")
})
public class TipoDeAcao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TP_ACAO")
    @SequenceGenerator(name = "SQ_TP_ACAO", sequenceName = "SQ_TP_ACAO")
    @Column(name = "ID_TP_ACAO")
    private Long id;

    @Column(name = "NM_TP_ACAO", nullable = false)
    private String nome;

    public TipoDeAcao() {
    }

    public TipoDeAcao(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public TipoDeAcao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAcao setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        return "TipoDeAcao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
