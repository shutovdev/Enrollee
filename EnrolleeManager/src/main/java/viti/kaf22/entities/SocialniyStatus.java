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

@Entity(name="SocialniyStatus")
@Table(name="SocialniyStatus")
@NamedQueries({
    @NamedQuery(name="socialniyStatus.findByName", query="from SocialniyStatus i where i.name=:name")
})
public class SocialniyStatus implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4383275550190136971L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="status_id")
    private long id;

    @Column(name="status", unique=true, length=20)
    private String name;

    @OneToMany(mappedBy = "status", targetEntity = Abiturient.class)
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

    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof SocialniyStatus)
    		return ((SocialniyStatus) obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
    
}

