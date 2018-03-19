package com.maciejak.futurum_task.controller.converter;

import com.maciejak.futurum_task.controller.dto.KeyWordDTO;
import com.maciejak.futurum_task.domain.KeyWord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class KeyWordDTOToKeywordConverter implements Converter<KeyWordDTO, KeyWord> {
    @Nullable
    @Override
    public KeyWord convert(KeyWordDTO keyWordDTO) {
        if (keyWordDTO == null) {
            return null;
        }

        KeyWord keyWord = new KeyWord();
        keyWord.setId(keyWordDTO.getId());
        keyWord.setName(keyWordDTO.getName());

        return keyWord;
    }
}
