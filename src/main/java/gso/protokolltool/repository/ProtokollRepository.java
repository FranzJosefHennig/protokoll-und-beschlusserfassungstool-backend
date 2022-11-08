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
                    "gso.protokoll.date, " +
                    "gso.protokoll.description, " +
                    "gso.protokoll.title, " +
                    "gso.protokoll.creationdate, " +
                    "gso.protokoll.donedate, " +
                    "gso.protokoll.protokollstatus, " +
                    "gso.protokoll.schuljahr, " +
                    "gso.protokoll.konferenz " +
                    "FROM gso.protokoll " +
                    "WHERE description LIKE " + " %"+ ":word" + "% "  +
                    "or title LIKE " + " %"+ ":word" + "% "  +
                    "or konferenz LIKE " + " %"+ ":word" + "% "
            ,nativeQuery = true
    )
    List<ProtokollEntity> findbyWord(@Param("word") String word);
}
