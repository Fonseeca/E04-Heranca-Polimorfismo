public class OperacaoDeposito extends Operacao{

    private double valor;

    OperacaoDeposito(double valor){
        super('d', valor);
    }
}
