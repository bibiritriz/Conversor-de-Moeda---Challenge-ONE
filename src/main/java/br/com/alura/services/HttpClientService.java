package br.com.alura.services;

import br.com.alura.models.ConteudoAPI;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientService {
    private final Gson gson;
    private final String apiKey = "900af54e0fe523cdb509ab2e/latest/";
    private final String urlBase = "https://v6.exchangerate-api.com/v6/";

    public HttpClientService() {
        this.gson = new Gson();
    }

    public ConteudoAPI buscar(String moedaBase) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBase + apiKey + moedaBase))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        ConteudoAPI conteudo = gson.fromJson(json, ConteudoAPI.class);

        return conteudo;
    }
}
