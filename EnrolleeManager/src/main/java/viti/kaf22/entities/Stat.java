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
@Entity(name="Stat")
@Table(name="Stat")
@NamedQueries({
    @NamedQuery(name="stat.findByName", query="from Stat i where i.name=:name")
})
public class Stat implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4435457773339604277L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stat_id")
    private long id;


    @Column(name="nazva_stati", unique=true, length=8)
    private String name;

    @OneToMany(mappedBy = "stat", targetEntity = Abiturient.class)
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

    public void setName(String nazvaStati) {
        this.name = nazvaStati;
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
    	if(obj instanceof Stat)
    		return ((Stat)obj).toString().equals(toString());
    	return false;
    }

    public String getVeryShort(){
    	return name.substring(0, 1);
    }
    
    public String getShort(){
    	return name.substring(0, 3);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
}
