package gso.protokolltool.service;

import gso.protokolltool.model.AgendaItemEntity;
import gso.protokolltool.repository.AgendaItemRepository;
import gso.protokolltool.service.impl.IAgendaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaItemService implements IAgendaItemService {

    @Autowired
    AgendaItemRepository agendaItemRepository;

    @Override
    public List<AgendaItemEntity> findAll() {
        return agendaItemRepository.findAll();
    }

    @Override
    public Optional<AgendaItemEntity> findById(Integer topId) {
        return agendaItemRepository.findById(topId);
    }

    @Override
    public AgendaItemEntity updateTop(AgendaItemEntity top) {
        return agendaItemRepository.save(top);
    }

    @Override
    public void deleteTop(AgendaItemEntity top) {
        agendaItemRepository.delete(top);
    }

    @Override
    public AgendaItemEntity createTop(AgendaItemEntity top) {
        return agendaItemRepository.save(top);
    }

    /*
    @Override
    public List<TopEntity> findbyWord(String word) {
        return topRepository.findbyWord(word);
    }


     */
}
