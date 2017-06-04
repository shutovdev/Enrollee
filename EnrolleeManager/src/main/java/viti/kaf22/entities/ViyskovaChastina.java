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

@Entity(name="ViyskovaChastina")
@Table(name="ViyskovaChastina")
@NamedQueries({
    @NamedQuery(name="viyskovaChastina.findByNumber", query="from ViyskovaChastina i where i.number=:name")
})
public class ViyskovaChastina implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7380127174522025972L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="v_ch_id")
    private long id;

    @Column(name="nomer_v_ch", unique=true)
    private String number;


    @OneToMany(mappedBy = "viyskovaChastina", targetEntity = Abiturient.class)
    private Set<Abiturient> abiturients;

    
    

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
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
    	if(obj instanceof ViyskovaChastina)
    		return ((ViyskovaChastina)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return number;
    }
}
