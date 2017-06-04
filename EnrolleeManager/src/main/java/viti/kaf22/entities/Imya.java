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

@NamedQueries({
        @NamedQuery(name="imya.findByName", query="from Imya i where i.name=:name")
})
@Entity(name="Imya")
@Table(name="Imya")
public class Imya implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7906730444996891856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imya_id")
    private long id;

    @Column(name = "imya", unique=true, length=32)
    private String name;

    @OneToMany(mappedBy = "imya", targetEntity = Abiturient.class)
    private Set<Abiturient> abiturients;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String imya) {
        this.name = imya;
    }

    public Set<Abiturient> getAbiturients() {
        return abiturients;
    }

    public void setAbiturients(Set<Abiturient> abiturients) {
        this.abiturients = abiturients;
    }
    
    public String getLetter(){
    	return name.substring(0, 1)+".";
    }
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof Imya)
    		return ((Imya)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
}
