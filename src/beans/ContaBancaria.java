package beans;

import java.io.Serializable;
import java.util.Date;
public class ContaBancaria implements Serializable {
        private int idConta;
        private String idCliente;
        private String nomeCliente;
        private int numeroAgencia;
        private int numeroConta;
        private double saldoInicial;
        private double saldoAtual;
        private int movimentacoesCredito;
        private int movimentacoesDebito;

        private Date dataAberturaConta; //verificar declaração da variável//


        public ContaBancaria(String idCliente, String nomeCliente, int numeroAgencia, int numeroConta, double saldoInicial, Date dataAberturaConta) {
                this.idCliente = idCliente;
                this.nomeCliente = nomeCliente;
                this.numeroAgencia = numeroAgencia;
                this.numeroConta = numeroConta;
                this.saldoInicial = saldoInicial;
                this.saldoAtual = saldoInicial;
                this.dataAberturaConta = dataAberturaConta;
                this.movimentacoesDebito = 0;
                this.movimentacoesCredito = 0;
        }

        public int getIdConta() {
                return idConta;
        }

        public void setIdConta(int idConta) {
                this.idConta = idConta;
        }

        public String getIdCliente() {
                return idCliente;
        }

        public void setIdCliente(String idCliente) {
                this.idCliente = idCliente;
        }

        public void setNomeCliente(String nomeCliente) {
                this.nomeCliente = nomeCliente;
        }

        public int getNumeroAgencia() {
                return numeroAgencia;
        }

        public void setNumeroAgencia(int numeroAgencia) {
                this.numeroAgencia = numeroAgencia;
        }
        public int getNumeroConta() {
                return numeroConta;
        }

        public void setNumeroConta(int numeroConta) {
                this.numeroConta = numeroConta;
        }

        public double getSaldoInicial() {
                return saldoInicial;
        }

        public void setSaldoInicial(double saldoInicial) {
                this.saldoInicial = saldoInicial;
        }

        public double getSaldoAtual() {
                return saldoAtual;
        }

        public void setSaldoAtual(double saldoAtual) {
                this.saldoAtual = saldoAtual;
        }

        public Date getDataAberturaConta() {
                return dataAberturaConta;
        }

        public void setDataAberturaConta(Date dataAberturaConta) {
                this.dataAberturaConta = dataAberturaConta;
        }

        public void setMovimentacoesCredito(){
                this.movimentacoesCredito++;
        }
        public void setMovimentacoesDebito() {
                this.movimentacoesDebito++;
        }
        public int getMovimentacoesCredito() {
                return movimentacoesCredito;
        }

        public int getMovimentacoesDebito() {
                return movimentacoesDebito;
        }

        @Override
        public String toString() {
                return "ContaBancaria{" +
                        "idCliente=" + idCliente +
                        "nomeCliente=" + nomeCliente + '\'' +
                        ", numeroAgencia=" + numeroAgencia +
                        ", numeroConta=" + numeroConta +
                        ", saldoInicial=" + saldoInicial +
                        ", dataAberturaConta=" + dataAberturaConta +
                        '}';
        }

}

