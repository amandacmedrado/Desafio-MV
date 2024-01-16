import beans.*;
import negocio.Fachada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstance();

        // Criando objetos do tipo Endereco
        Endereco endereco1 = new Endereco("Rua A", "12345-678", "Cidade A", "Estado A");
        Endereco endereco2 = new Endereco("Rua B", "54321-876", "Cidade B", "Estado B");
        Endereco endereco3 = new Endereco("Rua C", "98765-432", "Cidade C", "Estado C");
        Endereco endereco4 = new Endereco("Rua D", "12345-677", "Cidade D", "Estado D");
        Endereco endereco5 = new Endereco("Rua E", "54321-877", "Cidade E", "Estado E");

        // Criando objetos do tipo ContaBancaria
        ContaBancaria conta1 = new ContaBancaria("123456789", "Cliente A", 123, 456789, 1000.0, new Date());
        ContaBancaria conta2 = new ContaBancaria("987654321", "Cliente B", 789, 987654, 2000.0, new Date());
        ContaBancaria conta3 = new ContaBancaria("111222333", "Cliente C", 456, 123456, 3000.0, new Date());
        ContaBancaria conta4 = new ContaBancaria("12345678901100", "Cliente D", 122, 456789, 1000.0, new Date());
        ContaBancaria conta5 = new ContaBancaria("98765432101100", "Cliente E", 788, 987655, 2000.0, new Date());


        // Criando objetos do tipo PessoaFisica
        PessoaFisica pessoa1 = new PessoaFisica("Nome1", "123456789", endereco1, "123456789", "email1@example.com", List.of(conta1));
        PessoaFisica pessoa2 = new PessoaFisica("Nome2", "987654321", endereco2, "987654321", "email2@example.com", List.of(conta2));
        PessoaFisica pessoa3 = new PessoaFisica("Nome3", "111222333", endereco3, "111222333", "email3@example.com", List.of(conta3));
        // Criando objetos do tipo PessoaJuridica
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica("Empresa1", "12345678901100", endereco4, "123456788", "email4@example.com", List.of(conta4));
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica("Empresa2", "98765432101100", endereco5, "987654322", "email5@example.com", List.of(conta5));

        System.out.println("Inserindo clientes no Sistema XPTO. ");
        fachada.cadastrarPessoaFisica(pessoa1);
        fachada.cadastrarPessoaFisica(pessoa2);
        fachada.cadastrarPessoaFisica(pessoa3);
        fachada.cadastrarPessoaJuridica(pessoaJuridica1);
        fachada.cadastrarPessoaJuridica(pessoaJuridica2);

        System.out.println("\nInserindo contas no Sistema XPTO. ");
        fachada.cadastrarConta(conta1);
        fachada.cadastrarConta(conta2);
        fachada.cadastrarConta(conta3);
        fachada.cadastrarConta(conta4);
        fachada.cadastrarConta(conta5);

        System.out.println("\nIniciando Movimentações de Conta.");

        ContaBancaria contaPessoa1 = pessoa1.getContas().get(0);
        ContaBancaria contaPessoa2 = pessoa2.getContas().get(0);

        ContaBancaria contaPessoa3 = pessoa3.getContas().get(0);
        ContaBancaria contaPessoaJuridica1 = pessoaJuridica1.getContas().get(0);

        ContaBancaria contaPessoaJuridica2 = pessoaJuridica2.getContas().get(0);

        fachada.transferir(200.0, contaPessoa1, contaPessoa2);
        fachada.transferir(100.0, contaPessoa3, contaPessoa1);
        fachada.transferir(100.0, contaPessoaJuridica1, contaPessoa3);
        fachada.transferir(150.0, contaPessoa1, contaPessoaJuridica2);
        fachada.transferir(220.0, contaPessoaJuridica1, contaPessoa3);
        fachada.transferir(100.0, contaPessoaJuridica2, contaPessoaJuridica1);
        fachada.transferir(110.0, contaPessoa1, contaPessoa3);
        fachada.transferir(500.0, contaPessoaJuridica1, contaPessoa2);
        fachada.transferir(180.0, contaPessoa3, contaPessoa1);
        fachada.transferir(130.0, contaPessoa2, contaPessoaJuridica2);
        fachada.transferir(80.0, contaPessoa3, contaPessoa1);
        fachada.transferir(80.0, contaPessoaJuridica1, contaPessoa1);
        fachada.transferir(70.0, contaPessoa3, contaPessoa2);
        fachada.transferir(30.0, contaPessoaJuridica2, contaPessoa1);
        fachada.transferir(88.0, contaPessoa3, contaPessoaJuridica2);
        fachada.transferir(86.0, contaPessoaJuridica2, contaPessoa3);
        fachada.transferir(80.0, contaPessoaJuridica2, contaPessoa2);
        fachada.transferir(80.0, contaPessoa3, contaPessoaJuridica1);
        fachada.transferir(80.0, contaPessoa1, contaPessoaJuridica1);
        fachada.transferir(80.0, contaPessoa1, contaPessoa3);

        System.out.println("\nBuscando Clientes para gerar Relatório XPTO.\n");

        PessoaFisica cliente1 = fachada.buscarPessoaFisica(pessoa1.getCpf());
        PessoaFisica cliente2 = fachada.buscarPessoaFisica(pessoa3.getCpf());
        PessoaJuridica cliente3 = fachada.buscarPessoaJuridica(pessoaJuridica1.getCnpj());

        ContaBancaria contaCliente1 = fachada.buscarContaBancaria(cliente1.getCpf());
        ContaBancaria contaCliente2 = fachada.buscarContaBancaria(cliente2.getCpf());
        ContaBancaria contaCliente3 = fachada.buscarContaBancaria(cliente3.getCnpj());

        cliente1.setContas(List.of(contaCliente1));
        cliente2.setContas(List.of(contaCliente2));
        cliente3.setContas(List.of(contaCliente3));

        System.out.println(getRelatorioSaldoCliente(cliente1));
        System.out.println();
        System.out.println(getRelatorioSaldoCliente(cliente2));
        System.out.println();
        System.out.println(getRelatorioSaldoCliente(cliente3));
        System.out.println();
        System.out.println(getRelatorioSaldoClientePorPeriodo(cliente1));
        System.out.println();
        System.out.println(getRelatorioSaldoClientePorPeriodo(cliente2));
        System.out.println();
        System.out.println(getRelatorioSaldoClientePorPeriodo(cliente3));
        System.out.println();
        System.out.println(getRelatorioSaldoTodosClientes(List.of(cliente1, cliente2, cliente3)));

        System.out.println("\nDeletando clientes e contas do Sistema XPTO.\n");
        fachada.removerConta(contaCliente1.getIdConta());
        fachada.removerConta(contaCliente2.getIdConta());
        fachada.removerConta(contaCliente3.getIdConta());

        fachada.removerPessoaFisica(cliente1.getCpf());
        fachada.removerPessoaFisica(cliente2.getCpf());
        fachada.removerPessoaJuridica(cliente3.getCnpj());




    }

    private static String getRelatorioSaldoCliente(Pessoa cliente) {
        return "Relatório de Saldo do Cliente" + cliente.getNome()+
                "\nCliente: " + cliente.getNome() +
                " - Cliente desde: " + cliente.getContas().get(0).getDataAberturaConta() +
                "\nEndereço: " + cliente.getEndereco().getLogradouro() + "," + cliente.getEndereco().getCidade() + "," + cliente.getEndereco().getEstado() + "," + cliente.getEndereco().getCEP()+";" +
                "\nMovimentacões Credito: " + cliente.getContas().get(0).getMovimentacoesCredito() +
                "\nMovimentações Debito: " + cliente.getContas().get(0).getMovimentacoesDebito() +
                "\nTotal de Movimentações: " + getTotalMovimentacoes(cliente.getContas().get(0).getMovimentacoesDebito(), cliente.getContas().get(0).getMovimentacoesCredito()) +
                "\nValor Pago pelas Movimentações: " + getValorMovimentacoes(cliente.getContas().get(0).getMovimentacoesDebito(), cliente.getContas().get(0).getMovimentacoesCredito()) +
                "\nSaldo Inicial: " + cliente.getContas().get(0).getSaldoInicial() +
                "\nSaldo Atual: " + cliente.getContas().get(0).getSaldoAtual();
    }

    private static String getRelatorioSaldoClientePorPeriodo(Pessoa cliente) {
        return "Relatório de Saldo do Cliente" + cliente.getNome()+ " e período" +
                "\nPeríodo: " + cliente.getContas().get(0).getDataAberturaConta() + " a " + Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())  +
                "\nCliente: " + cliente.getNome() +
                " - Cliente desde: " + cliente.getContas().get(0).getDataAberturaConta() +
                "\nEndereço: " + cliente.getEndereco().getLogradouro() + "," + cliente.getEndereco().getCidade() + "," + cliente.getEndereco().getEstado() + "," + cliente.getEndereco().getCEP()+";" +
                "\nMovimentacões Credito: " + cliente.getContas().get(0).getMovimentacoesCredito() +
                "\nMovimentações Debito: " + cliente.getContas().get(0).getMovimentacoesDebito() +
                "\nTotal de Movimentações: " + getTotalMovimentacoes(cliente.getContas().get(0).getMovimentacoesDebito(), cliente.getContas().get(0).getMovimentacoesCredito()) +
                "\nValor Pago pelas Movimentações: " + getValorMovimentacoes(cliente.getContas().get(0).getMovimentacoesDebito(), cliente.getContas().get(0).getMovimentacoesCredito()) +
                "\nSaldo Inicial: " + cliente.getContas().get(0).getSaldoInicial() +
                "\nSaldo Atual: " + cliente.getContas().get(0).getSaldoAtual();
    }

    private static String getRelatorioSaldoTodosClientes(List<Pessoa> clientes) {
        String retornoRelatorio = "";

       for (int i = 0; i < clientes.size(); i++){
           retornoRelatorio += "\nCliente : " + clientes.get(i).getNome() + " desde: " + clientes.get(i).getContas().get(0).getDataAberturaConta() +
           " - Saldo em " + Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()) + ": " + clientes.get(i).getContas().get(0).getSaldoAtual();
       }
       return retornoRelatorio;
    }

    public static int getTotalMovimentacoes(int movimentcaoDebito, int movimentacaoCredito) {
        return movimentacaoCredito + movimentcaoDebito;
    }

    public static double getValorMovimentacoes(int movimentcaoDebito, int movimentacaoCredito) {
        int valorMovimentacoes = movimentacaoCredito + movimentcaoDebito;
        if (valorMovimentacoes <= 10)
            return valorMovimentacoes * 1;
        else if (valorMovimentacoes > 10 && valorMovimentacoes <= 20)
            return valorMovimentacoes * 0.75;
        else
            return valorMovimentacoes * 0.50;
    }
}

