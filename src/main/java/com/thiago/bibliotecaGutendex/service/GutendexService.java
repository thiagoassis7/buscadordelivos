package com.thiago.bibliotecaGutendex.service;

import com.thiago.bibliotecaGutendex.dto.GutendexResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GutendexService {




    private final String API_URL = "https://gutendex.com/books/";

    public GutendexResponse buscarLivros(String pesquisa) {
        RestTemplate restTemplate = new RestTemplate();
        String urlComPesquisa = API_URL + "?search=" + pesquisa;

        return restTemplate.getForObject(urlComPesquisa, GutendexResponse.class);
        }
    }


