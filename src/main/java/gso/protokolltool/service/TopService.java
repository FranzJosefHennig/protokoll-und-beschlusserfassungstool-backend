package gso.protokolltool.service;

import gso.protokolltool.model.TopEntity;
import gso.protokolltool.repository.TopRepository;
import gso.protokolltool.service.impl.ITopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopService implements ITopService {

    @Autowired
    TopRepository topRepository;

    @Override
    public List<TopEntity> findAll() {
        return topRepository.findAll();
    }

    @Override
    public Optional<TopEntity> findById(Integer topId) {
        return topRepository.findById(topId);
    }

    @Override
    public TopEntity updateTop(TopEntity top) {
        return topRepository.save(top);
    }

    @Override
    public void deleteTop(TopEntity top) {
        topRepository.delete(top);
    }

    @Override
    public TopEntity createTop(TopEntity top) {
        return topRepository.save(top);
    }

    /*
    @Override
    public List<TopEntity> findbyWord(String word) {
        return topRepository.findbyWord(word);
    }


     */
}
