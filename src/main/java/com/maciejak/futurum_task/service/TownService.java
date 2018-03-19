package com.maciejak.futurum_task.service;

import com.maciejak.futurum_task.controller.dto.TownDTO;

import java.util.List;

public interface TownService {

    List<TownDTO> findAll();
}
