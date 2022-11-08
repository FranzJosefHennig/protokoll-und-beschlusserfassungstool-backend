package gso.protokolltool.service.impl;

import gso.protokolltool.model.ProtokollEntity;
import gso.protokolltool.repository.ProtokollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProtokollService implements IProtokollService{


    @Autowired
   private ProtokollRepository protokollRepository;

    public List<ProtokollEntity> findAll(){
        return protokollRepository.findAll();
    }

    public Optional<ProtokollEntity> findById(Integer protokollId) {
        return protokollRepository.findById(protokollId);
    }

    public ProtokollEntity updateProtokoll(ProtokollEntity protokoll) {
        return protokollRepository.save(protokoll);
    }

    public void deleteProtokoll(ProtokollEntity protokoll) {
        protokollRepository.delete(protokoll);
    }

    public ProtokollEntity createProtokoll(ProtokollEntity protokoll){
       return protokollRepository.save(protokoll);
    }

    @Override
    public List<ProtokollEntity> findbyWord(String word) {
        return protokollRepository.findbyWord(word);
    }


}
