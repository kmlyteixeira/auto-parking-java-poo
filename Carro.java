import java.util.ArrayList;

public class Carro extends Veiculo {
    private String placa;
    private String cor;

    private static ArrayList<Carro> carros = new ArrayList<Carro>();

    public Carro(String nome, String placa, String cor) {
        super(GetId.getNextId(carros), nome);
        this.placa = placa;
        this.cor = cor;

        Veiculo.getVeiculos().add(this);
        carros.add(this);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return " Carro: " + super.toString() + 
            "\n placa: " + placa + 
            "\n cor: " + cor;
    }
}