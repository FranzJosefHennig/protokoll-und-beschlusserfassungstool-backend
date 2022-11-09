package gso.protokolltool.controller;

import gso.protokolltool.exception.ResourceNotFoundException;
import gso.protokolltool.model.SettingsEntity;
import gso.protokolltool.service.impl.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SettingsController {

    @Autowired
    ISettingsService settingsService;

    @PutMapping("/settings/update/{id}")
    ResponseEntity<SettingsEntity> updateProtokollInfo(@PathVariable(value = "id") Integer settingsId, @Validated @RequestBody SettingsEntity settingsInfo) throws ResourceNotFoundException {
        SettingsEntity setting = settingsService.findSettingById(settingsId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + settingsId));

        setting.setSchulleiter(settingsInfo.getSchulleiter());
        setting.setStellverteter(settingsInfo.getStellverteter());

        final SettingsEntity updatedSettings = settingsService.updateSettingsById(setting);
        return ResponseEntity.ok(updatedSettings);
    }

    @GetMapping("/allsettings")
    @Transactional
    public List<SettingsEntity> getAllProtokoll() {

        return settingsService.findAll();

    }
}
