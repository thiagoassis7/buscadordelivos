package com.thiago.bibliotecaGutendex.dto;

import java.util.List;
import java.util.Map;

public class LivroDto {

    private String title;
    private List<String> languages;
    private int download_count;
    private List<Map<String, Object>> authors;

    public String getTitle() {
        return title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public int getDownload_count() {
        return download_count;
    }

    public List<Map<String, Object>> getAuthors() {
        return authors;
    }
}


