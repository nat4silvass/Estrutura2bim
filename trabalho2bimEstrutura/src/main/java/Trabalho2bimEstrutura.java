import com.mycompany.trabalho2bimestrutura.Conta;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Trabalho2bimEstrutura {

    public static void main(String[] args) {
        Conta c = new Conta();
        c.setNome("nata");
        c.setNumero(2331);
        c.setSaldoInicial(3455.90);

        Conta d = new Conta();
        d.setNome("Paulo");
        d.setNumero(2330);
        d.setSaldoInicial(120.00);

        Conta e = new Conta();
        e.setNome("Rodrigo");
        e.setNumero(2333);
        e.setSaldoInicial(55.90);

        c.setProximaConta(d);
        d.setProximaConta(e);

        Conta[] contas = {c, d, e};

        int opcao = 0;
        while (opcao != 5) {
            String inputOpcao = JOptionPane.showInputDialog(
                    "Selecione a opção:\n" +
                            "1. Exibir contas bancárias ordenadas\n" +
                            "2. Realizar depósito\n" +
                            "3. Realizar saque\n" +
                            "4. Calcular saldo total do banco\n" +
                            "5. Sair"
            );
            opcao = Integer.parseInt(inputOpcao);

            switch (opcao) {
                case 1:
                    exibirContasOrdenadas(contas);
                    break;
                case 2:
                    realizarDeposito(contas);
                    break;
                case 3:
                    realizarSaque(contas);
                    break;
                case 4:
                    calcularSaldoTotal(contas);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }
        }
    }

    public static void exibirContasOrdenadas(Conta[] contas) {
        Arrays.sort(contas);

        System.out.println("Contas ordenadas por número:");
        for (Conta conta : contas) {
            System.out.println("Conta: " + conta.getNome() + ", Número: " +
                    conta.getNumero());
        }
    }

    public static void realizarDeposito(Conta[] contas) {
        String inputNumeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
        int numeroConta = Integer.parseInt(inputNumeroConta);

        Conta contaEncontrada = buscaLinear(numeroConta, contas);

        if (contaEncontrada != null) {
            String inputValorDeposito = JOptionPane.showInputDialog("Digite o valor do depósito:");
            double valorDeposito = Double.parseDouble(inputValorDeposito);
            contaEncontrada.depositar(valorDeposito);
            double novoSaldo = contaEncontrada.getSaldoInicial() + valorDeposito;
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso.\nNovo saldo: " + novoSaldo);
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public static void realizarSaque(Conta[] contas) {
        String inputNumeroConta = JOptionPane.showInputDialog("Digite o número da conta:");
        int numeroConta = Integer.parseInt(inputNumeroConta);

        Conta contaEncontrada = buscaLinear(numeroConta, contas);

        if (contaEncontrada != null) {
            String inputValorSaque = JOptionPane.showInputDialog("Digite o valor do saque:");
            double valorSaque = Double.parseDouble(inputValorSaque);
            if (contaEncontrada.sacar(valorSaque)) {
                double novoSaldo = contaEncontrada.getSaldoInicial() - valorSaque;
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso.\nNovo saldo: " + novoSaldo);
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }

    public static Conta buscaLinear(int numeroConta, Conta[] contas) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public static void calcularSaldoTotal(Conta[] contas) {
        double saldoTotal = calcularSaldoTotalRecursivo(contas);
        JOptionPane.showMessageDialog(null, "Saldo total do banco: " + saldoTotal);
        
        verificarSaldoNegativo(contas);
    }

    public static double calcularSaldoTotalRecursivo(Conta[] contas) {
        double saldoTotal = 0;
        for (Conta conta : contas) {
            saldoTotal += conta.getSaldoInicial();
            if (conta.getProximaConta() != null) {
                saldoTotal += calcularSaldoTotalRecursivo(new Conta[]{conta.getProximaConta()});
            }
        }
        return saldoTotal;
    }

    public static void verificarSaldoNegativo(Conta[] contas) {
        if (verificarSaldoNegativoRecursivo(contas)) {
            JOptionPane.showMessageDialog(null, "Uma ou mais contas possuem saldo negativo.");
        } else {
            JOptionPane.showMessageDialog(null, "Todas as contas possuem saldo positivo.");
        }
    }

    public static boolean verificarSaldoNegativoRecursivo(Conta[] contas) {
        for (Conta conta : contas) {
            if (conta.getSaldoInicial() < 0) {
                JOptionPane.showMessageDialog(null, "Conta com saldo negativo:\nConta: " + conta.getNome() + ", Número: " + conta.getNumero() + ", Saldo: " + conta.getSaldoInicial());
                return true;
            }
            if (conta.getProximaConta() != null) {
                if (verificarSaldoNegativoRecursivo(new Conta[]{conta.getProximaConta()})) {
                    return true;
                }
            }
        }
        return false;
    }
}
