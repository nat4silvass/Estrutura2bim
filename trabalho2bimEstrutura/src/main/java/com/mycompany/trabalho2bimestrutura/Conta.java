package com.mycompany.trabalho2bimestrutura;

public class Conta implements Comparable<Conta> {
    private int numero;
    private String nome;
    private Double saldoInicial;
    private double saldo;
    private double valorSaque;
    private Conta proximaConta;

    public Conta() {
    }

    public Conta(int numero, String nome, Double saldoInicial) {
        this.numero = numero;
        this.nome = nome;
        this.saldoInicial = saldoInicial;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getValorSaque() {
        return valorSaque;
    }

    public void setValorSaque(double valorSaque) {
        this.valorSaque = valorSaque;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Conta outraConta) {
        return Integer.compare(this.numero, outraConta.numero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Conta getProximaConta() {
        return proximaConta;
    }

    public void setProximaConta(Conta proximaConta) {
        this.proximaConta = proximaConta;
    }

    public double calcularSaldoTotal() {
        return calcularSaldoTotalRecursivo(this);
    }

    private double calcularSaldoTotalRecursivo(Conta conta) {
        if (conta == null) {
            return 0.0;
        }
        double saldoTotal = conta.getSaldo();
        saldoTotal += calcularSaldoTotalRecursivo(conta.getProximaConta());
        return saldoTotal;
    }

    public boolean temSaldoNegativo() {
        return saldo < 0;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", saldoInicial=" + saldoInicial +
                '}';
    }
}
