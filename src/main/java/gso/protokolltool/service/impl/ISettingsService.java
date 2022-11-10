package gso.protokolltool.service.impl;

import gso.protokolltool.model.SettingsEntity;

import java.util.Optional;

public interface ISettingsService {


    /**
     * Findet alle Settings Informationen fuer den Footer
     *
     * @return SettingsEntity
     */
   Optional<SettingsEntity> findAll();

   Optional<SettingsEntity> findSettingById(Integer id);

    /**
     * Updated alle Setting Informationen fuer die jeweilige ID
     * @param settings
     * @return SettingsEntity
     */
   SettingsEntity updateSettingsById(SettingsEntity settings);
}
