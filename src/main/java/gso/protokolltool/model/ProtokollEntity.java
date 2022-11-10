package gso.protokolltool.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import gso.protokolltool.enums.ConferenceTypeEnum;
import gso.protokolltool.enums.ProtocolStatusEnum;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "protokoll", schema = "gso", catalog = "ProbetoDBProd")
public class ProtokollEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "protokoll_id")
    @JsonManagedReference
    List<AgendaItemEntity> agendaItems;

    @OneToMany(cascade = CascadeType.ALL,targetEntity = ParticipantsEntity.class)
    @JoinColumn(name = "protokoll_id")
    @JsonManagedReference
    private List<ParticipantsEntity> participants;

    private String description;
    private String title;
    private ProtocolStatusEnum status;
    private ConferenceTypeEnum conferenceType;
    private Integer schoolYearBeginn;
    private Date doneDate;
    private Date creationDate;
    private String leader;
    private String room;
    private Date meetingStart;
    private Date meetingEnd;
    private String author;

    public ProtokollEntity(List<ParticipantsEntity> participants) {
        this.participants = participants;
    }
    public ProtokollEntity() {

    }

    public void setTops(List<AgendaItemEntity> agendaItems) {
        this.agendaItems = agendaItems;
        addAgendaItems(agendaItems);
    }

    public void addAgendaItems(List<AgendaItemEntity> agendaItems) {
        this.agendaItems = agendaItems;
        agendaItems.forEach(agendaItemEntity -> agendaItemEntity.setProtokoll(this));
    }

    public void setParticipants(List<ParticipantsEntity> participants) {
        this.participants = participants;
        addParticipants(participants);
    }

    public void addParticipants(List<ParticipantsEntity> participants) {
        this.participants = participants;
        participants.forEach(participantsEntity -> participantsEntity.setProtokoll(this));
    }

    public List<AgendaItemEntity> getAgendaItems() {
        return agendaItems;
    }

    public void setAgendaItems(List<AgendaItemEntity> agendaItems) {
        this.agendaItems = agendaItems;
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
}
