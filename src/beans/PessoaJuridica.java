package beans;
import enums.TipoPessoa;

import java.io.Serializable;
import java.util.List;

public class PessoaJuridica extends Pessoa  implements Serializable {
    private String cnpj;
    private final TipoPessoa tipoPessoa;

    public PessoaJuridica(String nome, String cnpj, Endereco endereco, String telefone, String email, List<ContaBancaria> contas) {
        super(nome, endereco, telefone, email, contas);
        this.cnpj = cnpj;
        this.tipoPessoa = TipoPessoa.PESSOA_JURIDICA;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj=" + cnpj +
                ", tipoPessoa=" + tipoPessoa +
                '}';
    }
}