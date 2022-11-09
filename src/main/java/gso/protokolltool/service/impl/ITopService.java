package gso.protokolltool.service.impl;

import gso.protokolltool.model.ProtokollEntity;
import gso.protokolltool.model.TopEntity;

import java.util.List;
import java.util.Optional;

public interface ITopService {


    List<TopEntity> findAll();

    Optional<TopEntity> findById(Integer topId);

    TopEntity updateTop(TopEntity top);

    void deleteTop(TopEntity top);

    TopEntity createTop(TopEntity top);
    /*

    List<TopEntity> findbyWord(String word);
     */

}
