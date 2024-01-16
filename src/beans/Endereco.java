package beans;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String logradouro;
    private String cep;
    private String cidade;
    private String estado;

    public Endereco(String logradouro, String cep, String cidade, String estado) {
        this.logradouro = validaStringVazia(logradouro);
        this.cep = validaStringVazia(cep);
        this.cidade = validaStringVazia(cidade);
        this.estado = validaStringVazia(estado);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCEP() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    private String validaStringVazia(String input) {
        return (input != null && !input.isEmpty()) ? input : "";
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
