package com.maciejak.futurum_task.service.Impl;

import com.maciejak.futurum_task.controller.converter.TownDTOTownConverter;
import com.maciejak.futurum_task.controller.converter.TownTownDTOConverter;
import com.maciejak.futurum_task.controller.dto.TownDTO;
import com.maciejak.futurum_task.repository.TownRepository;
import com.maciejak.futurum_task.service.TownService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final TownTownDTOConverter townTownDTOConverter;
    private final TownDTOTownConverter townDTOTownConverter;

    public TownServiceImpl(TownRepository townRepository,
                           TownTownDTOConverter townTownDTOConverter,
                           TownDTOTownConverter townDTOTownConverter) {
        this.townRepository = townRepository;
        this.townTownDTOConverter = townTownDTOConverter;
        this.townDTOTownConverter = townDTOTownConverter;
    }

    @Override
    public List<TownDTO> findAll() {
        return townRepository
                .findAll()
                .stream()
                .map(townTownDTOConverter::convert)
                .collect(Collectors.toList());
    }
}
