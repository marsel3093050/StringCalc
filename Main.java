import java.util.Scanner;

public class Main {
    static char operator;
    static char quotes = '"';
    static String result = "";

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        String input = scanner.nextLine();
        System.out.println("Output: ");
        char[] data = new char[100];
        for (int i = 0; i < input.length(); i++) {
            data[i] = input.charAt(i);
            if (data[i] == '+') operator = '+';
            if (data[i] == '-') operator = '-';
            if (data[i] == '*') operator = '*';
            if (data[i] == '/') operator = '/';
        }
        String stroke = String.valueOf(data);
        String stroke2 = stroke.replace("\"", "");
        String[] massive = stroke2.split(" (\\W) ");
        String data0 = massive[0].trim();
        String data1 = massive[1].trim();
        if (data0.length() > 10) System.out.println("Размер вводимых данных не удовлетворяет заданию");
        else {
            if (operator == '+') {
                System.out.println(quotes + data0 + data1 + quotes);
            }
            if (operator == '-') {
                if (data0.contains(data1)) {
                    result = data0.replace(data1, "");
                    System.out.println(quotes + result + quotes);
                } else System.out.println(quotes + data0 + quotes);
            }
            if (operator == '*') {
                int stringToNumber = Integer.parseInt(data1);
                if (stringToNumber > 10) System.out.println("Размер вводимых чисел не удовлетворяет заданию");
                else {
                    for (int i = 0; i < stringToNumber; i++) result += data0;
                    if (result.length() > 40) System.out.println(quotes + result.substring(0, 40) + "...");
                    else System.out.println(quotes + result + quotes);
                }
            }
            if (operator == '/') {
                int stringToNumber = Integer.parseInt(data1);
                result = data0.substring(0, stringToNumber);
                System.out.println(quotes + result + quotes);
            }
        }
    }
}
