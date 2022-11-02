import java.util.ArrayList;

public class Bicicleta extends Veiculo {
    private String marca;
    private String cor;

    private static ArrayList<Bicicleta> bicicletas = new ArrayList<Bicicleta>();

    public Bicicleta(String nome, String marca, String cor) {
        super(GetId.getNextId(bicicletas), nome);
        this.marca = marca;
        this.cor = cor;

        Veiculo.getVeiculos().add(this);
        bicicletas.add(this);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public static ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    @Override
    public String toString() {
        return super.toString() + 
            "\n marca: " + marca + 
            "\n cor: " + cor;
    }
}
