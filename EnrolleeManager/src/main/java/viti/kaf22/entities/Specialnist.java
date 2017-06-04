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
@Entity(name = "Specialnist")
@Table(name = "Specialnist")
@NamedQueries({
    @NamedQuery(name="specialnist.findBySpecialnist", query="from Specialnist i where i.specialnist=:name"),
    @NamedQuery(name="specialnist.findByAbriviatura", query="from Specialnist i where i.abriviatura=:name")

})
public class Specialnist implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3653254148750524899L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialnist_id", nullable = false)
    private long id;

    @Column(name = "specialnist", length = 100, unique=true)
    private String specialnist;

    @Column(name = "abriviatura", length = 10, unique=true)
    private String abriviatura;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "specialnist",targetEntity=Kvota.class)
    private Set<Kvota> kvotas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "specialnist",targetEntity=SpecialnistGeneral.class)
    private Set<SpecialnistGeneral> specialnistGenerals;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialnist that = (Specialnist) o;

        if (getId() != that.getId()) return false;
        if (getSpecialnist() != null ? !getSpecialnist().equals(that.getSpecialnist()) : that.getSpecialnist() != null) return false;
        if (getAbriviatura() != null ? !getAbriviatura().equals(that.getAbriviatura()) : that.getAbriviatura() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) getId();
        result = 31 * result + (getSpecialnist() != null ? getSpecialnist().hashCode() : 0);
        result = 31 * result + (getAbriviatura() != null ? getAbriviatura().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getSpecialnist()+" OR "+getAbriviatura();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecialnist() {
		return specialnist;
	}

	public void setSpecialnist(String specialnist) {
		this.specialnist = specialnist;
	}

	public String getAbriviatura() {
		return abriviatura;
	}

	public void setAbriviatura(String abriviatura) {
		this.abriviatura = abriviatura;
	}

	public Set<Kvota> getKvotas() {
		return kvotas;
	}

	public void setKvotas(Set<Kvota> kvotas) {
		this.kvotas = kvotas;
	}

	public Set<SpecialnistGeneral> getSpecialnistGenerals() {
		return specialnistGenerals;
	}

	public void setSpecialnistGenerals(Set<SpecialnistGeneral> specialnistGenerals) {
		this.specialnistGenerals = specialnistGenerals;
	}
}
