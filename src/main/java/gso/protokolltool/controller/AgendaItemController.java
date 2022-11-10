package gso.protokolltool.controller;

import gso.protokolltool.exception.ResourceNotFoundException;
import gso.protokolltool.model.AgendaItemEntity;
import gso.protokolltool.service.impl.IAgendaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")public class AgendaItemController {

    @Autowired
    IAgendaItemService agendaItemService;


    @GetMapping("/top")
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<AgendaItemEntity> getAllTop() {

        return agendaItemService.findAll();

    }

    @PostMapping("/top/create")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public AgendaItemEntity createTop(@Validated @RequestBody AgendaItemEntity top) {
        return agendaItemService.createTop(top);
    }

    @GetMapping("/top/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<AgendaItemEntity> getTopById(@PathVariable(value = "id") Integer topId)
            throws ResourceNotFoundException {
        AgendaItemEntity top = agendaItemService.findById(topId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + topId));
        return ResponseEntity.ok().body(top);
    }

    @PutMapping("/top/update/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    ResponseEntity<AgendaItemEntity> updateTopInfo(@PathVariable(value = "id") Integer topId, @Validated @RequestBody AgendaItemEntity topInfo) throws ResourceNotFoundException {
        AgendaItemEntity top = agendaItemService.findById(topId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + topId));

        top.setTitle(topInfo.getTitle());
        top.setDecision(topInfo.getDecision());
        top.setNotes(topInfo.getNotes());

        final AgendaItemEntity updatedTop = agendaItemService.updateTop(top);
        return ResponseEntity.ok(updatedTop);
    }

    @DeleteMapping("top/delete/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Map<String, Boolean> deleteTop(@PathVariable(value = "id") Integer topId)
            throws ResourceNotFoundException {
        AgendaItemEntity top = agendaItemService.findById(topId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + topId));

        agendaItemService.deleteTop(top);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

    /*
    @GetMapping("top/findbyword/{word}")
    public List<TopEntity> findbyWord(@PathVariable(value = "word") String word) {

        return topService.findbyWord(word);

    }

     */
}
