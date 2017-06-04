package viti.kaf22.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Set;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Entity(name="SertifikatZNO")
@Table(name = "SertifikatZNO")
@NamedQueries({
    @NamedQuery(name="sertifikatZno.findBySeriyaNomerZno", query="from SertifikatZNO i where i.seriyaNomerZno=:name")
    })
public class SertifikatZno implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1944485223536422462L;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sertifakat_id", nullable = false)
    private long id;


    @Column(name = "seriya_nomer_zno", nullable = false, unique=true, length=16)
    private String seriyaNomerZno;


    @Column(name = "data", nullable = false)
    private Date data;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "sertifikatZno", targetEntity = BalZno.class)
    private Set<BalZno> balZno;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity=Abiturient.class)
    @JoinColumn(name = "id")
    private Abiturient abiturient;

    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    	return toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	if(obj instanceof SertifikatZno)
    		return ((SertifikatZno)obj).toString().equals(toString());
    	return false;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getSeriyaNomerZno()+" date:"+formatter.format(getData());
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeriyaNomerZno() {
		return seriyaNomerZno;
	}

	public void setSeriyaNomerZno(String seriyaNomerZno) {
		this.seriyaNomerZno = seriyaNomerZno;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Set<BalZno> getBalZno() {
		return balZno;
	}

	public void setBalZno(Set<BalZno> balZno) {
		this.balZno = balZno;
	}

	public Abiturient getAbiturient() {
		return abiturient;
	}

	public void setAbiturient(Abiturient abiturient) {
		this.abiturient = abiturient;
	}
    
}