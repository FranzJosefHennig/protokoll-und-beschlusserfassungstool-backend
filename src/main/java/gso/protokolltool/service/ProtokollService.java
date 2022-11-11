package gso.protokolltool.service;

import gso.protokolltool.ProtokollDto;
import gso.protokolltool.converter.ProtokollConverter;
import gso.protokolltool.model.ProtokollEntity;
import gso.protokolltool.repository.ProtokollRepository;
import gso.protokolltool.service.impl.IProtokollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProtokollService implements IProtokollService {

    @Autowired
    ProtokollConverter protokollConverter;


    @Autowired
    private ProtokollRepository protokollRepository;

    public List<ProtokollEntity> findAll() {
        return protokollRepository.findAll();
    }

    public Optional<ProtokollEntity> findById(Integer protokollId) {
        return protokollRepository.findById(protokollId);
    }

    public ProtokollDto updateProtokoll(ProtokollDto protokollDto) {

        ProtokollEntity protokollEntity = protokollConverter.convertDtoToEntity(protokollDto);

        protokollEntity = protokollRepository.save(protokollEntity);

        return protokollConverter.convertEntityToDto(protokollEntity);
    }


    public void deleteProtokoll(ProtokollEntity protokoll) {
        protokollRepository.delete(protokoll);
    }

    public ProtokollEntity createProtokoll(ProtokollEntity protokoll) {
        return protokollRepository.save(protokoll);
    }

    @Override
    public List<ProtokollEntity> findbyWord(String word) {
        return protokollRepository.findbyWord(word);
    }

    @Override
    public List<ProtokollEntity> findByRoleForDisplayFolder(String role, String word) {
        return protokollRepository.findByRoleForDisplayFolder(role, word);
    }

    public ProtokollEntity getOnetoUpdate(Integer id) {
        return protokollRepository.getReferenceById(id);
    }

    public ProtokollDto saveProtocol(ProtokollDto protokollDto) {

        ProtokollEntity protokollEntity = protokollConverter.convertDtoToEntity(protokollDto);

        protokollEntity = protokollRepository.save(protokollEntity);

        return protokollConverter.convertEntityToDto(protokollEntity);
    }

}
