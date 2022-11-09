package gso.protokolltool.service;

import gso.protokolltool.model.SettingsEntity;
import gso.protokolltool.repository.SettingsRepository;
import gso.protokolltool.service.impl.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettingsService implements ISettingsService {

    @Autowired
    SettingsRepository settingsRepository;

    public List<SettingsEntity> findAll(){
        return settingsRepository.findAll();
    }

    public Optional<SettingsEntity> findSettingById(Integer id) {
        return settingsRepository.findById(id);
    }

    public SettingsEntity updateSettingsById(SettingsEntity settings) {
        return settingsRepository.save(settings);
    }

}
