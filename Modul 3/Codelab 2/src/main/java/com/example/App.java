import org.apache.commons.lang3.StringUtils;
public class App {
    public static void main(String[] args) {
        String text = "Hello, Maven!";
        String reversedText = StringUtils.reverse(text);
        System.out.println(reversedText);
    }
}