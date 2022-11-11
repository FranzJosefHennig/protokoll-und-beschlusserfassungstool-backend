package gso.protokolltool.repository;

import gso.protokolltool.model.ProtokollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProtokollRepository extends JpaRepository<ProtokollEntity, Integer> {

    @Query(
            value = "SELECT gso.protokoll.id, gso.protokoll.author, gso.protokoll.conference_type, gso.protokoll.description,"+
            "gso.protokoll.leader, gso.protokoll.room, gso.protokoll.title, gso.protokoll.creation_date,"+
          "  gso.protokoll.done_date, gso.protokoll.meeting_end, gso.protokoll.meeting_start,"+
          "  gso.protokoll.school_year_beginn, gso.protokoll.status"+
          "  FROM gso.protokoll"+
          "  JOIN gso.agendaitems"+
          "  ON gso.agendaitems.agenda_item_id = gso.protokoll.id"+
           " WHERE"+
                    " protokoll.title LIKE " + " %" + ":word" + "% " +
                    "or protokoll.leader LIKE " + " %" + ":word" + "% " +
                    "or protokoll.room LIKE " + " %" + ":word" + "% " +
                    "or protokoll.school_year_beginn LIKE " + " %" + ":word" + "% " +
                    "or agendaitems.decision LIKE " + " %" + ":word" + "% "+
                    "or agendaitems.notes LIKE " + " %" + ":word" + "% "+
                    "or agendaitems.title LIKE " + " %" + ":word" + "% "
            , nativeQuery = true
    )
    List<ProtokollEntity> findbyWord(@Param("word") String word);

    @Query( value = "SELECT gso.protokoll.id, " +
            "gso.protokoll.author, " +
            "gso.protokoll.conference_type, " +
            "gso.protokoll.description, " +
            "gso.protokoll.leader, " +
            "gso.protokoll.room, " +
            "gso.protokoll.title, " +
            "gso.protokoll.creation_date, " +
            "gso.protokoll.done_date, " +
            "gso.protokoll.meeting_end, " +
            "gso.protokoll.meeting_start, " +
            "gso.protokoll.school_year_beginn, " +
            "gso.protokoll.status " +
            "FROM gso.protokoll " +
            "JOIN gso.participants ON gso.participants.particpants_id = gso.protokoll.id " +
            "JOIN gso.agendaitems ON gso.agendaitems.agenda_item_id = gso.protokoll.id " +
            "WHERE gso.participants.role = :role " +
                "or protokoll.school_year_beginn LIKE " + " %" + ":word" + "% "
            , nativeQuery = true)
    List<ProtokollEntity> findByRoleForDisplayFolder(String role, String word);
}

