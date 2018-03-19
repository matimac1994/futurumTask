package com.maciejak.futurum_task.service;

import com.maciejak.futurum_task.controller.dto.OwnerDTO;

public interface OwnerService {
    OwnerDTO findOwnerById(Long id);
}
