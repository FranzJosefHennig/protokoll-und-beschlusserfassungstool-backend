package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "top", schema = "gso", catalog = "ProbetoDBProd")
public class AgendaItemEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "decision")
    private String decision;

    @Basic
    @Column(name = "notes")
    private String notes;
    @Basic
    @Column(name = "protokoll_id", insertable = false, updatable = false)
    private Integer protokollId;

    @ManyToOne
    @JoinColumn(name = "protokoll_id")
    @JsonBackReference
    private ProtokollEntity protokoll;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getProtokollId() {
        return protokollId;
    }

    public void setProtokollId(Integer protokollId) {
        this.protokollId = protokollId;
    }

    public ProtokollEntity getProtokoll() {
        return protokoll;
    }

    public void setProtokoll(ProtokollEntity protokoll) {
        this.protokoll = protokoll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendaItemEntity that = (AgendaItemEntity) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(decision, that.decision) && Objects.equals(notes, that.notes) && Objects.equals(protokollId, that.protokollId) && Objects.equals(protokoll, that.protokoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, decision, notes, protokollId, protokoll);
    }

    @Override
    public String toString() {
        return "AgendaItemEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", decision='" + decision + '\'' +
                ", notes='" + notes + '\'' +
                ", protokollId=" + protokollId +
                ", protokoll=" + protokoll +
                '}';
    }
}
