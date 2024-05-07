public class PessoaJuridica extends Cliente {
    String cnpj;
    int numFuncionarios;
    String setor;

    void imprimir() {
        System.out.println(cnpj + numFuncionarios + setor);
    }
}
