package viti.kaf22.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */

@Entity(name="FormaNavch")
@Table(name="FormaNavchannya")
@NamedQueries({
    @NamedQuery(name="formaNavch.findByTip", query="from FormaNavch i where i.tip=:name")
})
public class FormaNavch implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4631227428147540428L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "froma_navch_id", unique=true, length=32)
    private long id;

    @Column(name = "tip")
    private String tip;

    @OneToMany(mappedBy = "formaNavch", targetEntity = Abiturient.class)
    private Set<Abiturient> abiturients;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Set<Abiturient> getAbiturients() {
        return abiturients;
    }

    public void setAbiturients(Set<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }

    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	if(obj instanceof FormaNavch)
    		return ((FormaNavch)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return tip;
    }
    
}

