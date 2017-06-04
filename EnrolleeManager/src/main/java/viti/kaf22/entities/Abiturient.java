package viti.kaf22.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import viti.kaf22.entities.enums.FizPidgotovka;
import viti.kaf22.entities.enums.Forward;
import viti.kaf22.entities.enums.Medoglyad;
import viti.kaf22.entities.enums.Perevireno;
import viti.kaf22.entities.enums.Profvidbir;
import viti.kaf22.entities.enums.Zabrav;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author shkiddy
 * @since 04.05.17
 * 
 */

@Entity(name = "Abiturient")
@Table(name = "Abiturient", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "data_narodjennya", "prizv_id", "imya_id", "im_po_batkovi_id" }) })
@NamedQueries({ @NamedQuery(name = "abiturient.findBySprava", query = "from Abiturient i where i.sprava=:name") })
public class Abiturient implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1727059679068137102L;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "osobova_sprava_id")
	private String sprava;

	@Column(name = "data_narodjennya")
	private Date birth;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "prof_vidbir", nullable=false, columnDefinition="int default 0")
	private Profvidbir profVidbir = Profvidbir.None;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "med_oglyad", nullable=false, columnDefinition="int default 0")
	private Medoglyad medOlyad = Medoglyad.None;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "fiz_pidgotovka", nullable=false, columnDefinition="int default 0")
	private FizPidgotovka fizPidgotovka = FizPidgotovka.None;

	@Column(name = "chas_reestr")
	private Date chasReestr;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "perevireno", nullable=false, columnDefinition="int default 0")
	private Perevireno perevireno = Perevireno.None;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "zabrav", nullable=false, columnDefinition="int default 0")
	private Zabrav zabrav = Zabrav.None;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="forward", nullable=false, columnDefinition="int default 0")
	private Forward forward = Forward.INSTITUTE;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Prizvishche.class)
	@JoinColumn(name = "prizv_id")
	private Prizvishche prizvishche;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Imya.class)
	@JoinColumn(name = "imya_id")
	private Imya imya;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = NavchZaklad.class)
	@JoinColumn(name = "navch_zaklad_id")
	private NavchZaklad navchZaklad;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = FormaNavch.class)
	@JoinColumn(name = "froma_navch_id")
	private FormaNavch formaNavch;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Stat.class)
	@JoinColumn(name = "stat_id")
	private Stat stat;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ImyaPoBatkovi.class)
	@JoinColumn(name = "im_po_batkovi_id")
	private ImyaPoBatkovi imyaPoBatkovi;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Zvanya.class)
	@JoinColumn(name = "zvanya_id")
	private Zvanya zvan;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ViyskovaChastina.class)
	@JoinColumn(name = "v_ch_id")
	private ViyskovaChastina viyskovaChastina;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SocialniyStatus.class)
	@JoinColumn(name = "status_id")
	private SocialniyStatus status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "abiturient", targetEntity = NomerTelefonu.class)
	private Set<NomerTelefonu> nomerTelefonus;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "abiturient", targetEntity = SertifikatZno.class)
	private Set<SertifikatZno> sertifikatZnos;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "abiturient")
	private Atestat atestat;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "abiturient", targetEntity = SpecialnistGeneral.class)
	private Set<SpecialnistGeneral> specialnistGenerals;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "abiturient", targetEntity = Pilgi.class)
	private Set<Pilgi> pilgis;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSprava() {
		return sprava;
	}

	public void setSprava(String sprava) {
		this.sprava = sprava;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Profvidbir getProfVidbir() {
		return profVidbir;
	}

	public void setProfVidbir(Profvidbir profVidbir) {
		this.profVidbir = profVidbir;
	}

	public Medoglyad getMedOlyad() {
		return medOlyad;
	}

	public void setMedOlyad(Medoglyad medOlyad) {
		this.medOlyad = medOlyad;
	}

	public FizPidgotovka getFizPidgotovka() {
		return fizPidgotovka;
	}

	public void setFizPidgotovka(FizPidgotovka fizPidgotovka) {
		this.fizPidgotovka = fizPidgotovka;
	}

	public Date getChasReestr() {
		return chasReestr;
	}

	public void setChasReestr(Date chasReestr) {
		this.chasReestr = chasReestr;
	}

	public Perevireno getPerevireno() {
		return perevireno;
	}

	public void setPerevireno(Perevireno perevireno) {
		this.perevireno = perevireno;
	}

	public Zabrav getZabrav() {
		return zabrav;
	}

	public void setZabrav(Zabrav zabrav) {
		this.zabrav = zabrav;
	}

	public Prizvishche getPrizvishche() {
		return prizvishche;
	}

	public void setPrizvishche(Prizvishche prizvishche) {
		this.prizvishche = prizvishche;
	}

	public Imya getImya() {
		return imya;
	}

	public void setImya(Imya imya) {
		this.imya = imya;
	}

	public NavchZaklad getNavchZaklad() {
		return navchZaklad;
	}

	public void setNavchZaklad(NavchZaklad navchZaklad) {
		this.navchZaklad = navchZaklad;
	}

	public FormaNavch getFormaNavch() {
		return formaNavch;
	}

	public void setFormaNavch(FormaNavch formaNavch) {
		this.formaNavch = formaNavch;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public ImyaPoBatkovi getImyaPoBatkovi() {
		return imyaPoBatkovi;
	}

	public void setImyaPoBatkovi(ImyaPoBatkovi imyaPoBatkovi) {
		this.imyaPoBatkovi = imyaPoBatkovi;
	}

	public Zvanya getZvan() {
		return zvan;
	}

	public void setZvan(Zvanya zvan) {
		this.zvan = zvan;
	}

	public ViyskovaChastina getViyskovaChastina() {
		return viyskovaChastina;
	}

	public void setViyskovaChastina(ViyskovaChastina viyskovaChastina) {
		this.viyskovaChastina = viyskovaChastina;
	}

	public SocialniyStatus getStatus() {
		return status;
	}

	public void setStatus(SocialniyStatus status) {
		this.status = status;
	}

	public Set<NomerTelefonu> getNomerTelefonus() {
		return nomerTelefonus;
	}

	public void setNomerTelefonus(Set<NomerTelefonu> nomerTelefonus) {
		this.nomerTelefonus = nomerTelefonus;
	}

	public Atestat getAtestat() {
		return atestat;
	}

	public void setAtestat(Atestat atestat) {
		this.atestat = atestat;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Abiturient)
			return ((Abiturient) obj).toString().equals(toString());
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "sprava:" + sprava + " birth" + birth + " reestracia" + formatter.format(chasReestr);
	}

	public Set<SertifikatZno> getSertifikatZnos() {
		return sertifikatZnos;
	}

	public void setSertifikatZnos(Set<SertifikatZno> sertifikatZnos) {
		this.sertifikatZnos = sertifikatZnos;
	}

	public Set<SpecialnistGeneral> getSpecialnistGenerals() {
		return specialnistGenerals;
	}

	public void setSpecialnistGenerals(Set<SpecialnistGeneral> specialnistGenerals) {
		this.specialnistGenerals = specialnistGenerals;
	}

	public Forward getForward() {
		return forward;
	}

	public String getForwardName(){
		return forward.getName();
	}
	
	public void setForward(Forward forward) {
		this.forward = forward;
	}

	public Set<Pilgi> getPilgis() {
		return pilgis;
	}

	public void setPilgis(Set<Pilgi> pilgis) {
		this.pilgis = pilgis;
	}
}