package gso.protokolltool.controller;

import gso.protokolltool.exception.ResourceNotFoundException;
import gso.protokolltool.model.TopEntity;
import gso.protokolltool.service.impl.ITopService;
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
public class TopController {

    @Autowired
    ITopService topService;


    @GetMapping("/top")
    @Transactional
    public List<TopEntity> getAllTop() {

        return topService.findAll();

    }

    @PostMapping("/top/create")
    public TopEntity createTop(@Validated @RequestBody TopEntity top) {
        return topService.createTop(top);
    }

    @GetMapping("/top/{id}")
    public ResponseEntity<TopEntity> getTopById(@PathVariable(value = "id") Integer topId)
            throws ResourceNotFoundException {
        TopEntity top = topService.findById(topId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + topId));
        return ResponseEntity.ok().body(top);
    }

    @PutMapping("/top/update/{id}")
    ResponseEntity<TopEntity> updateTopInfo(@PathVariable(value = "id") Integer topId, @Validated @RequestBody TopEntity topInfo) throws ResourceNotFoundException {
        TopEntity top = topService.findById(topId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + topId));

        top.setTitle(topInfo.getTitle());
        top.setBeschluss(topInfo.getBeschluss());
        top.setNotizen(topInfo.getNotizen());

        final TopEntity updatedTop = topService.updateTop(top);
        return ResponseEntity.ok(updatedTop);
    }

    @DeleteMapping("top/delete/{id}")
    public Map<String, Boolean> deleteTop(@PathVariable(value = "id") Integer topId)
            throws ResourceNotFoundException {
        TopEntity top = topService.findById(topId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + topId));

        topService.deleteTop(top);
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
