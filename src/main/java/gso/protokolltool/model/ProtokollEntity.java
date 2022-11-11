package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import gso.protokolltool.enums.ConferenceTypeEnum;
import gso.protokolltool.enums.ProtocolStatusEnum;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "protokoll", schema = "gso", catalog = "ProbetoDBProd")
public class ProtokollEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "protokoll_id")
    @JsonManagedReference
    Set<AgendaItemEntity> agendaItems;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "protokoll_id")
    @JsonManagedReference
    Set<ParticipantsEntity> participants;

    private String description;
    private String title;
    private ProtocolStatusEnum status;
    private ConferenceTypeEnum conferenceType;
    private Integer schoolYearBeginn;
    private Date doneDate;
    private Date creationDate;
    private String leader;
    private String room;
    private String meetingStart;
    private String meetingEnd;
    private String author;

    public Set<AgendaItemEntity> getAgendaItems() {
        return agendaItems;
    }

    public void setAgendaItems(Set<AgendaItemEntity> agendaItems) {
        this.agendaItems = agendaItems;
    }

    public Set<ParticipantsEntity> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<ParticipantsEntity> participants) {
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

    public String getMeetingStart() {
        return meetingStart;
    }

    public void setMeetingStart(String meetingStart) {
        this.meetingStart = meetingStart;
    }

    public String getMeetingEnd() {
        return meetingEnd;
    }

    public void setMeetingEnd(String meetingEnd) {
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
        return Objects.hash(id, agendaItems, participants, description, title, status, conferenceType, schoolYearBeginn, doneDate, creationDate, leader, room, meetingStart, meetingEnd, author);
    }
}
