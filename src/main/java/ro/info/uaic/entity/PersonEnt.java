package ro.info.uaic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PersonEnt {
    @Id
    @Column
    /** p-key */
    private String id;
    @Column
    private String nume;

    public PersonEnt() { }
    public PersonEnt(String id, String nume){this.id = id; this.nume = nume;}

    /**
     * setter si getter pentru ID
     */
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    /**
     * setter si getter pentru nume
     */
    public void setNume(String nume){
        this.nume = nume;
    }
    public String getNume(){
        return nume;
    }

}
