package gso.protokolltool.converter;

import gso.protokolltool.ProtokollDto;
import gso.protokolltool.model.ProtokollEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProtokollConverter {

    public ProtokollDto convertEntityToDto(ProtokollEntity protokoll) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(protokoll, ProtokollDto.class);
    }

    public ProtokollEntity convertDtoToEntity(ProtokollDto protokollDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(protokollDto, ProtokollEntity.class);
    }
}

