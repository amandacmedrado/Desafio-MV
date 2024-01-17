package enums;

public enum TipoPessoa {
    PESSOA_FISICA(1),

   PESSOA_JURIDICA(2);

    private final int codTipoPessoa;

    TipoPessoa(int codTipoPessoa) {
        this.codTipoPessoa = codTipoPessoa;
    }

    public int getCodTipoPessoa() {
        return codTipoPessoa;
    }
}
