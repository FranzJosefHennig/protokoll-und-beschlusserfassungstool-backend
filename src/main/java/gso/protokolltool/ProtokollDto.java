package gso.protokolltool;

import gso.protokolltool.enums.ConferenceTypeEnum;
import gso.protokolltool.enums.ProtocolStatusEnum;
import gso.protokolltool.model.AgendaItemEntity;
import gso.protokolltool.model.ParticipantsEntity;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Data
public class ProtokollDto {

    Set<AgendaItemEntity> agendaItems;

    Set<ParticipantsEntity> participants;

    private String description;
    private String title;
    private ProtocolStatusEnum status;
    private ConferenceTypeEnum conferenceType;
    private String schoolYearBeginn;
    private Date doneDate;
    private Date creationDate;
    private String leader;
    private String room;
    private String meetingStart;
    private String meetingEnd;
    private String author;
}
