package viti.kaf22.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */
@Entity(name="DisciplineZNO")
@Table(name="DisciplineZNO")
@NamedQueries({
    @NamedQuery(name="disciplineZno.findByNazvaDiscipline", query="from DisciplineZNO i where i.nazvaDiscipline=:name")
    })
public class DisciplineZno implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2046903428407635527L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discipline_id", nullable = false)
    private int id;


    @Column(name = "nazva", nullable = true, length = 50, unique=true)
    private String nazvaDiscipline;


    @OneToMany(mappedBy = "disciplineZno", cascade=CascadeType.ALL, targetEntity = BalZno.class)
    private Set<BalZno> balznos;
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof DisciplineZno)
        	return ((DisciplineZno) o).toString().equals(toString());
        return false;
    }

    @Override
    public int hashCode() {
        
        return getNazvaDiscipline().hashCode();
    }

    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return getNazvaDiscipline();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazvaDiscipline() {
		return nazvaDiscipline;
	}

	public void setNazvaDiscipline(String nazvaDiscipline) {
		this.nazvaDiscipline = nazvaDiscipline;
	}
    
}
