package viti.kaf22.entities.decorator;

import viti.kaf22.entities.DisciplineZno;
import viti.kaf22.entities.Kvota;
import viti.kaf22.entities.Specialnist;

/**
 * Created by korch on 23.05.17
 */
public class InfoDataCase {
    private DisciplineZno discipline;
    private Specialnist specialnist;
    private Kvota kvota;


    public InfoDataCase() {
    }

    public DisciplineZno getDiscipline() {
        if (discipline == null){
            discipline =  new DisciplineZno();
        }
        return discipline;
    }

    public void setDiscipline(DisciplineZno discipline) {
        this.discipline = discipline;
    }

    public Specialnist getSpecialnist() {
        if (specialnist ==  null){
            specialnist =  new Specialnist();
        }
        return specialnist;
    }

    public void setSpecialnist(Specialnist specialnist) {
        this.specialnist = specialnist;
    }

    public Kvota getKvota() {
        if (kvota == null){
            kvota = new Kvota();
        }
        return kvota;
    }

    public void setKvota(Kvota kvota) {
        this.kvota = kvota;
    }

 

}
