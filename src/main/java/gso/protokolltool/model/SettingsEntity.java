package gso.protokolltool.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "settings", schema = "gso", catalog = "ProbetoDBProd")
public class SettingsEntity {
    @Basic
    @Column(name = "schulleiter")
    private String schulleiter;
    @Basic
    @Column(name = "stellverteter")
    private String stellverteter;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public String getSchulleiter() {
        return schulleiter;
    }

    public void setSchulleiter(String schulleiter) {
        this.schulleiter = schulleiter;
    }

    public String getStellverteter() {
        return stellverteter;
    }

    public void setStellverteter(String stellverteter) {
        this.stellverteter = stellverteter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettingsEntity that = (SettingsEntity) o;
        return id == that.id && Objects.equals(schulleiter, that.schulleiter) && Objects.equals(stellverteter, that.stellverteter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schulleiter, stellverteter, id);
    }


}
