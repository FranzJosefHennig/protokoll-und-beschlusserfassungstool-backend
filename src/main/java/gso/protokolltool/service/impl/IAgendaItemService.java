package gso.protokolltool.service.impl;

import gso.protokolltool.model.AgendaItemEntity;

import java.util.List;
import java.util.Optional;

public interface IAgendaItemService {


    List<AgendaItemEntity> findAll();

    Optional<AgendaItemEntity> findById(Integer topId);

    AgendaItemEntity updateTop(AgendaItemEntity top);

    void deleteTop(AgendaItemEntity top);

    AgendaItemEntity createTop(AgendaItemEntity top);
    /*

    List<TopEntity> findbyWord(String word);
     */

}
