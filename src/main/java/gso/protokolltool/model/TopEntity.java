package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "top", schema = "gso", catalog = "ProbetoDBProd")
public class TopEntity {
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "beschluss")
    private String beschluss;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "notizen")
    private String notizen;
    @Basic
    @Column(name = "protokoll_id", insertable = false, updatable = false)
    private Integer protokollId;

    @ManyToOne
    @JoinColumn(name = "protokoll_id")
    private ProtokollEntity protokoll;

    public ProtokollEntity getProtokoll() {
        return protokoll;
    }

    public void setProtokoll(ProtokollEntity protokoll) {
        this.protokoll = protokoll;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeschluss() {
        return beschluss;
    }

    public void setBeschluss(String beschluss) {
        this.beschluss = beschluss;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotizen() {
        return notizen;
    }

    public void setNotizen(String notizen) {
        this.notizen = notizen;
    }

    public Integer getProtokollId() {
        return protokollId;
    }

    public void setProtokollId(Integer protokollId) {
        this.protokollId = protokollId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopEntity top = (TopEntity) o;
        return id == top.id && Objects.equals(title, top.title) && Objects.equals(beschluss, top.beschluss) && Objects.equals(notizen, top.notizen) && Objects.equals(protokollId, top.protokollId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, beschluss, id, notizen, protokollId, protokollId);
    }
}
