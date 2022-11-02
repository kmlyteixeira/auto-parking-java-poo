import java.util.ArrayList;

public class Moto extends Veiculo {
    private int cilindradas;
    private String placa;

    private static ArrayList<Moto> motos = new ArrayList<Moto>();

    public Moto(String nome, int cilindradas, String placa) {
        super(GetId.getNextId(motos), nome);
        this.cilindradas = cilindradas;
        this.placa = placa;

        Veiculo.getVeiculos().add(this);
        motos.add(this);
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public static ArrayList<Moto> getMotos() {
        return motos;
    }

    @Override
    public String toString() {
        return " Moto: " + super.toString() + 
            "\n cilindradas: " + cilindradas + 
            "\n placa: " + placa;
    }
}
