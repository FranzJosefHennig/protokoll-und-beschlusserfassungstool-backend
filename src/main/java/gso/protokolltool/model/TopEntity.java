package gso.protokolltool.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "top", schema = "gso", catalog = "ProbetoDB")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopEntity topEntity = (TopEntity) o;
        return id == topEntity.id && Objects.equals(title, topEntity.title) && Objects.equals(beschluss, topEntity.beschluss) && Objects.equals(notizen, topEntity.notizen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, beschluss, id, notizen);
    }
}
