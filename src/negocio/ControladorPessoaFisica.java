package negocio;

import beans.ContaBancaria;
import beans.PessoaFisica;
import dados.IRepositorioPessoaFisica;
import dados.RepositorioPessoaFisica;

public class ControladorPessoaFisica implements IControladorPessoaFisica {
    private IRepositorioPessoaFisica repositorio;
    public ControladorPessoaFisica() {
        this.repositorio = RepositorioPessoaFisica.getInstance();
    }
    @Override
    public boolean cadastrarPessoaFisica(PessoaFisica pessoa) {
        boolean resposta = false;

        if (pessoa == null) {
            System.out.println("PARAMETRO INVALIDO");
        } else {

            if (!(this.repositorio.existe(pessoa.getCpf()))) {

                this.repositorio.cadastrar(pessoa);

                resposta = true;
                System.out.println("Pessoa cadastrada com sucesso!!");
            } else {

                System.out.println("Pessoa não cadastrada!!");

            }
        }

        return resposta;
    }

    @Override
    public PessoaFisica buscarPessoaFisica(String cpf) {
        PessoaFisica pessoa = null;
        if (this.repositorio.buscarPessoaFisica(cpf) == null) {
            System.out.println("Pessoa Física não existe");
        } else {
            pessoa = repositorio.buscarPessoaFisica(cpf);
        }
        return pessoa;
    }

    @Override
    public void removerPessoaFisica(String cpf) {
        boolean x = false;
        while (x == false) {

            if (cpf != null) {
                this.repositorio.remover(cpf);
                x = true;
                System.out.println("Pessoa Física removida com sucesso!");
            } else {
                System.out.println("CPF INVALIDO");

            }
        }
    }
}