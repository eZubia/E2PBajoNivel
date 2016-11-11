
package mx.uach.examen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * Modelo de una película.
 * 
 * @author Erik David Zubia Hernandez
 * @version 1.0
 */
@Entity
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;
    
    private Date ano;
    
    private String sinopsis;
    
    private Boolean vigente;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, Date ano, String sinopsis, Boolean vigente) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.sinopsis = sinopsis;
        this.vigente = vigente;
    }

    public Pelicula(String titulo, Date ano, String sinopsis, Boolean vigente) {
        this.titulo = titulo;
        this.ano = ano;
        this.sinopsis = sinopsis;
        this.vigente = vigente;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
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
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s", this.getTitulo());
    }
    
}
