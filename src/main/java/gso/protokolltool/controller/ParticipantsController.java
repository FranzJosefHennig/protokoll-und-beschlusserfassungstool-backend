package gso.protokolltool.controller;

import gso.protokolltool.model.ParticipantsPoolEntity;
import gso.protokolltool.service.impl.IParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParticipantsController {
    @Autowired
    IParticipantsService participantsService;


    @GetMapping("/participants")
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ParticipantsPoolEntity> getAllParticipants() {

        return participantsService.findAll();

    }

    @GetMapping("/participants/bla")
    @Transactional
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<ParticipantsPoolEntity> getAllParticipantss() {

        return participantsService.findAll();

    }

}
// TODO ENDPUNKTERWEITERUNG -> VISIBILTY ENDPUNKT /
// TODO SQL ANPASSEN DAS ALLES GEFUNDEN WIRD -> JOIN UEBER PARTICIPANTS UND AGENDERITEMS
// TODO