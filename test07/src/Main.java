import java.util.Scanner;

public class Main {
    private static final String[] lowerAlphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j","k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final String[] lowerAlphabetDecimal = {"97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109",
            "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122"};

    private static final String[] upperAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final String[] upperAlphabetDecimal = {"65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81",
            "82", "83", "84", "85", "86", "87", "88", "89", "90"};

    private static final String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] upperDigitsDecimal = {"48", "49", "50", "51", "52", "53", "54", "55", "56", "57"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean estAlphanumerique = false;
        String myString = "";

        while (!estAlphanumerique) {
            System.out.print("Entrez une phrase : ");
            myString = scanner.nextLine();

            estAlphanumerique = true;

            for (int i = 0; i < myString.length(); i++) {
                char caractere = myString.charAt(i);
                String caractereString = String.valueOf(caractere);

                boolean estDansLowerAlphabet = false;
                for (String s : lowerAlphabet) {
                    if (caractereString.equals(s)) {
                        estDansLowerAlphabet = true;
                        break;
                    }
                }

                boolean estDansUpperAlphabet = false;
                for (String s : upperAlphabet) {
                    if (caractereString.equals(s)) {
                        estDansUpperAlphabet = true;
                        break;
                    }
                }

                boolean estDansDigits = false;
                for (String s : digits) {
                    if (caractereString.equals(s)) {
                        estDansDigits = true;
                        break;
                    }
                }

                boolean estEspace = caractereString.equals(" ");

                if (!estDansLowerAlphabet && !estDansUpperAlphabet && !estDansDigits && !estEspace) {
                    estAlphanumerique = false;
                    break;
                }
            }

            if (!estAlphanumerique) {
                System.out.println("La phrase ne doit contenir que des caractères alphanumériques. Veuillez réessayer.");
            }
        }

        for (int i = 0; i < myString.length(); i++) {
            char caractere = myString.charAt(i);
            System.out.print(caractere);
        }

        convert(myString);
        scanner.close();
    }

    public static void convert(String myString) {
        StringBuilder valeurDecimale = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            char caractere = myString.charAt(i);
            String caractereString = String.valueOf(caractere);

            int valeur = -1;

            // Vérifier si le caractère est dans lowerAlphabet et récupérer sa valeur décimale correspondante
            for (int j = 0; j < lowerAlphabet.length; j++) {
                if (caractereString.equals(lowerAlphabet[j])) {
                    valeur = Integer.parseInt(lowerAlphabetDecimal[j]);
                    break;
                }
            }

            // Vérifier si le caractère est dans upperAlphabet et récupérer sa valeur décimale correspondante
            if (valeur == -1) {
                for (int j = 0; j < upperAlphabet.length; j++) {
                    if (caractereString.equals(upperAlphabet[j])) {
                        valeur = Integer.parseInt(upperAlphabetDecimal[j]);
                        break;
                    }
                }
            }

            // Vérifier si le caractère est un chiffre et récupérer sa valeur décimale correspondante
            if (valeur == -1) {
                for (int j = 0; j < digits.length; j++) {
                    if (caractereString.equals(digits[j])) {
                        valeur = Integer.parseInt(upperDigitsDecimal[j]);
                        break;
                    }
                }
            }

            // Ajouter la valeur décimale à la chaîne résultante
            if (valeur != -1) {
                valeurDecimale.append(valeur);
            }
        }

        System.out.println("\nConversion décimale : " + valeurDecimale.toString());
    }
}
