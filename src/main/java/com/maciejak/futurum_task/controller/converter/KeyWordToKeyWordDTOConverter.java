package com.maciejak.futurum_task.controller.converter;

import com.maciejak.futurum_task.controller.dto.KeyWordDTO;
import com.maciejak.futurum_task.domain.KeyWord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class KeyWordToKeyWordDTOConverter implements Converter<KeyWord, KeyWordDTO> {
    @Nullable
    @Override
    public KeyWordDTO convert(KeyWord keyWord) {
        if (keyWord == null){
            return null;
        }

        KeyWordDTO keyWordDTO = new KeyWordDTO();
        keyWordDTO.setId(keyWord.getId());
        keyWordDTO.setName(keyWord.getName());

        return keyWordDTO;
    }
}
