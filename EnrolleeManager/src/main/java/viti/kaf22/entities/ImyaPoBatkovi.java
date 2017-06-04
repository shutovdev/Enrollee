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
        @NamedQuery(name="imyaPoBatkovi.findByName", query="from ImyaPoBatkovi i where i.name=:name")
})
@Entity(name="ImyaPoBatkovi")
@Table(name="ImyaPoBatkovi")
public class ImyaPoBatkovi implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7726504826082478232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="im_po_batkovi_id")
    private long id;

    @Column(name="imya_po_batkovi", unique=true, length=32)
    private String name;


    @OneToMany(mappedBy = "imyaPoBatkovi", targetEntity = Abiturient.class)
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


    public void setName(String name) {
        this.name = name;
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
    	if(obj instanceof ImyaPoBatkovi)
    		return ((ImyaPoBatkovi)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
    
}
