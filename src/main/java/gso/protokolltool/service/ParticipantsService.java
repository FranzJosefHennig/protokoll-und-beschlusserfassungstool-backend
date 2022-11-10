package gso.protokolltool.service;

import gso.protokolltool.model.ParticipantsEntity;
import gso.protokolltool.repository.ParticipantsRepository;
import gso.protokolltool.service.impl.IParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantsService implements IParticipantsService {

    @Autowired
    ParticipantsRepository participantsRepository;

    @Override
    public List<ParticipantsEntity> findAll() {
        return participantsRepository.findAll();
    }
}
