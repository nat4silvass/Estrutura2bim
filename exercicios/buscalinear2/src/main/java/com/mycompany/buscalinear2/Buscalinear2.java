package com.mycompany.buscalinear2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Buscalinear2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();

        System.out.print("Quantidade de clientes a cadastrar: ");
        int quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Código do cliente: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nome do cliente: ");
            String nome = scanner.nextLine();

            System.out.print("Data de nascimento do cliente: ");
            String dataNascimento = scanner.nextLine();

            System.out.print("CPF do cliente: ");
            String cpf = scanner.nextLine();

            Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
            clientes.add(cliente);
        }

        Collections.sort(clientes, Comparator.comparingInt(Cliente::getCodigo));

        System.out.print("Informe o código do cliente a ser pesquisado: ");
        int codigoPesquisa = scanner.nextInt();

        int indice = pesquisaBinaria(clientes, codigoPesquisa);

        if (indice != -1) {
            Cliente clienteEncontrado = clientes.get(indice);
            System.out.println("Dados do cliente encontrado:");
            System.out.println("Código: " + clienteEncontrado.getCodigo());
            System.out.println("Nome: " + clienteEncontrado.getNome());
            System.out.println("Data de Nascimento: " + clienteEncontrado.getDataNascimento());
            System.out.println("CPF: " + clienteEncontrado.getCpf());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public static int pesquisaBinaria(List<Cliente> clientes, int codigoPesquisa) {
        int esquerda = 0;
        int direita = clientes.size() - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            int codigoAtual = clientes.get(meio).getCodigo();

            if (codigoAtual == codigoPesquisa) {
                return meio;
            } else if (codigoAtual < codigoPesquisa) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
}
