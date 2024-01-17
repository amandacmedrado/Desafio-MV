package testes;

import beans.ContaBancaria;
import beans.Endereco;
import beans.PessoaJuridica;;
import negocio.ControladorPessoaJuridica;
import org.junit.Assert;
import java.util.Date;
import java.util.List;

class ControladorPessoaJuridicaTest {
    private ControladorPessoaJuridica controladorPJ = new ControladorPessoaJuridica();

    private PessoaJuridica getPessoaJuridicaResultado(){
        Endereco endereco = new Endereco("98765432101110","Rua E", "54321-877", "Cidade E", "Estado E");
        ContaBancaria conta = new ContaBancaria("98765432101110", "Cliente E", 788, 987655, 2000.0, new Date());

        PessoaJuridica pessoaJuridica = new PessoaJuridica("Empresa2", "98765432101110", endereco, "987654322", "email5@example.com", List.of(conta));

        return pessoaJuridica;
    }

    @org.junit.jupiter.api.Test
    void cadastrarPessoaJuridicaOk() {
        boolean resultadoEsperado =  true;

        boolean resultado =  controladorPJ.cadastrarPessoaJuridica(getPessoaJuridicaResultado());

        Assert.assertEquals(resultado, resultadoEsperado);

        controladorPJ.removerPessoaJuridica(getPessoaJuridicaResultado().getCnpj());
    }

    @org.junit.jupiter.api.Test
    void buscarPessoaJuridicaOk() {
        PessoaJuridica resultadoEsperado = getPessoaJuridicaResultado();

        controladorPJ.cadastrarPessoaJuridica(resultadoEsperado);
        String cnpjPessoa = resultadoEsperado.getCnpj();
        PessoaJuridica resultado =  controladorPJ.buscarPessoaJuridica(cnpjPessoa);

        Assert.assertEquals(resultado.getCnpj(), resultadoEsperado.getCnpj());

        controladorPJ.removerPessoaJuridica(cnpjPessoa);
    }
}