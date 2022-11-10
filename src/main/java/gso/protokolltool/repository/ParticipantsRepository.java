package gso.protokolltool.repository;

import gso.protokolltool.model.ParticipantsEntity;
import gso.protokolltool.model.ParticipantsPoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantsRepository extends JpaRepository<ParticipantsPoolEntity,Integer> {
}
