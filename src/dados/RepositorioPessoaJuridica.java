package dados;

import java.io.Serializable;
import beans.PessoaJuridica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoaJuridica implements IRepositorioPessoaJuridica, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<PessoaJuridica> pessoas;

    private static RepositorioPessoaJuridica instance;

    public RepositorioPessoaJuridica() {
        this.pessoas = new ArrayList<PessoaJuridica>();

    }

    public static RepositorioPessoaJuridica getInstance() {
        if (instance == null) {
            {
                if (ler() == null) {
                    instance = new RepositorioPessoaJuridica();
                } else {
                    instance = (RepositorioPessoaJuridica) ler();
                }
            }

        }
        return instance;
    }

    public static RepositorioPessoaJuridica ler() {
        RepositorioPessoaJuridica rep = null;
        try {

            File f = new File("Arquivos\\RepositorioPessoaJuridica.dat");

            FileInputStream fis = new FileInputStream(f);

            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();
            if (o != null) {
                rep = (RepositorioPessoaJuridica) o;
            }
            ois.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return rep;
    }

    @Override
    public PessoaJuridica buscarPessoaJuridica(String cnpj) {
        PessoaJuridica pessoa = null;
        if (cnpj != null) {
            pessoa = this.pessoas.get(buscarIndiceCnpj(cnpj));
        }
        return pessoa;
    }
    private int buscarIndiceCnpj(String cnpj) {
        int i = 0;
        boolean resposta = false;
        while (resposta != true && i < this.pessoas.size()) {
            if (cnpj.equals(this.pessoas.get(i).getCnpj())) {
                resposta = true;
            } else {
                i = i + 1;
            }
        }
        return i;
    }

    @Override
    public boolean cadastrar(PessoaJuridica pessoa) {
        boolean resposta = true;
        if (pessoa != null) {

            this.pessoas.add(pessoa);

        } else {
            resposta = false;

        }
        this.salvarPessoaJuridica();
        return resposta;
    }

    @Override
    public void remover(String cnpj) {
        if (existe(cnpj)) {

            this.pessoas.remove(buscarPessoaJuridica(cnpj));

            this.salvarPessoaJuridica();

        }
        this.salvarPessoaJuridica();

    }

    @Override
    public boolean existe(String cnpj) {
            boolean existe = false;
            int i = this.buscarIndiceCnpj(cnpj);
            if (i != this.pessoas.size()) {
                existe = true;
            }
            return existe;
    }


    @Override
    public void salvarPessoaJuridica() {
        try {
            File f = new File("Arquivos\\RepositorioPessoaJuridica.dat");

            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream ous = new ObjectOutputStream(fos);

            ous.writeObject(instance);

            ous.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
