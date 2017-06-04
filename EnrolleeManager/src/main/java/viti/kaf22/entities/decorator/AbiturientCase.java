package viti.kaf22.entities.decorator;

import org.apache.log4j.Logger;

import viti.kaf22.entities.Abiturient;
import viti.kaf22.entities.Atestat;
import viti.kaf22.entities.NomerTelefonu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;

/**
 * Created by korch on 27.04.17
 *
 */
public class AbiturientCase {

    public static final Logger log =  Logger.getLogger(AbiturientCase.class);

    private Atestat atestat;
    private Abiturient abiturient;

    private String imya; //Imya type in abiturient
    private String prizvishche; //Prizvishche type in abiturient
    private String fatherName; //ImyaPoBatkovi type in abiturient
    private String osobovaSpravaId; //String type in abiturient
    private String navchZaklad; //NavchZacklad type in abiturient
    private String formaNavchannya;//FormaNavch type in abiturient
    private String status;
    private String stat;//Stat type in abiturient
    private String viyskoveZvanya; //Zvannya type in abiturient

    private String vChastina;//Viyskova type in abiturient
    private String chasReestr;// Timestamp typy in abiturient
    private String birth; //Date type in abiturient

    private HashSet<NomerTelefonu> phones;
    private NomerTelefonu phone;
    private String phoneNumber;

    /**
     * Boolean type in abiturient
     */
    private String profVidbir;
    private String medOglyad;
    private String fizPidgotovka;
    private String perevireno;
    private String zabrav;

    /**
     * Atestat items
     */
    private String nomerSeria;
    private double avarage12;
    private double avarage200;
    private String dataVidachi;


    public AbiturientCase(){
        log.trace("Default constructor");
        this.abiturient = new Abiturient();
        setPhones(new HashSet<NomerTelefonu>());
        setAtestat(new Atestat());
        setChasReestr();
    }

    public AbiturientCase(Abiturient abiturient) {
        if (abiturient != null) {
            this.abiturient = abiturient;
        } else {
            this.abiturient = new Abiturient();
        }
        log.trace("Created new abiturient ");
        setPhones(new HashSet<NomerTelefonu>());
        setAtestat(new Atestat());
        setChasReestr();
    }



    public String getNomerSeria() {
        if (abiturient != null && abiturient.getAtestat() != null) {
            nomerSeria = abiturient.getAtestat().getNomerSeria();
        }
        return nomerSeria;
    }

    public void setNomerSeria(String nomerSeria) {
        atestat.setNomerSeria(nomerSeria);
        abiturient.setAtestat(this.atestat);
//        abiturient.getAtestat().setNomerSeria(nomerSeria);
        this.nomerSeria = nomerSeria;
    }

    public double getAvarage12() {
        if (abiturient != null && abiturient.getAtestat() != null) {
            avarage12 = abiturient.getAtestat().getAverage12();
        }
        return avarage12;
    }

    public void setAvarage12(double avarage12) {
        atestat.setAverage12(avarage12);
        abiturient.setAtestat(this.atestat);
        this.avarage12 = avarage12;
    }

    public double getAvarage200() {
        if (abiturient != null && abiturient.getAtestat() != null) {
            avarage200 = abiturient.getAtestat().getAverage200();
        }
        return avarage200;
    }

    public void setAvarage200(double avarage200) {
        atestat.setAverage200(avarage200);
        abiturient.setAtestat(this.atestat);
        this.avarage200 = avarage200;
    }

    public Abiturient getAbiturient() {
        return abiturient;
    }

