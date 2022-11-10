package gso.protokolltool.service.impl;

import gso.protokolltool.model.ProtokollEntity;

import java.util.List;
import java.util.Optional;

public interface IProtokollService {

    /**
     * returns every Protocol wihthout restrictions
     * @return List<ProtokollEntity>
     */
    List<ProtokollEntity> findAll();

    /**
     * finds an ProtokollEntity with given id
     * @param protokollId
     * @return Optional<ProtokollEntity>
     */
    Optional<ProtokollEntity> findById(Integer protokollId);

    /**
     * Updates Protocoldata incl. Agenda or Participant data
     * @param protokoll
     * @return ProtokollEntity
     */
    ProtokollEntity updateProtokoll(ProtokollEntity protokoll);

    /**
     * deletes a Protocol
     * @param protokoll
     */
    void deleteProtokoll(ProtokollEntity protokoll);

    /**
     * creates a new Protocol with auto Inc Id incl AgendaItem or Participant data
     * @param protokoll
     * @return
     */
    ProtokollEntity createProtokoll(ProtokollEntity protokoll);

    /**
     * Finds a given word in the whole DB
     * @param word
     * @return
     */
    List<ProtokollEntity> findbyWord(String word);

    /**
     * should pre select a data set of List<ProtokollEntity> for display data for a certain role
     * @param role
     * @param word
     * @return List<ProtokollEntity>
     */
    List<ProtokollEntity> findByRoleForDisplayFolder(String role, String word);

}

