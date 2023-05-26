import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final String[] lowerAlphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final String[] lowerAlphabetDecimal = {"97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109",
            "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122"};
    private static final String[] lowerAlphabetHexadecimal = {"61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D",
            "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A"};
    private static final String[] lowerAlphabetOctal = {"0141", "0142", "0143", "0144", "0145", "0146", "0147", "0150", "0151", "0152", "0153", "0154", "0155",
            "0156", "0157", "0160", "0161", "0162", "0163", "0164", "0165", "0166", "0167", "0170", "0171", "0172"};
    private static final String[] lowerAlphabetBinar = {"1100001", "1100010", "1100011", "1100100", "1100101", "1100110", "1100111", "1101000", "1101001", "1101010", "1101011", "1101100", "1101101",
            "1101110", "1101111", "1110000", "1110001", "1110010", "1110011", "1110100", "1110101", "1110110", "1110111", "1111000", "1111001", "1111010"};


    private static final String[] upperAlphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final String[] upperAlphabetDecimal = {"65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81",
            "82", "83", "84", "85", "86", "87", "88", "89", "90"};
    private static final String[] upperAlphabetHexadecimal = {"41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A"};
    private static final String[] upperAlphabetOctal = {"0101", "0102", "0103", "0104", "0105", "0106", "0107", "0110", "0111", "0112", "0113", "0114",
            "0115", "0116", "0117", "0120", "0121", "0122", "0123", "0124", "0125", "0126", "0127", "0130", "0131", "0132"};
    private static final String[] upperAlphabetBinar = {"1000001", "1000010", "1000011", "1000100", "1000101", "1000110", "1000111", "1001000", "1001001", "1001010", "1001011", "1001100", "1001101", "1001110", "1001111", "1010000", "1010001",
            "1010010", "1010011", "1010100", "1010101", "1010110", "1010111", "1011000", "1011001", "1011010"};


    private static final String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] upperDigitsDecimal = {"48", "49", "50", "51", "52", "53", "54", "55", "56", "57"};
    private static final String[] upperDigitsHexadecimal = {"30", "31", "32", "33", "34", "35", "36", "37", "38", "39"};
    private static final String[] upperDigitsOctal = {"060", "061", "062", "063", "064", "065", "066", "067", "070", "071"};
    private static final String[] upperDigitsBinar = {"0110000", "0110001", "0110010", "0110011", "0110100", "0110101", "0110110", "0110111", "0111000", "0111001"};



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean estAlphanumerique = false;
        boolean estDecimal = false;
        boolean estHexadecimal = false;
        boolean estOctal = false;
        boolean estBinaire = false;
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

        System.out.print("Choisissez la base de conversion (d: décimal, h: hexadécimal, o: octal, b: binaire, t: texte) : ");
        String choixBase = scanner.nextLine();

        if (choixBase.equalsIgnoreCase("d")) {
            convertDecimal(myString);
        } else if (choixBase.equalsIgnoreCase("h")) {
            convertHexadecimal(myString);
        } else if (choixBase.equalsIgnoreCase("o")) {
            convertOctal(myString);
        } else if (choixBase.equalsIgnoreCase("b")) {
            convertBinary(myString);
        } else if (choixBase.equalsIgnoreCase("t")) {
            convertText(myString);
        } else {
            System.out.println("Choix invalide. Conversion annulée.");
        }

        scanner.close();
    }

    public static void convertDecimal(String myString) {
        // Votre code de conversion décimale ici
        // ...
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
                valeurDecimale.append(valeur).append(" ");
            }
        }

        System.out.println("\nConversion décimale : " + valeurDecimale.toString());
    }


    public static void convertHexadecimal(String myString) {
        StringBuilder valeursHexadecimales = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            char caractere = myString.charAt(i);
            String caractereString = String.valueOf(caractere);

            String valeur = null;

            // Vérifier si le caractère est dans lowerAlphabet et récupérer sa valeur hexadécimale correspondante
            for (int j = 0; j < lowerAlphabet.length; j++) {
                if (caractereString.equals(lowerAlphabet[j])) {
                    valeur = lowerAlphabetHexadecimal[j];
                    break;
                }
            }

            // Vérifier si le caractère est dans upperAlphabet et récupérer sa valeur hexadécimale correspondante
            if (valeur == null) {
                for (int j = 0; j < upperAlphabet.length; j++) {
                    if (caractereString.equals(upperAlphabet[j])) {
                        valeur = upperAlphabetHexadecimal[j];
                        break;
                    }
                }
            }

            // Vérifier si le caractère est un chiffre et récupérer sa valeur hexadécimale correspondante
            if (valeur == null) {
                for (int j = 0; j < digits.length; j++) {
                    if (caractereString.equals(digits[j])) {
                        valeur = upperDigitsHexadecimal[j];
                        break;
                    }
                }
            }

            // Ajouter la valeur hexadécimale à la chaîne résultante
            if (valeur != null) {
                valeursHexadecimales.append(valeur).append(" ");
            }
        }

        System.out.println("\nConversion hexadécimale : " + valeursHexadecimales.toString());
    }
    public static void convertOctal(String myString) {

        StringBuilder valeurOctale = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            char caractere = myString.charAt(i);
            String caractereString = String.valueOf(caractere);

            int valeur = -1;

            // Vérifier si le caractère est dans lowerAlphabet et récupérer sa valeur octale correspondante
            for (int j = 0; j < lowerAlphabet.length; j++) {
                if (caractereString.equals(lowerAlphabet[j])) {
                    valeur = Integer.parseInt(lowerAlphabetOctal[j]);
                    break;
                }
            }

            // Vérifier si le caractère est dans upperAlphabet et récupérer sa valeur octale correspondante
            if (valeur == -1) {
                for (int j = 0; j < upperAlphabet.length; j++) {
                    if (caractereString.equals(upperAlphabet[j])) {
                        valeur = Integer.parseInt(upperAlphabetOctal[j]);
                        break;
                    }
                }
            }

            // Vérifier si le caractère est un chiffre et récupérer sa valeur octale correspondante
            if (valeur == -1) {
                for (int j = 0; j < digits.length; j++) {
                    if (caractereString.equals(digits[j])) {
                        valeur = Integer.parseInt(upperDigitsOctal[j]);
                        break;
                    }
                }
            }

            // Ajouter la valeur octale à la chaîne résultante
            if (valeur != -1) {
                valeurOctale.append(valeur).append(" ");
            }
        }

        System.out.println("\nConversion octale : " + valeurOctale.toString());
    }

    public static void convertBinary(String myString) {

        StringBuilder valeurBinaire = new StringBuilder();

        for (int i = 0; i < myString.length(); i++) {
            char caractere = myString.charAt(i);
            String caractereString = String.valueOf(caractere);

            int valeur = -1;

            // Vérifier si le caractère est dans lowerAlphabet et récupérer sa valeur binaire correspondante
            for (int j = 0; j < lowerAlphabet.length; j++) {
                if (caractereString.equals(lowerAlphabet[j])) {
                    valeur = Integer.parseInt(lowerAlphabetBinar[j]);
                    break;
                }
            }

            // Vérifier si le caractère est dans upperAlphabet et récupérer sa valeur binaire correspondante
            if (valeur == -1) {
                for (int j = 0; j < upperAlphabet.length; j++) {
                    if (caractereString.equals(upperAlphabet[j])) {
                        valeur = Integer.parseInt(upperAlphabetBinar[j]);
                        break;
                    }
                }
            }

            // Vérifier si le caractère est un chiffre et récupérer sa valeur binaire correspondante
            if (valeur == -1) {
                for (int j = 0; j < digits.length; j++) {
                    if (caractereString.equals(digits[j])) {
                        valeur = Integer.parseInt(upperDigitsBinar[j]);
                        break;
                    }
                }
            }

            // Ajouter la valeur binaire à la chaîne résultante
            if (valeur != -1) {
                valeurBinaire.append(valeur).append(" ");
            }
        }

        System.out.println("\nConversion binaire: " + valeurBinaire.toString());
    }

    public static void convertText(String myString){
        System.out.println("test");
    }

    


}
