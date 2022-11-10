package gso.protokolltool.repository;

import gso.protokolltool.model.AgendaItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaItemRepository extends JpaRepository<AgendaItemEntity, Integer> {

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
