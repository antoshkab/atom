package BullsAndCows;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Bulls and Cows game!");

        try {
            List<String> lines = ResourceReader.readFromResource("dictionary.txt");
            Random random = new Random();
            String word = lines.get(random.nextInt(lines.size()));
            String answer;
            do {
                System.out.printf("I offered a %d-letter word, your guess?%n", word.length());
                boolean lose = true;
                for (int i = 0; i < 10; i++) {
                    String gameWord = System.console().readLine();
                    if (gameWord.equalsIgnoreCase(word)) {
                        System.out.println("You won!");
                        lose = false;
                        break;
                    } else {
                        int cows = 0;
                        int bulls = 0;
                        for (char c : gameWord.toCharArray()) {
                            int gameWordIndex = gameWord.indexOf(c);
                            int wordIndex = word.indexOf(c);
                            if (gameWordIndex == wordIndex)
                                bulls++;
                            else if (wordIndex >= 0)
                                cows++;
                        }
                        System.out.printf("Bulls: %d%n", bulls);
                        System.out.printf("Cows: %d%n", cows);
                    }
                }
                if (lose) {
                    System.out.printf("You lose! Word: %s%n", word);
                }
                System.out.println("Wanna play again? Y/N");
                answer = System.console().readLine();
            } while ("Y".equalsIgnoreCase(answer));

            System.out.println("Thx for game!");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
