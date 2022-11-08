package gso.protokolltool.service.impl;

import gso.protokolltool.model.ProtokollEntity;

import java.util.List;
import java.util.Optional;

public interface IProtokollService {

    List<ProtokollEntity> findAll();

    Optional<ProtokollEntity> findById(Integer protokollId);

    ProtokollEntity updateProtokoll(ProtokollEntity protokoll);

    void deleteProtokoll(ProtokollEntity protokoll);

    ProtokollEntity createProtokoll(ProtokollEntity protokoll);

    List<ProtokollEntity> findbyWord(String word);

}

