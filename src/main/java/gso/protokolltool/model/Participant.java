package gso.protokolltool.model;

import gso.protokolltool.enums.RoleEnum;
import lombok.Data;

@Data
public class Participant {

    private Long id;

    String firstName;

    String lastName;

    private RoleEnum roles;


    private Integer protokollId;

    private ProtokollEntity protokoll;
}
