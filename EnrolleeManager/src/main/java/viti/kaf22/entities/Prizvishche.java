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
        @NamedQuery(name="prizvishche.findByName", query="from Prizvishche i where i.name=:name")
})
@Entity(name="Prizvishche")
@Table(name="Prizvishche")
public class Prizvishche  implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6765413608311677419L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prizv_id")
    private long id;

    @Column(name="prizvishche", unique=true, length=32)
    private String name;

    @OneToMany(mappedBy = "prizvishche", targetEntity = Abiturient.class)
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

    public void setName(String prizvishche) {
        this.name = prizvishche;
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
    	if(obj instanceof Prizvishche)
    		return ((Prizvishche)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
    
}
