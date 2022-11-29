import java.lang.module.FindException;
import java.util.Scanner;

public class Main {
    static char operator;
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
        String[] massive = stroke.split(" (\\W) ");
        String data0 = massive[0].trim();
        String data1 = massive[1].trim();

        if (isQuotes(data0)) {
            data0 = data0.replace("\"", "");

                if (operator == '+' && isQuotes(data1 )) {
                    printInQuotes(data0 + delQuotes(data1));
                }
                if (operator == '-') {
                    if (data0.contains(data1)) {
                        result = data0.replace(data1, "");
                        printInQuotes(result);
                    } else {
                        printInQuotes(data0);
                    }
                }
                if (operator == '*') {
                    int stringToNumber = Integer.parseInt(data1);
                    if (stringToNumber > 10) System.out.println("Размер вводимых чисел не удовлетворяет заданию");
                    else {
                        for (int i = 0; i < stringToNumber; i++) {
                            result += data0;
                        }
                        if (result.length() > 40) {
                            printInQuotes(result.substring(0, 40) + "...");
                        } else {
                            printInQuotes(result);
                        }
                    }
                }
                if (operator == '/') {

                    int stringToNumber = Integer.parseInt(data1);
                    result = data0.substring(0, stringToNumber);
                    printInQuotes(result);
                }

        }
        else System.err.println("Ошибка ввода данных");
    }

    public static String delQuotes(String noQuotes){
        return  noQuotes.replace("\"", "");
    }
    static void printInQuotes(String text) {
        System.out.println("\"" + text + "\"");
    }

    public static boolean isQuotes(String word) {
        return word.charAt(0) == '"' && word.charAt(word.length() -1) == '"';
    }
}
