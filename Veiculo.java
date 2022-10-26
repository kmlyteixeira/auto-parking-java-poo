import java.util.ArrayList;

public abstract class Veiculo implements GetId {
    private int id;
    private String nome;

    private static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    protected Veiculo(int id, String nome) {
        this.id = GetId.getNextId(veiculos);
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    } 

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public static Veiculo getVeiculoById(int id) throws Exception {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                return veiculo;
            }
        }
        throw new Exception("Veículo não encontrado");
    }

    @Override
    public String toString() {
        return " Nome: " + nome + 
            "\n Id: " + id;
    }
}
