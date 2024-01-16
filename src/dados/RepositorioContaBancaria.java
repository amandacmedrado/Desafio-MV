package dados;

import beans.ContaBancaria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class RepositorioContaBancaria implements IRepositorioContaBancaria, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private List<ContaBancaria> contas;

    private static RepositorioContaBancaria instance;

    public RepositorioContaBancaria() {
        this.contas = new ArrayList<ContaBancaria>();

    }

    public static RepositorioContaBancaria getInstance() {
        if (instance == null) {
            {
                if (ler() == null) {
                    instance = new RepositorioContaBancaria();
                } else {
                    instance = (RepositorioContaBancaria) ler();
                }
            }

        }
        return instance;
    }

    public static RepositorioContaBancaria ler() {
        RepositorioContaBancaria rep = null;
        try {

            File f = new File("Arquivos\\RepositorioConta.dat");

            FileInputStream fis = new FileInputStream(f);

            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();
            if (o != null) {
                rep = (RepositorioContaBancaria) o;
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rep;

    }

    @Override
    public ContaBancaria buscarConta(String idConta) {
        ContaBancaria conta = null;
        if (idConta != null) {
            conta = this.contas.get(buscarIndiceIdConta(idConta));

        }
        return conta;
    }
    public int buscarIndiceIdConta(String idConta) {
        int i = 0;
        boolean resposta = false;
        while (resposta != true && i < this.contas.size()) {
            if (idConta.equals(this.contas.get(i).getIdConta())) {
                resposta = true;
            } else {
                i = i + 1;
            }
        }
        return i;

    }

    @Override
    public boolean cadastrar(ContaBancaria conta) {
        boolean resposta = true;
        if (conta != null) {

            this.contas.add(conta);

        } else {
            resposta = false;

        }
        this.salvarConta();
        return resposta;
    }

    @Override
    public void remover(String idConta) {
        if (existe(idConta)) {

            this.contas.remove(buscarConta(idConta));

        }
        this.salvarConta();
    }
    @Override
    public boolean existe(String idConta) {
        boolean existe = false;
        int i = this.buscarIndiceIdConta(idConta);
        if (i != this.contas.size()) {
            existe = true;
        }
        return existe;
    }

    @Override
    public void salvarConta() {
        try {
            File f = new File("Arquivos\\RepositorioConta.dat");

            FileOutputStream fos = new FileOutputStream(f);

            ObjectOutputStream ous = new ObjectOutputStream(fos);

            ous.writeObject(instance);

            ous.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizaSaldo(ContaBancaria conta, double saldo) {
        if (existe(conta.getIdConta())) {
            conta.setSaldoAtual(saldo);
        }

        this.salvarConta();

    }
}
