package dados;

import beans.PessoaFisica;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class RepositorioPessoaFisica implements IRepositorioPessoaFisica, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private List<PessoaFisica> pessoas;

    private static RepositorioPessoaFisica instance;

    public RepositorioPessoaFisica() {
        this.pessoas = new ArrayList<PessoaFisica>();

    }

    public static RepositorioPessoaFisica getInstance() {
        if (instance == null) {
            {
                if (ler() == null) {
                    instance = new RepositorioPessoaFisica();
                } else {
                    instance = (RepositorioPessoaFisica) ler();
                }
            }

        }
        return instance;
    }

    public static RepositorioPessoaFisica ler() {
        RepositorioPessoaFisica rep = null;
        try {

            File f = new File("Arquivos\\RepositorioPessoa.dat");

            FileInputStream fis = new FileInputStream(f);

            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();
            if (o != null) {
                rep = (RepositorioPessoaFisica) o;
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return rep;
    }

    @Override
    public PessoaFisica buscarPessoaFisica(String cpf) {
        PessoaFisica pessoa = null;
        if (cpf != null) {
            pessoa = this.pessoas.get(buscarIndiceCpf(cpf));
        }
        return pessoa;
    }

    private int buscarIndiceCpf(String cpf) {
        int i = 0;
        boolean resposta = false;
        while (resposta != true && i < this.pessoas.size()) {
            if (cpf.equals(this.pessoas.get(i).getCpf())) {
                resposta = true;
            } else {
                i = i + 1;
            }
        }
        return i;

    }

    @Override
    public boolean cadastrar(PessoaFisica pessoa) {
        boolean resposta = true;
        if (pessoa != null) {

            this.pessoas.add(pessoa);

        } else {
            resposta = false;

        }
        this.salvarPessoaFisica();
        return resposta;
    }

    @Override
    public void remover(String cpf) {
        if (existe(cpf)) {

            this.pessoas.remove(buscarPessoaFisica(cpf));

            this.salvarPessoaFisica();

        }
        this.salvarPessoaFisica();
    }
    @Override
    public boolean existe(String cpf) {
        boolean existe = false;
        int i = this.buscarIndiceCpf(cpf);
        if (i != this.pessoas.size()) {
            existe = true;
        }
        return existe;
    }

    @Override
    public void salvarPessoaFisica() {
        try {
            File f = new File("Arquivos\\RepositorioPessoa.dat");

            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream ous = new ObjectOutputStream(fos);

            ous.writeObject(instance);

            ous.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
