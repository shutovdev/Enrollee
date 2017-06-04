package viti.kaf22.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Random;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Entity(name="BalZNO")
@Table(name = "BalZNO")
public class BalZno implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4351719188173128458L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bal_id", nullable = false)
    private long id;


    @Column(name = "bal", nullable = false)
    private Integer bal;

    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DisciplineZno.class)
    @JoinColumn(name = "disc_id")
    private DisciplineZno disciplineZno;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SertifikatZno.class)
    @JoinColumn(name = "sertifakat_id")
    private SertifikatZno sertifikatZno;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Integer getBal() {
		return bal;
	}


	public void setBal(Integer bal) {
		this.bal = bal;
	}


	public DisciplineZno getDisciplineZno() {
		return disciplineZno;
	}


	public void setDisciplineZno(DisciplineZno disciplineZno) {
		this.disciplineZno = disciplineZno;
	}


	public SertifikatZno getSertifikatZno() {
		return sertifikatZno;
	}


	public void setSertifikatZno(SertifikatZno sertifikatZno) {
		this.sertifikatZno = sertifikatZno;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof BalZno)
			return ((BalZno)obj).toString().equals(toString());
		return false;
	}
    
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (toString()+new Random().nextInt(Integer.MAX_VALUE/100)).hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "bal:"+bal;
	}
    
}
