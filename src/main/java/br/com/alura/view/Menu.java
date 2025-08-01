package br.com.alura.view;

import br.com.alura.models.Conversao;
import br.com.alura.services.ConversorMoeda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private final Scanner sc;
    private ConversorMoeda conversorMoeda;
    private Map<Integer, Conversao> opcaoConversao;
    private int opcao;

    public Menu (){
        this.sc = new Scanner(System.in);
        this.opcao = 0;
        this.conversorMoeda = new ConversorMoeda();
        this.opcaoConversao = Map.of(
                1,  new Conversao("USD", "ARS"),
                2,  new Conversao("ARS", "USD"),
                3,  new Conversao("USD", "BRL"),
                4,  new Conversao("BRL", "USD"),
                5,  new Conversao("USD", "COP"),
                6,  new Conversao("COP", "USD")
        );
    }

    public void mostrarOpcoes(){
        System.out.println("====================================");
        System.out.println("Bem vindo ao conversor de moedas!!!");
        System.out.println("\n");
        System.out.println("1) Dólar -> Peso argentino");
        System.out.println("2) Peso argentino -> Dólar");
        System.out.println("3) Dólar -> Real brasileiro");
        System.out.println("4) Real brasileiro -> Dólar");
        System.out.println("5) Dólar -> Peso colombiano");
        System.out.println("6) Peso colombiano -> Dólar");
        System.out.println("7) Sair");
        System.out.println("\n");
    }

    public Double lerValor(){
        sc.nextLine();
        return sc.nextDouble();
    }

    public int lerOpcao(){
        System.out.println("Escolha uma opção válida: ");

        return sc.nextInt();
    }

    public void exibirMenu() throws IOException, InterruptedException {
        while (this.opcao  != 7) {
            mostrarOpcoes();
            this.opcao = lerOpcao();
            sc.nextLine();
            if(this.opcao  < 1 || this.opcao > 7){
                System.out.println("Valor inválido");
            }else{
                if(this.opcao != 7){
                    System.out.println("====================================");
                    System.out.println("Qual o valor a ser convertido?");
                    Double valor = lerValor();
                    sc.nextLine();
                    System.out.println("====================================");
                    Double resposta = this.conversorMoeda.converter(valor, this.opcaoConversao.get(this.opcao));
                    System.out.printf("Valor final: %.2f\n", resposta);
                }else{
                    System.out.println("Programa encerrado.");
                }
            }
        }
    }
}
