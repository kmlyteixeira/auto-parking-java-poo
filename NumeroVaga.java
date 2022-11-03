import java.util.ArrayList;

public interface NumeroVaga extends Generic {
    ArrayList<String> numerosVagas = new ArrayList<>();

    public static boolean verificaExistencia(String input) {
        return Generic.verificaExistencia(numerosVagas, input);
    }

    // mascara para numero vaga: A999
    public static boolean isValida(String input) {
        return Generic.isValida("[A-Z][0-9]{3}", input);
    }
}
