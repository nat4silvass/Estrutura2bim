import java.util.Arrays;
import java.util.Scanner;

public class BuscaLinearBinaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números a cadastrar: ");
        int quantidade = scanner.nextInt();

        int[] numeros = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite um número: ");
            numeros[i] = scanner.nextInt();
        }

        Arrays.sort(numeros);  // Ordena a lista em ordem crescente

        System.out.print("Digite 'linear' para pesquisa linear ou 'binaria' para pesquisa binária: ");
        String opcao = scanner.next();

        System.out.print("Digite o número a ser pesquisado: ");
        int numeroPesquisa = scanner.nextInt();

        int indice = -1;
        if (opcao.equals("linear")) {
            indice = buscaLinear(numeros, numeroPesquisa);
        } else if (opcao.equals("binaria")) {
            indice = buscaBinaria(numeros, numeroPesquisa);
        }

        if (indice != -1) {
            System.out.println("O número " + numeroPesquisa + " foi encontrado no índice " + indice);
        } else {
            System.out.println("O número " + numeroPesquisa + " não foi encontrado na lista.");
        }
    }

    public static int buscaLinear(int[] numeros, int numeroPesquisa) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroPesquisa) {
                return i;
            }
        }
        return -1;
    }

    public static int buscaBinaria(int[] numeros, int numeroPesquisa) {
        int esquerda = 0;
        int direita = numeros.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (numeros[meio] == numeroPesquisa) {
                return meio;
            } else if (numeros[meio] < numeroPesquisa) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}
