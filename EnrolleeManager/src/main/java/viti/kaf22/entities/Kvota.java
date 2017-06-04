package viti.kaf22.entities;

import javax.persistence.*;

import java.io.Serializable;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Entity(name = "Kvota")
@Table(name = "Kvota")
public class Kvota implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5636158044921016803L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "kvota_id", nullable = false)
	private long id;

	@Column(name = "rik", nullable = false)
	private short rik;

	@Column(name = "kilkist_cholovik", nullable = false)
	private short kilkistCholovik;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE }, fetch = FetchType.EAGER, targetEntity=Specialnist.class)
	@JoinColumn(name = "specialnist_id", nullable = false)
	private Specialnist specialnist;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Kvota kvota = (Kvota) o;
		if(getSpecialnist()!=kvota.getSpecialnist())
			return false;
		if (getId() != kvota.getId())
			return false;
		if (getRik() !=  kvota.getRik() )
			return false;
		if (getKilkistCholovik() !=  kvota.getKilkistCholovik())
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) getId();
		result = 31 * result + (getSpecialnist()!=null? getSpecialnist().hashCode():0);
		result = 31 * result + getRik();
		result = 31 * result + getKilkistCholovik();
		return result;
	}

	public long getId() {
		return id;
	}

	public void setId(long kvotaId) {
		this.id = kvotaId;
	}

	public short getRik() {
		return rik;
	}

	public void setRik(short rik) {
		this.rik = rik;
	}

	public short getKilkistCholovik() {
		return kilkistCholovik;
	}

	public void setKilkistCholovik(short kilkistCholovik) {
		this.kilkistCholovik = kilkistCholovik;
	}

	public Specialnist getSpecialnist() {
		return specialnist;
	}

	public void setSpecialnist(Specialnist specialnist) {
		this.specialnist = specialnist;
	}

}
