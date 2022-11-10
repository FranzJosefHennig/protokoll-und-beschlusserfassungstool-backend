package gso.protokolltool.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participants", schema = "gso", catalog = "ProbetoDBProd")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long participantsId;
    String firstname;
    String lastname;

    String role;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    ProtokollEntity protokoll;


    public Long getId() {
        return participantsId;
    }

    public void setId(Long id) {
        this.participantsId = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRoles(String role) {
        this.role = role;
    }

    public Long getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(Long participantsId) {
        this.participantsId = participantsId;
    }

    public ProtokollEntity getProtokoll() {
        return protokoll;
    }

    public void setProtokoll(ProtokollEntity protokoll) {
        this.protokoll = protokoll;
    }

    @Override
    public String toString() {
        return "ParticipantsEntity{" +
                "participantsId=" + participantsId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role='" + role + '\'' +
                ", protokoll=" + protokoll +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantsEntity that = (ParticipantsEntity) o;
        return Objects.equals(participantsId, that.participantsId) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(role, that.role) && Objects.equals(protokoll, that.protokoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantsId, firstname, lastname, role, protokoll);
    }
}
