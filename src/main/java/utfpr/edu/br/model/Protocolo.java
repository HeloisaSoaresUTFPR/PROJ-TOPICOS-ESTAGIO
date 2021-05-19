package utfpr.edu.br.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity                     //TABELA BANCO DE DADOS
@Table(name = "protocolo") // TABELA PROTOCOLO
public class Protocolo implements Serializable {
    private static final long serialVersion = 45412345343L;

    @Id                // Identifica o id da tabela
    @GeneratedValue   // gera automatico
    private Long id;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "processo")
    private String processo;

    @Column(name = "datarecebimento")
    private String dataRecebimento;

    @Column(name = "dataentrega")
    private String dataEntrega;

    @Column(name = "especificacoes")
    private String especificacoes;

    @Column(name = "novo")
    private Boolean novo;

    @Column(name = "andamento")
    private Boolean andamento;

    @Column(name = "concluido")
    private Boolean concluido;

    @Column(name = "defeito")
    private Boolean defeito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

    public void setEspecificacoes(String especificacoes) {
        this.especificacoes = especificacoes;
    }

    public Boolean getNovo() {
        return novo;
    }

    public void setNovo(Boolean novo) {
        this.novo = novo;
    }

    public Boolean getAndamento() {
        return andamento;
    }

    public void setAndamento(Boolean andamento) {
        this.andamento = andamento;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public Boolean getDefeito() {
        return defeito;
    }

    public void setDefeito(Boolean defeito) {
        this.defeito = defeito;
    }
}
