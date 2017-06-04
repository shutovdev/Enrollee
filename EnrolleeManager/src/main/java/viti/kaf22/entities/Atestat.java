package viti.kaf22.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shkiddy
 * @since 04.05.17
 */

@Entity(name = "Atestat")
@Table(name = "Atestat")
@NamedQueries({
        @NamedQuery(name = "atestat.findByNomerSeria", query = "from Atestat i where i.nomerSeria=:name"),
        @NamedQuery(name = "atestat.findByAbiturient", query = "from Atestat i where i.abiturient=:name")
})
public class Atestat implements Serializable {

    private static final long serialVersionUID = 1032613857068404829L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atestat_id")
    private long id;

    @Column(name = "nomer_seria_atest", unique = true, length = 16)
    private String nomerSeria;

    @Column(name = "data_vidachi")
    private Date dataVidachi;

    @Column(name = "seredniy_bal_12")
    private double average12;

    @Column(name = "seredniy_bal_200")
    private double average200;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Abiturient abiturient;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomerSeria() {
        return nomerSeria;
    }

    public String getNomer() {
        return nomerSeria.substring(2);
    }

    public String getSeria() {
        return nomerSeria.substring(0, 2);
    }

    public void setNomerSeria(String nomerSeria) {
        this.nomerSeria = nomerSeria;
    }

    public Date getDataVidachi() {
        return dataVidachi;
    }

    public void setDataVidachi(Date dataVidachi) {
        this.dataVidachi = dataVidachi;
    }

    public double getAverage12() {
        return average12;
    }

    public void setAverage12(double average12) {
        this.average12 = average12;
    }

    public double getAverage200() {
        return average200;
    }

    public void setAverage200(double average200) {
        this.average200 = average200;
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
        if (obj instanceof Atestat)
            return ((Atestat) obj).toString().equals(toString());
        return false;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Atestat:" + nomerSeria + " av12:" + average12 + " av200:" + average200;
    }
}
