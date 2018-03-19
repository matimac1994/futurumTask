package com.maciejak.futurum_task.repository;

import com.maciejak.futurum_task.domain.KeyWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyWordsRepository extends JpaRepository<KeyWord, Long> {
}
