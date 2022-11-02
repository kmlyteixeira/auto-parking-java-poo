import java.util.ArrayList;

public class Locacao implements GetId {
    private int id;
    private String data;
    private int idVaga;
    private Vaga vaga;
    private int idVeiculo;
    private Veiculo veiculo;

    private static ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

    public Locacao(String data, Vaga vaga, Veiculo veiculo) {
        this.id = GetId.getNextId(locacoes);
        this.data = data;
        this.idVaga = vaga.getId();
        this.vaga = vaga;
        this.idVeiculo = veiculo.getId();
        this.veiculo = veiculo;

        locacoes.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public static ArrayList<Locacao> getLocacoes() {
        return locacoes;
    }

    public static void setLocacoes(ArrayList<Locacao> locacoes) {
        Locacao.locacoes = locacoes;
    }

    public static Locacao getLocacaoById(int id) throws Exception {
        for (Locacao locacao : locacoes) {
            if (locacao.getId() == id) {
                return locacao;
            }
        }
        throw new Exception("Locação não encontrada!");
    }

    @Override
    public String toString() {
        return "Locacao: " + 
            "\n id: " + id + 
            "\n data: " + data + 
            "\n vaga: " + vaga + 
            "\n veiculo: " + veiculo;
    }
}
