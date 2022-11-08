package gso.protokolltool.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "protokoll", schema = "gso", catalog = "ProbetoDB")
public class ProtokollEntity {

    @Getter
    @Setter
    @OneToMany(mappedBy="id")
    private Set<TopEntity> items = new java.util.LinkedHashSet<>();
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
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
    @Column(name = "creationdate")
    private Date creationDate;
    @Basic
    @Column(name = "donedate")
    private Date doneDate;
    @Basic
    @Column(name = "protokollstatus")
    private Boolean protokollstatus;
    @Basic
    @Column(name = "konferenz")
    private String konferenz;
    @Basic
    @Column(name = "schuljahr")
    private Date schuljahr;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtokollEntity protokoll = (ProtokollEntity) o;
        return id == protokoll.id && Objects.equals(date, protokoll.date) && Objects.equals(description, protokoll.description) && Objects.equals(title, protokoll.title) && Objects.equals(creationDate, protokoll.creationDate) && Objects.equals(doneDate, protokoll.doneDate) && Objects.equals(protokollstatus, protokoll.protokollstatus) && Objects.equals(konferenz, protokoll.konferenz) && Objects.equals(schuljahr, protokoll.schuljahr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, title, creationDate, doneDate, protokollstatus, konferenz, schuljahr);
    }
}
