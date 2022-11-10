package gso.protokolltool.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

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

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
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
}
