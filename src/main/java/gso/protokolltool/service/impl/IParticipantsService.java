package gso.protokolltool.service.impl;

import gso.protokolltool.model.ParticipantsEntity;

import java.util.List;

public interface IParticipantsService {

    /**
     * @return all Participants
     */
    List<ParticipantsEntity> findAll();
}
