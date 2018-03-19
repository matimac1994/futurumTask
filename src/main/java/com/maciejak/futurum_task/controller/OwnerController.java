package com.maciejak.futurum_task.controller;

import com.maciejak.futurum_task.controller.dto.OwnerDTO;
import com.maciejak.futurum_task.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/{ownerId}")
    @ResponseBody
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable("ownerId") Long ownerId){
        return ResponseEntity.ok(ownerService.findOwnerById(ownerId));
    }


}

