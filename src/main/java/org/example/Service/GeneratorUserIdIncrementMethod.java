package org.example.Service;

import org.springframework.stereotype.Service;

@Service
public class GeneratorUserIdIncrementMethod implements GeneratorUserId {
    private Long id = 1L;

    @Override
    public Long getId() {
        return id++;
    }
}
