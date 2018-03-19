package com.maciejak.futurum_task.controller;

import com.maciejak.futurum_task.controller.dto.KeyWordDTO;
import com.maciejak.futurum_task.service.KeyWordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/keyword")
@Slf4j
public class KeyWordController {

    private final KeyWordService keyWordService;

    public KeyWordController(KeyWordService keyWordService) {
        this.keyWordService = keyWordService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<KeyWordDTO>> getAllKeyWords(){
        List<KeyWordDTO> keyWords = keyWordService.getAllKeyWords();
        log.info("getAllKeywords called size: " + keyWords.size());
        return ResponseEntity.ok(keyWords);
    }
}
