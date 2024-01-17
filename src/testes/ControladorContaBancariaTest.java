package testes;

import beans.ContaBancaria;
import negocio.ControladorContaBancaria;
import org.junit.Assert;
import java.util.Date;


class ControladorContaBancariaTest {
    private ControladorContaBancaria controladorCB = new ControladorContaBancaria();

    private ContaBancaria getContaBancariaResultado(){
        ContaBancaria conta = new ContaBancaria("123456749", "Cliente A", 123, 456789, 1000.0, new Date());

        return conta;
    }

    @org.junit.jupiter.api.Test
    void cadastrarContaOk() {
        boolean resultadoEsperado =  true;

        boolean resultado =  controladorCB.cadastrarConta(getContaBancariaResultado());

        Assert.assertEquals(resultado, resultadoEsperado);

        controladorCB.removerConta(getContaBancariaResultado().getIdCliente());
    }

    @org.junit.jupiter.api.Test
    void buscarContaBancariaOk() {
        ContaBancaria resultadoEsperado = getContaBancariaResultado();

        controladorCB.cadastrarConta(resultadoEsperado);
        String idCliente = resultadoEsperado.getIdCliente();
        ContaBancaria resultado =  controladorCB.buscarContaBancaria(idCliente);

        Assert.assertEquals(resultado.getIdCliente(), resultadoEsperado.getIdCliente());

        controladorCB.removerConta(idCliente);
    }
}