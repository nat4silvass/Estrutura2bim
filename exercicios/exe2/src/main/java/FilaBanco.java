import java.util.Scanner;

class Cliente {
    int senha;
    String nome;
    int anoNascimento;

    public Cliente(int senha, String nome, int anoNascimento) {
        this.senha = senha;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }
}

public class FilaBanco {
    public static void main(String[] args) {
        Cliente[] filaPrioritaria = new Cliente[20];
        Cliente[] filaNormal = new Cliente[20];
        int tamanhoFilaPrioritaria = 0;
        int tamanhoFilaNormal = 0;
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Chamar próximo cliente");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o ano de nascimento do cliente: ");
                    int anoNascimento = scanner.nextInt();
                    scanner.nextLine(); 

                    Cliente novoCliente = new Cliente(
                            tamanhoFilaPrioritaria + tamanhoFilaNormal + 1,
                            nomeCliente,
                            anoNascimento
                    );
                    adicionarCliente(filaPrioritaria, filaNormal, novoCliente);
                    break;
                case 2:
                    chamarProximoCliente(filaPrioritaria, filaNormal, tamanhoFilaPrioritaria, tamanhoFilaNormal);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void adicionarCliente(Cliente[] filaPrioritaria, Cliente[] filaNormal, Cliente cliente, int tamanhoFilaPrioritaria) {
        if (cliente.anoNascimento >= 65) {
            if (filaPrioritaria.length > tamanhoFilaPrioritaria) {
                filaPrioritaria[tamanhoFilaPrioritaria] = cliente;
                tamanhoFilaPrioritaria++;
                System.out.println("Cliente \"" + cliente.nome + "\" adicionado à fila prioritária.");
            } else {
                System.out.println("A fila prioritária está cheia. Não é possível adicionar mais clientes.");
            }
        } else {
            int tamanhoFilaNormal = 0;
            if (filaNormal.length > tamanhoFilaNormal) {
                filaNormal[tamanhoFilaNormal] = cliente;
                tamanhoFilaNormal++;
                System.out.println("Cliente \"" + cliente.nome + "\" adicionado à fila normal.");
            } else {
                System.out.println("A fila normal está cheia. Não é possível adicionar mais clientes.");
            }
        }
    }

    public static void chamarProximoCliente(Cliente[] filaPrioritaria, Cliente[] filaNormal, int tamanhoFilaPrioritaria, int tamanhoFilaNormal) {
        if (tamanhoFilaPrioritaria > 0) {
            Cliente proximoCliente = filaPrioritaria[0];
            System.out.println("Chamando próximo cliente da fila prioritária: " + proximoCliente.nome);

           
            for (int i = 0; i < tamanhoFilaPrioritaria - 1; i++) {
                filaPrioritaria[i] = filaPrioritaria[i + 1];
            }
            filaPrioritaria[tamanhoFilaPrioritaria - 1] = null;

            tamanhoFilaPrioritaria--;
        } else if (tamanhoFilaNormal > 0) {
            Cliente proximoCliente = filaNormal[0];
            System.out.println("Chamando próximo cliente da fila normal: " + proximoCliente.nome);

            
            for (int i = 0; i < tamanhoFilaNormal - 1; i++) {
                filaNormal[i] = filaNormal[i + 1];
            }
            filaNormal[tamanhoFilaNormal - 1] = null;

            tamanhoFilaNormal--;
        } else {
            System.out.println("As filas estão vazias. Não há clientes para chamar.");
        }
    }

    private static void adicionarCliente(Cliente[] filaPrioritaria, Cliente[] filaNormal, Cliente novoCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
