import java.util.ArrayList;

public class Vaga <T extends Veiculo> implements GetId {
    private int id;
    private String numero;
    private String tipo;
    private double preco;
    private double tamanho;
    private boolean ocupada;
    private ArrayList<T> veiculos;
    private ArrayList<Locacao> locacoes;

    private static ArrayList<Vaga> vagas = new ArrayList<Vaga>();

    public Vaga(String numero, String tipo, double preco, double tamanho) {
        this.id = GetId.getNextId(vagas);
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.tamanho = tamanho;
        this.ocupada = false;

        vagas.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public static Vaga getVagaById(int id) throws Exception {
        for (Vaga vaga : vagas) {
            if (vaga.getId() == id) {
                return vaga;
            }
        }
        throw new Exception("Vaga não encontrada!");
    }

    public ArrayList<T> getVeiculos() {
        return veiculos;
    }

    public ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public static ArrayList<Vaga> getVagas() {
        return vagas;
    }

    @Override
    public String toString() {
        return " * VAGA: " + numero + 
            "\n Tipo: " + tipo + 
            "\n Preço: " + preco + 
            "\n Tamanho: " + tamanho + 
            "\n Status: " + (ocupada == true ? "Ocupada" : "Livre") +
            "\n\n";
    }
}
