package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gso.protokolltool.enums.ConferenceTypeEnum;
import gso.protokolltool.enums.ProtocolStatusEnum;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "protokoll", schema = "gso", catalog = "ProbetoDBProd")
public class ProtokollEntity {

    @OneToMany(mappedBy = "protokoll")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonBackReference
    @Column(name = "agendaItems")
    private List<AgendaItemEntity> agendaItems;
    @OneToMany(mappedBy = "protokoll")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonBackReference
    @Column(name = "participants")
    private List<ParticipantsEntity> participants;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JoinColumn(name = "id")
    private int id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "status")
    private ProtocolStatusEnum status;
    @Basic
    @Column (name = "conferenceType")
    private ConferenceTypeEnum conferenceType;
    @Basic
    @Column(name = "schoolYearBeginn")
    private Integer schoolYearBeginn;
    @Basic
    @Column(name = "doneDate")
    private Date doneDate;
    @Basic
    @Column(name = "creationDate")
    private Date creationDate;
    @Basic
    @Column(name = "leader")
    private String leader;
    @Basic
    @Column(name = "room")
    private String room;
    @Basic
    @Column(name = "meetingStart")
    private Date meetingStart;
    @Basic
    @Column(name = "meetingEnd")
    private Date meetingEnd;
    @Basic
    @Column(name = "author")
    private String author;

    public void setTops(List<AgendaItemEntity> agendaItems) {
        this.agendaItems = agendaItems;
        addTops(agendaItems);
    }

    public void addTops(List<AgendaItemEntity> agendaItems) {
        this.agendaItems = agendaItems;
        agendaItems.forEach(topEntity -> topEntity.setProtokoll(this));
    }

    public List<AgendaItemEntity> getAgendaItems() {
        return agendaItems;
    }

    public void setAgendaItems(List<AgendaItemEntity> agendaItems) {
        this.agendaItems = agendaItems;
    }

    public List<ParticipantsEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantsEntity> participants) {
        this.participants = participants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProtocolStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ProtocolStatusEnum status) {
        this.status = status;
    }

    public ConferenceTypeEnum getConferenceType() {
        return conferenceType;
    }

    public void setConferenceType(ConferenceTypeEnum conferenceType) {
        this.conferenceType = conferenceType;
    }

    public Integer getSchoolYearBeginn() {
        return schoolYearBeginn;
    }

    public void setSchoolYearBeginn(Integer schoolYearBeginn) {
        this.schoolYearBeginn = schoolYearBeginn;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getMeetingStart() {
        return meetingStart;
    }

    public void setMeetingStart(Date meetingStart) {
        this.meetingStart = meetingStart;
    }

    public Date getMeetingEnd() {
        return meetingEnd;
    }

    public void setMeetingEnd(Date meetingEnd) {
        this.meetingEnd = meetingEnd;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtokollEntity protokoll = (ProtokollEntity) o;
        return id == protokoll.id && Objects.equals(agendaItems, protokoll.agendaItems) && Objects.equals(participants, protokoll.participants) && Objects.equals(description, protokoll.description) && Objects.equals(title, protokoll.title) && status == protokoll.status && conferenceType == protokoll.conferenceType && Objects.equals(schoolYearBeginn, protokoll.schoolYearBeginn) && Objects.equals(doneDate, protokoll.doneDate) && Objects.equals(creationDate, protokoll.creationDate) && Objects.equals(leader, protokoll.leader) && Objects.equals(room, protokoll.room) && Objects.equals(meetingStart, protokoll.meetingStart) && Objects.equals(meetingEnd, protokoll.meetingEnd) && Objects.equals(author, protokoll.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agendaItems, participants, id, description, title, status, conferenceType, schoolYearBeginn, doneDate, creationDate, leader, room, meetingStart, meetingEnd, author);
    }

    @Override
    public String toString() {
        return "ProtokollEntity{" +
                "agendaItems=" + agendaItems +
                ", participants=" + participants +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", conferenceType=" + conferenceType +
                ", schoolYearBeginn=" + schoolYearBeginn +
                ", doneDate=" + doneDate +
                ", creationDate=" + creationDate +
                ", leader=" + leader +
                ", room='" + room + '\'' +
                ", meetingStart=" + meetingStart +
                ", meetingEnd=" + meetingEnd +
                ", author=" + author +
                '}';
    }
}
