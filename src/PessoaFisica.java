public class PessoaFisica extends Cliente {
    String cpf;
    int idade;
    char sexo;

    void imprimir() {
        System.out.println(cpf + idade + sexo);
    }
}
