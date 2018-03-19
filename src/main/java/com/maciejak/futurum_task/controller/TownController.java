package com.maciejak.futurum_task.controller;

import com.maciejak.futurum_task.controller.dto.TownDTO;
import com.maciejak.futurum_task.service.TownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/town")
@Slf4j
public class TownController {

    private final TownService townService;

    public TownController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<TownDTO>> findAll(){
        List<TownDTO> towns = townService.findAll();
        log.info("findAllTowns called size: " + towns.size());
        return ResponseEntity.ok(towns);
    }
}
