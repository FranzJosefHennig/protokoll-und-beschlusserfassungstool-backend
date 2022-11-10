package gso.protokolltool.controller;

import gso.protokolltool.exception.ResourceNotFoundException;
import gso.protokolltool.model.ProtokollEntity;
import gso.protokolltool.service.impl.IProtokollService;
import gso.protokolltool.service.impl.IAgendaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProtokollController {

    @Autowired
    IAgendaItemService topService;
    @Autowired
    IProtokollService protokollService;

    @GetMapping("/protokoll")
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ProtokollEntity> getAllProtokoll() {

        return protokollService.findAll();

    }

    @PostMapping("/protokoll/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ProtokollEntity createProtokoll(@Validated @RequestBody ProtokollEntity protokoll) {

        protokoll.setCreationDate(Date.valueOf(LocalDate.now()));
        return protokollService.createProtokoll(protokoll);
    }

    @GetMapping("/protokoll/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ProtokollEntity> getProtokollById(@PathVariable(value = "id") Integer protokollId)
            throws ResourceNotFoundException {
        ProtokollEntity protokoll = protokollService.findById(protokollId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + protokollId));
        return ResponseEntity.ok().body(protokoll);
    }

    @PutMapping("/protokoll/update/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    ResponseEntity<ProtokollEntity> updateProtokollInfo(@PathVariable(value = "id") Integer protokollId, @Validated @RequestBody ProtokollEntity protokollInfo) throws ResourceNotFoundException {
        ProtokollEntity protokoll = protokollService.findById(protokollId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + protokollId));

        protokoll.setTitle(protokollInfo.getTitle());
        protokoll.setDescription(protokollInfo.getDescription());
        protokoll.setRoom(protokollInfo.getRoom());
        protokoll.setLeader(protokollInfo.getLeader());
        protokoll.setAuthor(protokollInfo.getAuthor());

        final ProtokollEntity updatedProtokoll = protokollService.updateProtokoll(protokoll);
        return ResponseEntity.ok(updatedProtokoll);
    }

    @DeleteMapping("protokoll/delete/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Map<String, Boolean> deleteProtokoll(@PathVariable(value = "id") Integer protokollId)
            throws ResourceNotFoundException {
        ProtokollEntity protokoll = protokollService.findById(protokollId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + protokollId));

        protokollService.deleteProtokoll(protokoll);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

    @GetMapping("protokoll/findbyword/{word}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ProtokollEntity> findbyWord(@PathVariable(value = "word") String word) {

        return protokollService.findbyWord(word);

    }
}
