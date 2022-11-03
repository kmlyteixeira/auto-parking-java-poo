import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Generic {

    String getInput();

    public static boolean isValida(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean verificaExistencia(ArrayList<String> lista, String input) {
        if (lista.contains(input)) {
            return true;
        } else {
            return false;
        }
    }
}
