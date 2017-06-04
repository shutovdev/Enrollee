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
@Entity(name = "PilgiDocument")
@Table(name = "PilgiDocument")
@NamedQueries({
    @NamedQuery(name="pilgiDocument.findByName", query="from PilgiDocument i where i.name=:name"),
    @NamedQuery(name="pilgiDocument.findByShortName", query="from PilgiDocument i where i.shortName=:name")
})
public class PilgiDocument implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6430509643986769733L;



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pdocument_id", nullable = false)
    private long id;

    @Column(name = "document_name", length = 100, unique=true)
    private String name;

    @Column(name="document_short", length=8, unique=true)
    private String shortName;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "pilgiDocument",targetEntity=Pilgi.class)
    private Set<Pilgi> pilgis;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Pilgi> getPilgis() {
		return pilgis;
	}


	public void setPilgis(Set<Pilgi> pilgis) {
		this.pilgis = pilgis;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof PilgiDocument)
			return ((PilgiDocument)obj).toString().equals(toString());
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}


	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
