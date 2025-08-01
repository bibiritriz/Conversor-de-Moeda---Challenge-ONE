package br.com.alura.services;

import br.com.alura.models.ConteudoAPI;
import br.com.alura.models.Conversao;

import java.io.IOException;

public class ConversorMoeda {
    private HttpClientService httpClient;

    public ConversorMoeda(){
        this.httpClient = new HttpClientService();
    }

    public Double converter(Double valor, Conversao conversao) throws IOException, InterruptedException {
        ConteudoAPI conteudoAPI = this.httpClient.buscar(conversao.moedaBase());

        Double primeiroValor = conteudoAPI.conversionRates().get(conversao.moedaBase());

        System.out.println("primeiro valor: " + primeiroValor);
        Double SegundoValor = conteudoAPI.conversionRates().get(conversao.moedaDestino());
        System.out.println("segundo valor: " + SegundoValor);

        return primeiroValor * SegundoValor;
    }
}
