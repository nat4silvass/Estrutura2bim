1
import java.util.Scanner;

public class FilaClinica {
    public static void main(String[] args) {
        String[] filaPacientes = new String[20];
        int tamanhoFila = 0;
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Chamar próximo paciente");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    if (tamanhoFila < 20) {
                        System.out.print("Digite o nome do paciente: ");
                        String nomePaciente = scanner.nextLine();
                        adicionarPaciente(filaPacientes, tamanhoFila, nomePaciente);
                        tamanhoFila++;
                    } else {
                        System.out.println("A fila está cheia. Não é possível adicionar mais pacientes.");
                    }
                    break;
                case 2:
                    if (tamanhoFila > 0) {
                        chamarProximoPaciente(filaPacientes);
                        tamanhoFila--;
                    } else {
                        System.out.println("A fila está vazia. Não há pacientes para chamar.");
                    }
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

    public static void adicionarPaciente(String[] filaPacientes, int posicao, String nomePaciente) {
        filaPacientes[posicao] = nomePaciente;
        System.out.println("Paciente \"" + nomePaciente + "\" adicionado à fila.");
    }

    public static void chamarProximoPaciente(String[] filaPacientes) {
        String proximoPaciente = filaPacientes[0];
        System.out.println("Chamando próximo paciente: " + proximoPaciente);

        
        for (int i = 0; i < filaPacientes.length - 1; i++) {
            filaPacientes[i] = filaPacientes[i + 1];
        }
        filaPacientes[filaPacientes.length - 1] = null; 
    }
}
