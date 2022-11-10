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
            value = "SELECT gso.protokoll.id, " +
                    "gso.protokoll.author, " +
                    "gso.protokoll.conference_type, " +
                    "gso.protokoll.description, " +
                    "gso.protokoll.leader, " +
                    "gso.protokoll.room, " +
                    "gso.protokoll.title " +
                    "FROM gso.protokoll " +
                    "WHERE description LIKE " + " %"+ ":word" + "% "  +
                    "or title LIKE " + " %"+ ":word" + "% "  +
                    "or conference_type LIKE " + " %"+ ":word" + "% "+
                    "or leader LIKE " + " %"+ ":word" + "% "+
                    "or room LIKE " + " %"+ ":word" + "% "+
                    "or author LIKE " + " %"+ ":word" + "% "
            ,nativeQuery = true
    )
    List<ProtokollEntity> findbyWord(@Param("word") String word);
}
