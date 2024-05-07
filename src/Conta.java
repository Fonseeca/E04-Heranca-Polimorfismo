public class Conta {

    private int numero;

    private Cliente dono;

    private double saldo;

    private double limite;

    private OperacaoDeposito[] depositos;

    private OperacaoSaque[] saques;

    private int proximaOperacao;

    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.saques = new OperacaoSaque[1000];
        this.proximaOperacao = 0;

        this.depositos = new OperacaoDeposito[1000];

        Conta.totalContas++;
    }



    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.saques[proximaOperacao] = new OperacaoSaque(valor);
            this.proximaOperacao++;
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.depositos[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public void imprimir() {
        System.out.println("===== Conta " + this.numero + " =====");
        System.out.println("Dono: " + this.dono.nome);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite: " + this.limite);
        System.out.println("====================");
    }

    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(OperacaoSaque atual : this.saques) {
            if (atual != null) {
                atual.imprimirExtrato();
            }
        }
        for(OperacaoDeposito atual : this.depositos) {
            if (atual != null) {
                atual.imprimirExtrato();
            }
        }
        System.out.println("====================");
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public void setLimite(double limite) {
        if (limite < 0)
            limite = 0;

        this.limite = limite;
    }
}