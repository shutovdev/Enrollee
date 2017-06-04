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

@Entity(name="NavchZaklad")
@Table(name="NavchZaklad")
@NamedQueries({
    @NamedQuery(name="navchZaklad.findByName", query="from NavchZaklad i where i.name=:name")
})
public class NavchZaklad implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5438544189183458714L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="navch_zaklad_id")
    private long id;

    @Column(name="navch_zaklad", unique=true)
    private String name;

    @Column(name="licey")
    private int licey;

    @OneToMany(mappedBy = "navchZaklad", targetEntity = Abiturient.class)
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

    public void setName(String navchZaklad) {
        this.name = navchZaklad;
    }

    public int getLicey() {
        return licey;
    }

    public void setLicey(int licey) {
        this.licey = licey;
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
    	if(obj instanceof NavchZaklad)
    		return ((NavchZaklad)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
}