    public void setAbiturient(Abiturient abiturient) {
        this.abiturient = abiturient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String socialniyStatus) {
        this.status = socialniyStatus;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getPrizvishche() {
        return prizvishche;
    }

    public void setPrizvishche(String prizvishche) {
        this.prizvishche = prizvishche;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getOsobovaSpravaId() {
        return osobovaSpravaId;
    }

    public void setOsobovaSpravaId(String osobovaSpravaId) {
        this.osobovaSpravaId = osobovaSpravaId;
    }

    public String getNavchZaklad() {
        return navchZaklad;
    }

    public void setNavchZaklad(String navchZaklad) {
        this.navchZaklad = navchZaklad;
    }

    public String getFormaNavchannya() {
        return formaNavchannya;
    }

    public void setFormaNavchannya(String formaNavchannya) {
        this.formaNavchannya = formaNavchannya;
    }

    public String getViyskoveZvanya() {
        return viyskoveZvanya;
    }

    public void setViyskoveZvanya(String viyskoveZvanya) {
        this.viyskoveZvanya = viyskoveZvanya;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getvChastina() {
        return vChastina;
    }

    public void setvChastina(String vChastina) {
        this.vChastina = vChastina;
    }

    public String getChasReestr() {
        return chasReestr;
    }

    public void setChasReestr() {
        abiturient.setChasReestr(new Date());
        this.chasReestr = new Date().toString();
    }

    public String getBirth(){
        if (abiturient.getBirth() != null) {
            log.debug("Before formated date: " + abiturient.getBirth());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setTimeZone(TimeZone.getDefault());
            birth = dateFormat.format(dateFormat);
        }
        log.debug("After formated date: " + birth);
        return birth;
    }

    public void setBirth(String birth){
        log.debug("Before formated date: " + birth);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            abiturient.setBirth(formatter.parse(birth));
        } catch (ParseException e) {
            log.trace("Cannot formated birthday date");
            log.trace(e.getMessage());
        }
        log.debug("Success formated date to format: " + abiturient.getBirth());
        this.birth = birth;
    }

    public String getProfVidbir() {
        return profVidbir;
    }

    public void setProfVidbir(String profVidbir) {
        this.profVidbir = profVidbir;
    }

    public String getMedOglyad() {
        return medOglyad;
    }

    public void setMedOglyad(String medOglyad) {
        this.medOglyad = medOglyad;
    }

    public String getFizPidgotovka() {
        return fizPidgotovka;
    }

    public void setFizPidgotovka(String fizPidgotovka) {
        this.fizPidgotovka = fizPidgotovka;
    }

    public String getPerevireno() {
        return perevireno;
    }

    public void setPerevireno(String perevireno) {
        this.perevireno = perevireno;
    }

    public String getZabrav() {
        return zabrav;
    }

    public void setZabrav(String zabrav) {
        this.zabrav = zabrav;
    }

    public Atestat getAtestat() {
        if (abiturient.getAtestat() != null) {
            atestat = abiturient.getAtestat();
        }
        return atestat;
    }

    public void setAtestat(Atestat atestat) {
        log.trace("Attestat null?  - " + atestat.equals(null));
        abiturient.setAtestat(atestat);
        this.atestat = atestat;
        log.trace("Success created new atestat" + atestat);
    }

    public String getDataVidachi() {
        if (atestat != null) {
            log.trace("Before formated date (Atestat): " + atestat.getDataVidachi());
            if (atestat.getDataVidachi() != null) {
                dataVidachi = atestat.getDataVidachi().toString();
                String[] date = dataVidachi.split("-");
                if (date.length > 1) {
                    if (date[2].length() > 2)
                        dataVidachi = date[2].split(" ")[0] + '.' + date[1] + '.' + date[0];
                    else
                        dataVidachi = date[2] + '.' + date[1] + '.' + date[0];
                }
            }
            log.trace(dataVidachi);
        }
        return dataVidachi;
    }

    public void setDataVidachi(String dataVidachi) throws ParseException {
        log.trace("Before formated date (Atestat): " + dataVidachi);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        this.atestat.setDataVidachi(formatter.parse(dataVidachi));
        abiturient.setAtestat(this.atestat);
//        abiturient.getAtestat().setDataVidachi();
        log.trace("Success formated date to format: " + abiturient.getAtestat().getDataVidachi());
        this.dataVidachi = dataVidachi;
    }

    public HashSet<NomerTelefonu> getPhones() {
        return phones;
    }

    public void setPhones(HashSet<NomerTelefonu> phones) {
        if(phones==null)
        	this.phones=new HashSet<>();
        /*WHAT A FUCK??? IF NULL GET EXCEPTION 
    	if (phones == null) {
            phones.add(new NomerTelefonu());
        }
        */
        this.phones = phones;
    }

    public NomerTelefonu getPhone() {
        return phone;
    }

    public void setPhone(NomerTelefonu phone) {
        this.phone = phone;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
