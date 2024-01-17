package beans;
import enums.TipoPessoa;

import java.io.Serializable;
import java.util.List;

 public class PessoaFisica extends Pessoa  implements Serializable {
     private String cpf;
     private final TipoPessoa tipoPessoa;
    public PessoaFisica(String nome, String cpf, Endereco endereco, String telefone, String email, List<ContaBancaria> contas) {
        super(nome, endereco, telefone, email, contas);
        this.cpf = cpf;
        this.tipoPessoa = TipoPessoa.PESSOA_FISICA;
    }

     public String getCpf() {
         return cpf;
     }

     public void setCpf(String cpf) {
         this.cpf = cpf;
     }

     public TipoPessoa getTipoPessoa() {
         return tipoPessoa;
     }

     @Override
     public String toString() {
         return "PessoaFisica{" +
                 "cpf=" + cpf +
                 ", nome=" + getNome() +
                 ", tipoPessoa=" + tipoPessoa +
                 ", contas="  + getContas() +
                 '}';
     }
 }

