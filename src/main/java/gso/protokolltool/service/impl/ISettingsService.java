package gso.protokolltool.service.impl;

import gso.protokolltool.model.SettingsEntity;

import java.util.List;
import java.util.Optional;

public interface ISettingsService {


    /**
     * Findet alle Settings Informationen fuer den Footer
     * @return
     */
   List<SettingsEntity> findAll();

   Optional<SettingsEntity> findSettingById(Integer id);

    /**
     * Updated alle Setting Informationen fuer die jeweilige ID
     * @param settings
     * @return
     */
   SettingsEntity updateSettingsById(SettingsEntity settings);
}
