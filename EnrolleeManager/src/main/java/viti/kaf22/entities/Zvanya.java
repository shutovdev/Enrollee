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

@Entity(name="ViyskoveZvanya")
@Table(name="ViyskoveZvanya")
@NamedQueries({
    @NamedQuery(name="zvanya.findByName", query="from ViyskoveZvanya i where i.name=:name")
})
public class Zvanya implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2445041992824136570L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="zvanya_id")
    private long id;

    @Column(name="zvanya", unique=true, length=30)
    private String name;

    @OneToMany(mappedBy = "zvan", targetEntity = Abiturient.class)
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
    	if(obj instanceof Zvanya)
    		return ((Zvanya)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
}