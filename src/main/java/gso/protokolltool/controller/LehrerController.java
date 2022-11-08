package gso.protokolltool.controller;

import gso.protokolltool.exception.ResourceNotFoundException;
import gso.protokolltool.model.ProtokollEntity;
import gso.protokolltool.service.impl.IProtokollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LehrerController {

    @Autowired
    IProtokollService protokollService;

    @GetMapping("/protokoll")
    @Transactional
    public List<ProtokollEntity> getAllProtokoll() {

        return protokollService.findAll();

    }

    @PostMapping("/protokoll/create")
    public ProtokollEntity createProtokoll(@Validated @RequestBody ProtokollEntity protokoll) {
        return protokollService.createProtokoll(protokoll);
    }

    @GetMapping("/protokoll/{id}")
    public ResponseEntity<ProtokollEntity> getProtokollById(@PathVariable(value = "id") Integer protokollId)
            throws ResourceNotFoundException {
        ProtokollEntity protokoll = protokollService.findById(protokollId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + protokollId));
        return ResponseEntity.ok().body(protokoll);
    }

    @PutMapping("/protokoll/update/{id}")
    ResponseEntity<ProtokollEntity> updateProtokollInfo(@PathVariable(value = "id") Integer protokollId, @Validated @RequestBody ProtokollEntity protokollInfo) throws ResourceNotFoundException {
        ProtokollEntity protokoll = protokollService.findById(protokollId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + protokollId));

        protokoll.setTitle(protokollInfo.getTitle());
        protokoll.setDate(protokollInfo.getDate());
        protokoll.setDescription(protokollInfo.getDescription());
        // TODO WEITERE INFOS HINZUFUEGEN?

        final ProtokollEntity updatedProtokoll = protokollService.updateProtokoll(protokoll);
        return ResponseEntity.ok(updatedProtokoll);
    }

    @DeleteMapping("protokoll/delete/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer protokollId)
            throws ResourceNotFoundException {
        ProtokollEntity protokoll = protokollService.findById(protokollId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + protokollId));

        protokollService.deleteProtokoll(protokoll);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

    @GetMapping("protokoll/findbyword/{word}")
    public List<ProtokollEntity> findbyWord(@PathVariable(value = "word") String word) {

        return protokollService.findbyWord(word);

    }
}
