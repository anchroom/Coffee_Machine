package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String fileName = args[args.length-1];
        System.out.println(fileName);
        File file = new File(fileName);

        String text = "";
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("The text is:");
            text = text + scanner.nextLine();
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine() + "n");
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("No file found: ");
        }

        String wordsDivisionPatten = "\\s+";
        String sentencesDivisionPatten = "[.!?]";
        String syllablesPatten = "(?i)[aeiouy]+(?<!e\\b)";

        String[] words = text.trim().split(wordsDivisionPatten);
        String[] sentences = text.trim().split(sentencesDivisionPatten);

        int numOfCharacters = 0;
        for (String word : words) {
            numOfCharacters += word.length();
        }

        int numOfWords = words.length;
        int numOfSentences = sentences.length;

        int numOfSyllables = numOfWords;
        int numOfPolySyllables = 0;

        for (String word : words) {
            Pattern patternOfSyllables = Pattern.compile(syllablesPatten);
            Matcher matcherOfSyllables = patternOfSyllables.matcher(word);
            int count = 0;

            while (matcherOfSyllables.find()) {
                count++;
            }

            if (count > 1) {
                numOfSyllables += count - 1;
                if (count >= 3) {
                    numOfPolySyllables++;
                }
            }
        }

        System.out.printf("Words: %d%nSentences: %d%nCharacters: %d%nSyllables: %d%nPolysyllables: %d%n"
                , numOfWords, numOfSentences, numOfCharacters, numOfSyllables, numOfPolySyllables);

        menu(numOfCharacters, numOfWords, numOfSentences, numOfSyllables, numOfPolySyllables);
    }

    private static void menu(int numOfCharacters, int numOfWords, int numOfSentences, int numOfSyllables, int numOfPolySyllables) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all); ");
        String command = scanner.nextLine();

        switch (command) {
            case "ARI":
                double indexARI = getARIIndex(numOfCharacters, numOfWords, numOfSentences);
                System.out.printf("Automated Readability Index: %1.2f (about %d year olds)."
                        , indexARI, getARIAge(indexARI));
                break;

            case "FK":
                double indexFK = getFKIndex(numOfWords, numOfSentences, numOfSyllables);
                System.out.printf("Flesch-Kincaid readability tests: %1.2f (about %d year olds)."
                        , indexFK, getFKAge(indexFK));
                break;

            case "SMOG":
                double indexSMOG = getSMOGIndex(numOfSentences, numOfPolySyllables);
                System.out.printf("Simple Measure of Gobbledygook: %1.2f (about %d year olds)."
                        , indexSMOG, getSMOGAge(indexSMOG));
                break;

            case "CL":
                double indexCL = getCLIndex(numOfCharacters, numOfWords, numOfSentences);
                System.out.printf("Coleman-Liau index: %1.2f (about %d year olds)."
                        , indexCL, getCLAge(indexCL));
                break;

            case "all":
                double index1 = getARIIndex(numOfCharacters, numOfWords, numOfSentences);
                double index2 = getFKIndex(numOfWords, numOfSentences, numOfSyllables);
                double index3 = getSMOGIndex(numOfSentences, numOfPolySyllables);
                double index4 = getCLIndex(numOfCharacters, numOfWords, numOfSentences);
                double averageAge = (getARIAge(index1) + getFKAge(index2) + getSMOGAge(index3) + getCLAge(index4)) / 4.0;
                System.out.printf("%nAutomated Readability Index: %5.2f (about %d year olds).%n" +
                                "Flesch" + (char)(8211) + "Kincaid readability tests: %5.2f (about %d year olds).%n" +
                                "Simple Measure of Gobbledygook: %5.2f (about %d year olds).%n" +
                                "Coleman" + (char)(8211) + "Liau index: %5.2f (about %d year olds).%n%n" +
                                "This text should be understood in average by %1.2f year olds"
                        , index1, getARIAge(index1), index2, getFKAge(index2), index3, getSMOGAge(index3)
                        , index4, getCLAge(index4), averageAge);

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    private static int getCLAge(double index) {
        return (int) Math.ceil(index) + 6;
    }

    private static double getCLIndex(int numOfCharacters, int numOfWords, int numOfSentences) {
        return 0.0588 * numOfCharacters / numOfWords * 100 - 0.296 * numOfSentences / numOfWords * 100 - 15.8;
    }


    private static double getSMOGIndex(int numOfSentences, int numOfPolySyllables) {
        return 1.043 * Math.sqrt(numOfPolySyllables * 30.0 / numOfSentences) + 3.1291;
    }

    private static int getSMOGAge(double index) {
        return (int) Math.ceil(index) + 5;
    }

    private static double getFKIndex(int numOfWords, int numOfSentences, int numOfSyllables) {
        return 0.39 * numOfWords / numOfSentences + 11.8 * numOfSyllables / numOfWords - 15.59;
    }

    private static int getFKAge(double index) {
        return (int) Math.ceil(index) + 5;
    }

    private static double getARIIndex(int numOfCharacters, int numOfWords, int numOfSentences) {
        return 4.71 * numOfCharacters / numOfWords + 0.5 * numOfWords / numOfSentences - 21.43;
    }

    private static int getARIAge(double index) {
        int age = 0;
        switch ((int) Math.ceil(index)) {
            case 1:
                age = 6;
                break;

            case 2:
                age = 7;
                break;

            case 3:
                age = 9;
                break;

            case 4:
                age = 10;
                break;

            case 5:
                age = 11;
                break;

            case 6:
                age = 12;
                break;

            case 7:
                age = 13;
                break;

            case 8:
                age = 14;
                break;

            case 9:
                age = 15;
                break;

            case 10:
                age = 16;
                break;

            case 11:
                age = 17;
                break;

            case 12:
                age = 18;
                break;

            case 13:
                age = 24;
                break;

            case 14:
                age = 25;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + index);
        }

        return age;
    }
}