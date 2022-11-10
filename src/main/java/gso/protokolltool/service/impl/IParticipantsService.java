package gso.protokolltool.service.impl;

import gso.protokolltool.model.ParticipantsPoolEntity;

import java.util.List;

public interface IParticipantsService {

    /**
     * @return all Participants
     */
    List<ParticipantsPoolEntity> findAll();
}
