package com.t_systems.ecare.eCare.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class RequiredOptionDTO {
    private int id;
    String name;
    int groupId;
    Map<Integer,List<RequiredOptionDTO>> allRequiredOption;
}
