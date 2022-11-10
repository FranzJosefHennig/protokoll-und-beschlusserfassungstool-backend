package gso.protokolltool.model;


import gso.protokolltool.enums.RoleEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participants", schema = "gso", catalog = "ProbetoDBProd")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participantsId", nullable = false)
    private Long participantsId;

    @Basic
    @Column(name = "firstName")
    String firstName;

    @Basic
    @Column(name = "lastName")
    String lastName;

    @Basic
    @Column(name = "role")
    private RoleEnum roles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ProtokollEntity protokoll;

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
        return Objects.equals(participantsId, that.participantsId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && roles == that.roles && Objects.equals(protokoll, that.protokoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantsId, firstName, lastName, roles, protokoll);
    }

    @Override
    public String toString() {
        return "ParticipantsEntity{" +
                "id=" + participantsId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                ", protokoll=" + protokoll +
                '}';
    }
}
