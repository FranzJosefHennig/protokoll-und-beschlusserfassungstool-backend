package gso.protokolltool.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participants", schema = "gso", catalog = "ProbetoDBProd")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long particpantsId;
    String firstname;
    String lastname;

    String role;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    ProtokollEntity protokoll;

    public Long getParticpantsId() {
        return particpantsId;
    }

    public void setParticpantsId(Long particpantsId) {
        this.particpantsId = particpantsId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        ParticipantsEntity that = (ParticipantsEntity) o;
        return Objects.equals(particpantsId, that.particpantsId) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(role, that.role) && Objects.equals(protokoll, that.protokoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(particpantsId, firstname, lastname, role, protokoll);
    }
}
