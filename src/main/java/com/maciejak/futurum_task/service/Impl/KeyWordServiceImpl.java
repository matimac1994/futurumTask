package com.maciejak.futurum_task.service.Impl;

import com.maciejak.futurum_task.controller.converter.KeyWordToKeyWordDTOConverter;
import com.maciejak.futurum_task.controller.dto.KeyWordDTO;
import com.maciejak.futurum_task.repository.KeyWordsRepository;
import com.maciejak.futurum_task.service.KeyWordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeyWordServiceImpl implements KeyWordService {

    private final KeyWordsRepository keyWordsRepository;
    private final KeyWordToKeyWordDTOConverter keyWordToKeyWordDTOConverter;

    public KeyWordServiceImpl(KeyWordsRepository keyWordsRepository,
                              KeyWordToKeyWordDTOConverter keyWordToKeyWordDTOConverter) {
        this.keyWordsRepository = keyWordsRepository;
        this.keyWordToKeyWordDTOConverter = keyWordToKeyWordDTOConverter;
    }

    @Override
    public List<KeyWordDTO> getAllKeyWords() {
        return keyWordsRepository
                .findAll()
                .stream()
                .map(keyWordToKeyWordDTOConverter::convert)
                .collect(Collectors.toList());
    }
}
