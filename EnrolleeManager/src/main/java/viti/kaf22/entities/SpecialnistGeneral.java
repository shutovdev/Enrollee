package viti.kaf22.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Entity(name="SpecialnistGeneral")
@Table(name = "SpecialnistGeneral", uniqueConstraints = { @UniqueConstraint(columnNames = { "prioritet", "id" }) })
public class SpecialnistGeneral implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8030707021894951893L;



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_gen_id", nullable = false)
    private long id;



    @Column(name = "prioritet", nullable=false)
    private byte prioritet;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity=Abiturient.class)
    @JoinColumn(name = "id")
    private Abiturient abiturient;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity=Specialnist.class)
    @JoinColumn(name = "specialnist_id")
    private Specialnist specialnist;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialnistGeneral that = (SpecialnistGeneral) o;

        if (getId() != that.getId()) return false;
        if (getPrioritet() != that.getPrioritet() ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) getId();
        result = 31 * result + getPrioritet()*1221+toString().hashCode();
        return result;
    }

    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "ID:"+getId()+" "+getPrioritet();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public Abiturient getAbiturient() {
		return abiturient;
	}

	public void setAbiturient(Abiturient abiturient) {
		this.abiturient = abiturient;
	}

	public Specialnist getSpecialnist() {
		return specialnist;
	}

	public void setSpecialnist(Specialnist specialnist) {
		this.specialnist = specialnist;
	}

	public byte getPrioritet() {
		return prioritet;
	}

	public void setPrioritet(byte prioritet) {
		this.prioritet = prioritet;
	}
}
