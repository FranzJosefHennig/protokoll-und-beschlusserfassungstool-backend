package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "protokoll", schema = "gso", catalog = "ProbetoDBProd")
public class ProtokollEntity {

    @OneToMany(mappedBy = "protokoll")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<TopEntity> tops;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JoinColumn(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Timestamp date;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "protokollstatus")
    private Boolean protokollstatus;
    @Basic
    @Column(name = "konferenz")
    private String konferenz;
    @Basic
    @Column(name = "schuljahr")
    private Date schuljahr;
    @Basic
    @Column(name = "donedate")
    private Date donedate;
    @Basic
    @Column(name = "creationdate")
    private Date creationdate;
    @Basic
    @Column(name = "rolle")
    private Boolean rolle;

    @Basic
    @Column(name = "rolle")
    private String raum;

    @Basic
    @Column(name = "rolle")
    private Date beginn;

    @Basic
    @Column(name = "rolle")
    private Date ende;

    @Basic
    @Column(name = "rolle")
    private String leitung;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getProtokollstatus() {
        return protokollstatus;
    }

    public void setProtokollstatus(Boolean protokollstatus) {
        this.protokollstatus = protokollstatus;
    }

    public String getKonferenz() {
        return konferenz;
    }

    public void setKonferenz(String konferenz) {
        this.konferenz = konferenz;
    }

    public Date getSchuljahr() {
        return schuljahr;
    }

    public void setSchuljahr(Date schuljahr) {
        this.schuljahr = schuljahr;
    }

    public Date getDonedate() {
        return donedate;
    }

    public void setDonedate(Date donedate) {
        this.donedate = donedate;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Boolean getRolle() {
        return rolle;
    }

    public void setRolle(Boolean rolle) {
        this.rolle = rolle;
    }

    public List<TopEntity> getTops() {
        return tops;
    }

    public void setTops(List<TopEntity> tops) {
        this.tops = tops;
        addTops(tops);
    }

    public void addTops(List<TopEntity> tops){
        this.tops = tops;
        tops.forEach(topEntity -> topEntity.setProtokoll(this));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtokollEntity protokoll = (ProtokollEntity) o;
        return id == protokoll.id && Objects.equals(date, protokoll.date) && Objects.equals(description, protokoll.description) && Objects.equals(title, protokoll.title) && Objects.equals(protokollstatus, protokoll.protokollstatus) && Objects.equals(konferenz, protokoll.konferenz) && Objects.equals(schuljahr, protokoll.schuljahr) && Objects.equals(donedate, protokoll.donedate) && Objects.equals(creationdate, protokoll.creationdate) && Objects.equals(rolle, protokoll.rolle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, title, protokollstatus, konferenz, schuljahr, donedate, creationdate, rolle);
    }
}
