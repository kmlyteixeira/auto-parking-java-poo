import java.util.ArrayList;

public interface Placa extends Generic {
    ArrayList<String> placas = new ArrayList<>();

    public static boolean verificaExistencia(String input) {
        return Generic.verificaExistencia(placas, input);
    }

    // mascara para placa: AAA9999
    public static boolean isValida(String input) {
        return Generic.isValida("[A-Z]{3}[0-9]{4}", input);
    }
}
