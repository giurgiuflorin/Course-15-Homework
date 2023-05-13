public class Main {
    public static void main(String[] args) {

        // 1) sum of first n integer numbers;
        System.out.println(sumOfFirstNIntegerNumbers(-5));

        // 2) sum of first n EVEN integers;
        System.out.println(sumOfFirstNEvenIntegers(2));

        // 3) Palindrome
        // 3.1) recursive string reverse;
        String testWord = "anabana";
        System.out.println(testWord.equals(reverse(testWord)));

        // 3.2) recursive check of first and last letter
        System.out.println(recursiveCheckOfFirstAndLastLetter("anabana"));

        // 4) sum of digits for a number
        System.out.println(sumOfDigits(255));


    }

    // in cazul numerelor negative, metoda aceasta e apelata
    // pentru a le da valoare pozitiva;
    public static int toPositive(int number) {

        if (number < 0) {
           int positive = Math.abs(number);
           return positive;
        }
        return number;
    }

    public static int sumOfFirstNIntegerNumbers(int number) {
        number = toPositive(number);

        if (number == 0) {
            return 0;
        } else {
            return number + sumOfFirstNIntegerNumbers(number - 1);
        }
    }

    public static int sumOfFirstNEvenIntegers(int number) {
        number = toPositive(number);

        if (number == 0) {
            return 0;
        } else {
            return 2 * number + sumOfFirstNEvenIntegers(number - 1);
        }
    }

    public static String reverse(String word) {

        if (word.length() <= 1) {
            return word;
        } else {
            return word.charAt(word.length() - 1) + reverse(word.substring(0, word.length() - 1));
        }
    }

    public static boolean recursiveCheckOfFirstAndLastLetter(String word) {

        if (word.length() <= 1) {
            return true;
        } else if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        } else {
            return recursiveCheckOfFirstAndLastLetter(word.substring(1, word.length() - 1));
            // metoda .substring(1, word.length() - 1) trunchiaza la capete cuvantul,
            // iar daca cele doua capete (litera de inceput si litera de sfarsit) sunt egale,
            // atunci se va trunchia din nou si din nou cuvantul, pana ce lungimea lui ajunge
            // la 1, caz in care returnam true, adica vom confirma calitatea de palindrom;
        }

    }

    public static int sumOfDigits(int number) {
        number = toPositive(number);

        int result = 0;
        if (number < 10) {
            // pentru ca numarul este constant imbratit la 10, deci i se trunchiaza ultima cifra,
            // conditia number < 10 va fi implinita atunci cand trunchierea numarului
            // a adus numarul la lungimea unei singure cifre;
            return number;
        } else {
            result = number % 10 + sumOfDigits(number / 10);
        }
        return result;
    }
}