package com.maciejak.futurum_task.controller.converter;

import com.maciejak.futurum_task.controller.dto.TownDTO;
import com.maciejak.futurum_task.domain.Town;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TownTownDTOConverter implements Converter<Town, TownDTO> {
    @Nullable
    @Override
    public TownDTO convert(Town town) {
        if (town == null){
            return null;
        }

        TownDTO townDTO = new TownDTO();
        townDTO.setId(town.getId());
        townDTO.setName(town.getName());

        return townDTO;
    }
}
