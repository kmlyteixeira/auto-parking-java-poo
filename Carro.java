import java.util.ArrayList;

public class Carro extends Veiculo implements Placa {
    private String placa;
    private String cor;

    private static ArrayList<Carro> carros = new ArrayList<Carro>();

    public Carro(String nome, String placa, String cor) {
        super(GetId.getNextId(carros), nome);
        this.placa = placa;
        this.cor = cor;

        Veiculo.getVeiculos().add(this);
        carros.add(this);
        Placa.placas.add(placa);
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

    public static ArrayList<Carro> getCarros() {
        return carros;
    }

    @Override
    public String toString() {
        return " Carro: " + super.toString() + 
            "\n placa: " + placa + 
            "\n cor: " + cor;
    }

    @Override
    public String getInput() {
        return placa;
    }
}