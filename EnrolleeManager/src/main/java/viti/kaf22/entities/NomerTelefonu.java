package viti.kaf22.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */

@Entity(name="NomerTelefonu")
@Table(name="NomerTelefonu")
public class NomerTelefonu implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4167160727731725310L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nomer_tel_id", length=10)
    private long id;

    @Column(name="nomer", unique=true)
    private String nomer;

    @ManyToOne(fetch=FetchType.LAZY, targetEntity=Abiturient.class)
    @JoinColumn(name = "id")
    private Abiturient abiturient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nomer;
    }

    public Abiturient getAbiturient() {
        return abiturient;
    }

    public void setAbiturient(Abiturient abiturient) {
        this.abiturient = abiturient;
    }
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	if(obj instanceof NomerTelefonu)
    		return ((NomerTelefonu)obj).toString().equals(toString());
    	return false;
    }
    
    public String getReadebleNomer(){
    	return String.format("(%s)%s-%s-%s", nomer.substring(0, 3), nomer.substring(3, 6), nomer.substring(6, 8), nomer.substring(8));
    }
}

