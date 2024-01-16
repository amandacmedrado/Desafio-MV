package negocio;

import beans.PessoaJuridica;
import dados.IRepositorioPessoaJuridica;
import dados.RepositorioPessoaJuridica;

public class ControladorPessoaJuridica implements IControladorPessoaJuridica{

    private IRepositorioPessoaJuridica repositorio;

    public ControladorPessoaJuridica() {
        this.repositorio = RepositorioPessoaJuridica.getInstance();
    }
    @Override
    public boolean cadastrarPessoaJuridica(PessoaJuridica pessoa) {
        boolean resposta = false;

        if (pessoa == null) {
            System.out.println("PARAMETRO INVALIDO");
        } else {

            if (!(this.repositorio.existe(pessoa.getCnpj()))) {

                this.repositorio.cadastrar(pessoa);

                resposta = true;
                System.out.println("Pessoa Juridica cadastrada com sucesso!!");

            } else {

                System.out.println("Pessoa Jurídica não cadastrada!!");

            }
        }

        return resposta;
    }

    @Override
    public PessoaJuridica buscarPessoaJuridica(String cnpj) {
        PessoaJuridica pessoa = null;
        if (this.repositorio.buscarPessoaJuridica(cnpj) == null) {
            System.out.println("Pessoa Jurídica não existe");
        } else {
            pessoa = repositorio.buscarPessoaJuridica(cnpj);
        }
        return pessoa;
    }
    @Override
    public void removerPessoaJuridica(String cnpj) {
        boolean x = false;
        while (x == false) {

            if (cnpj != null) {
                this.repositorio.remover(cnpj);
                x = true;
                System.out.println("Pessoa Jurídica removida com sucesso!");
            } else {
                System.out.println("CNPJ INVALIDO");

            }
        }
    }
}
