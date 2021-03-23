package main.java.ru.erminson.twenty_matches.service;

public class AIService implements IAIService {
    @Override
    public int aiMakeTurn(final int currentMatches) {
        final int[] numbers = new int[] {17, 13, 9, 5, 1};
        int amount = 0;
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];

            if (current < currentMatches) {
                amount = currentMatches - current;
                return amount;
            }
        }

        return amount;
    }
}
