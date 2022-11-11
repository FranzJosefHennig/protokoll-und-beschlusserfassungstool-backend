package gso.protokolltool.service;

import gso.protokolltool.model.SettingsEntity;
import gso.protokolltool.repository.SettingsRepository;
import gso.protokolltool.service.impl.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingsService implements ISettingsService {

    @Autowired
    SettingsRepository settingsRepository;

    // TODO MagicNumber entfernen -> immer erster Auszug aus der DB, da immer nur ein Schulleiter und Stellvertreter
    public Optional<SettingsEntity> findAll() {
        return settingsRepository.findById(1);
    }

    public Optional<SettingsEntity> findSettingById(Integer id) {
        return settingsRepository.findById(id);
    }

    public SettingsEntity updateSettingsById(SettingsEntity settings) {
        return settingsRepository.save(settings);
    }

}
