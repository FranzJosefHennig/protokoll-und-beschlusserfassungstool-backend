package gso.protokolltool.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import gso.protokolltool.enums.RoleEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participants", schema = "gso", catalog = "ProbetoDBProd")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "firstName")
    String firstName;

    @Basic
    @Column(name = "lastName")
    String lastName;

    @Basic
    @Column(name = "role")
    private RoleEnum roles;

    @Basic
    @Column(name = "protokoll_id", insertable = false, updatable = false)
    private Integer protokollId;

    @ManyToOne
    @JoinColumn(name = "protokoll_id")
    @JsonBackReference
    private ProtokollEntity protokoll;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getProtokollId() {
        return protokollId;
    }

    public void setProtokollId(Integer protokollId) {
        this.protokollId = protokollId;
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
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && roles == that.roles && Objects.equals(protokollId, that.protokollId) && Objects.equals(protokoll, that.protokoll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, roles, protokollId, protokoll);
    }

    @Override
    public String toString() {
        return "ParticipantsEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                ", protokollId=" + protokollId +
                ", protokoll=" + protokoll +
                '}';
    }
}
