package gso.protokolltool.repository;

import gso.protokolltool.model.SettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends JpaRepository<SettingsEntity, Integer> {

}
