/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author guiga
 */
@Entity
public class Poid implements Serializable {
    private static long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int minPoid;
    private int maxpoid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poid)) {
            return false;
        }
        Poid other = (Poid) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeles.Poid[id=" + getId() + "]";
    }

    /**
     * @return the minPoid
     */
    public int getMinPoid() {
        return minPoid;
    }

    /**
     * @param minPoid the minPoid to set
     */
    public void setMinPoid(int minPoid) {
        this.minPoid = minPoid;
    }

    /**
     * @return the maxpoid
     */
    public int getMaxpoid() {
        return maxpoid;
    }

    /**
     * @param maxpoid the maxpoid to set
     */
    public void setMaxpoid(int maxpoid) {
        this.maxpoid = maxpoid;
    }

}
