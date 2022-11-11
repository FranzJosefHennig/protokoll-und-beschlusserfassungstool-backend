package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agendaitems", schema = "gso", catalog = "ProbetoDBProd")
public class AgendaItemEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int AgendaItemId;
    private String title;
    private String decision;
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ProtokollEntity protokoll;

    public int getId() {
        return AgendaItemId;
    }

    public void setId(int AgendaItemId) {
        this.AgendaItemId = AgendaItemId;
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

    public int getAgendaItemId() {
        return AgendaItemId;
    }

    public void setAgendaItemId(int agendaItemId) {
        AgendaItemId = agendaItemId;
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
        return AgendaItemId == that.AgendaItemId && Objects.equals(title, that.title) && Objects.equals(decision, that.decision) && Objects.equals(notes, that.notes) && Objects.equals(protokoll, that.protokoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AgendaItemId, title, decision, notes, protokoll);
    }

    @Override
    public String toString() {
        return "AgendaItemEntity{" +
                "AgendaItemId=" + AgendaItemId +
                ", title='" + title + '\'' +
                ", decision='" + decision + '\'' +
                ", notes='" + notes + '\'' +
                ", protokoll=" + protokoll +
                '}';
    }
}
