package com.maciejak.futurum_task.controller.converter;

import com.maciejak.futurum_task.controller.dto.TownDTO;
import com.maciejak.futurum_task.domain.Town;
import com.maciejak.futurum_task.repository.TownRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TownDTOTownConverter implements Converter<TownDTO, Town>{

    private final TownRepository townRepository;

    public TownDTOTownConverter(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Nullable
    @Override
    public Town convert(TownDTO townDTO) {
        if (townDTO == null){
            return null;
        }
        Town town = new Town();
        town.setId(townDTO.getId());
        town.setName(townDTO.getName());

        return town;
    }
}
