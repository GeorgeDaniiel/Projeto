/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author George
 */
@Entity
@Table(name = "questoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questoes.findAll", query = "SELECT q FROM Questoes q"),
    @NamedQuery(name = "Questoes.findById", query = "SELECT q FROM Questoes q WHERE q.id = :id"),
    @NamedQuery(name = "Questoes.findByAlternativaa", query = "SELECT q FROM Questoes q WHERE q.alternativaa = :alternativaa"),
    @NamedQuery(name = "Questoes.findByAlternativab", query = "SELECT q FROM Questoes q WHERE q.alternativab = :alternativab"),
    @NamedQuery(name = "Questoes.findByAlternativac", query = "SELECT q FROM Questoes q WHERE q.alternativac = :alternativac"),
    @NamedQuery(name = "Questoes.findByAlternativad", query = "SELECT q FROM Questoes q WHERE q.alternativad = :alternativad"),
    @NamedQuery(name = "Questoes.findByDescricao", query = "SELECT q FROM Questoes q WHERE q.descricao = :descricao"),
    @NamedQuery(name = "Questoes.findByAlternativaCorreta", query = "SELECT q FROM Questoes q WHERE q.alternativaCorreta = :alternativaCorreta")})
public class Questoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "alternativaa")
    private String alternativaa;
    @Column(name = "alternativab")
    private String alternativab;
    @Column(name = "alternativac")
    private String alternativac;
    @Column(name = "alternativad")
    private String alternativad;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "alternativa_correta")
    private Integer alternativaCorreta;

    public Questoes() {
    }

    public Questoes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlternativaa() {
        return alternativaa;
    }

    public void setAlternativaa(String alternativaa) {
        this.alternativaa = alternativaa;
    }

    public String getAlternativab() {
        return alternativab;
    }

    public void setAlternativab(String alternativab) {
        this.alternativab = alternativab;
    }

    public String getAlternativac() {
        return alternativac;
    }

    public void setAlternativac(String alternativac) {
        this.alternativac = alternativac;
    }

    public String getAlternativad() {
        return alternativad;
    }

    public void setAlternativad(String alternativad) {
        this.alternativad = alternativad;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(Integer alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questoes)) {
            return false;
        }
        Questoes other = (Questoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Questoes[ id=" + id + " ]";
    }
    
}
