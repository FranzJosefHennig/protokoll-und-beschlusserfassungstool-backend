package gso.protokolltool.model;

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
    @JoinColumn(name = "id")
    private int id;

    @Column(name = "agendaItems")
    @OneToMany(mappedBy = "protokoll", cascade = CascadeType.ALL)
    private List<AgendaItemEntity> agendaItems;

   // @OneToMany(mappedBy = "protokoll")
   // @Cascade(org.hibernate.annotations.CascadeType.ALL)

    @Column(name = "participants")
    @OneToMany(mappedBy = "protokoll", cascade = CascadeType.ALL)
    private List<ParticipantsEntity> participants;



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



    public ProtokollEntity(List<ParticipantsEntity> participants) {
        this.participants = participants;
    }
    public ProtokollEntity() {

    }

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
