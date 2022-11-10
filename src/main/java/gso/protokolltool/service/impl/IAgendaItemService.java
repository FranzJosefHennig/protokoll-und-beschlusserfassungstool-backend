package gso.protokolltool.service.impl;

import gso.protokolltool.model.AgendaItemEntity;

import java.util.List;
import java.util.Optional;

public interface IAgendaItemService {


    /**
     * returns every AgendaItem in DB
     * @return List<AgendaItemEntity>
     */
    List<AgendaItemEntity> findAll();

    /**
     * finds an AgendaItem with given Id
     * @param topId
     * @return AgendaItemEntity
     */
    Optional<AgendaItemEntity> findById(Integer topId);

    /**
     * updates an AgendaItem
     * @param top
     * @return
     */
    AgendaItemEntity updateTop(AgendaItemEntity top);

    /**
     * deletes an AgendaItem
     * @param top
     */
    void deleteTop(AgendaItemEntity top);

    /**
     * deletes an AgendaItem
     * @param top
     * @return
     */
    AgendaItemEntity createTop(AgendaItemEntity top);
}
