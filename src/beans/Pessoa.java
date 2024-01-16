package beans;

import java.io.Serializable;
import java.util.List;

public class Pessoa  implements Serializable {
        private String nome;
        private Endereco endereco;
        private String telefone;
        private String email;
        private List<ContaBancaria> contas;



        public Pessoa (String nome, Endereco endereco, String telefone, String email, List<ContaBancaria> contas) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.email = email;
            this.contas = contas;

                   }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }

}