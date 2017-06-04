package viti.kaf22.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

import viti.kaf22.entities.enums.TipPilgi;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */

@Entity(name="Pilgi")
@Table(name = "Pilgi", uniqueConstraints = { @UniqueConstraint(columnNames = { "seria_nomer", "date_vudan" }) })
public class Pilgi implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1757435202596317113L;

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pilga_id", nullable = false)
    private long id;



    @Column(name = "seria_nomer", nullable=false, length=16)
    private String nomer;
    
    @Column(name = "date_vudan", nullable=false)
    private Date data;

    
	@Enumerated(EnumType.ORDINAL)
	@Column(name="tip_pilgi", nullable=false, columnDefinition="int default 2")
	private TipPilgi tip_pilgi = TipPilgi.None;
    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity=Abiturient.class)
    @JoinColumn(name = "id")
    private Abiturient abiturient;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity=PilgiDocument.class)
    @JoinColumn(name = "pdocument_id")
    private PilgiDocument pilgiDocument;



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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Abiturient getAbiturient() {
		return abiturient;
	}

	public void setAbiturient(Abiturient abiturient) {
		this.abiturient = abiturient;
	}

	public PilgiDocument getPilgiDocument() {
		return pilgiDocument;
	}

	public void setPilgiDocument(PilgiDocument pilgiDocument) {
		this.pilgiDocument = pilgiDocument;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Pilgi)
			return ((Pilgi) obj).toString().equals(toString());
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nomer+" "+formatter.format(data);
	}

	public TipPilgi getTip_pilgi() {
		return tip_pilgi;
	}

	public void setTip_pilgi(TipPilgi tip_pilgi) {
		this.tip_pilgi = tip_pilgi;
	}

	public String getPilgaTipName(){
		return tip_pilgi.getName();
	}
	
}
