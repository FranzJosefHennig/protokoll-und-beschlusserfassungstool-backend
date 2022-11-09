package gso.protokolltool.repository;

import gso.protokolltool.model.TopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopRepository extends JpaRepository<TopEntity, Integer> {

    /*
    @Query(
            value = "SELECT gso.top.id " +
                    "FROM gso.protokoll " +
                    "WHERE description LIKE " + " %" + ":word" + "% " +
                    "or title LIKE " + " %" + ":word" + "% " +
                    "or konferenz LIKE " + " %" + ":word" + "% "
            , nativeQuery = true
    )
    List<TopEntity> findbyWord(@Param("word") String word);

     */
}
