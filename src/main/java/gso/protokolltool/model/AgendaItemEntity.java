package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "agendaitems", schema = "gso", catalog = "ProbetoDBProd")
public class AgendaItemEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int AgendaItemId;
    private String title;
    private String decision;
    private String notes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
}
