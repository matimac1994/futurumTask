package com.maciejak.futurum_task.service.Impl;

import com.maciejak.futurum_task.controller.dto.OwnerDTO;
import com.maciejak.futurum_task.domain.Owner;
import com.maciejak.futurum_task.exception.NotFoundException;
import com.maciejak.futurum_task.repository.OwnerRepository;
import com.maciejak.futurum_task.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDTO findOwnerById(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);

        if (!owner.isPresent()){
            throw new NotFoundException("Owner not exist");
        }

        return new OwnerDTO(owner.get().getId(), owner.get().getEmeraldAccount());
    }
}
