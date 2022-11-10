package gso.protokolltool.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import gso.protokolltool.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "participants", schema = "gso", catalog = "ProbetoDBProd")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long participantsId;
    String firstName;
    String lastName;
    private RoleEnum roles;

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
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RoleEnum getRoles() {
        return roles;
    }

    public void setRoles(RoleEnum roles) {
        this.roles = roles;
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
