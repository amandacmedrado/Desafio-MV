package testes;

import beans.ContaBancaria;
import beans.Endereco;
import beans.PessoaFisica;
import negocio.ControladorPessoaFisica;
import org.junit.Assert;
import java.util.Date;
import java.util.List;


class ControladorPessoaFisicaTest {
    private ControladorPessoaFisica controladorPF = new ControladorPessoaFisica();

    private PessoaFisica getPessoaFisicaResultado(){
        Endereco endereco = new Endereco("123456749","Rua A", "12345-678", "Cidade A", "Estado A");
        ContaBancaria conta = new ContaBancaria("123456749", "Cliente A", 123, 456789, 1000.0, new Date());

        PessoaFisica pessoa = new PessoaFisica("Nome1", "123456749", endereco, "123456789", "email1@example.com", List.of(conta));

        return pessoa;
    }

    @org.junit.jupiter.api.Test
    void cadastrarPessoaFisicaOk() {
        boolean resultadoEsperado =  true;

        boolean resultado =  controladorPF.cadastrarPessoaFisica(getPessoaFisicaResultado());

        Assert.assertEquals(resultado, resultadoEsperado);

        controladorPF.removerPessoaFisica(getPessoaFisicaResultado().getCpf());
    }

    @org.junit.jupiter.api.Test
    void buscarPessoaFisicaOk() {
        PessoaFisica resultadoEsperado = getPessoaFisicaResultado();

        controladorPF.cadastrarPessoaFisica(resultadoEsperado);
        String cpfPessoa = resultadoEsperado.getCpf();
        PessoaFisica resultado =  controladorPF.buscarPessoaFisica(cpfPessoa);

        Assert.assertEquals(resultado.getCpf(), resultadoEsperado.getCpf());

        controladorPF.removerPessoaFisica(cpfPessoa);
    }


}