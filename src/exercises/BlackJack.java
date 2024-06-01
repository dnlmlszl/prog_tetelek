package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> playerHand = new ArrayList<>();
        List<Integer> dealerHand = new ArrayList<>();

        initialTurn(playerHand);
        initialTurn(dealerHand);

        showResult(playerHand, dealerHand);

        if (initialCheck(playerHand)) return;

        if (playersTurn(playerHand)) return;

        if (dealersTurn(dealerHand)) return;

        showResult(playerHand, dealerHand);

        int playerScore = calculateHandValue(playerHand);
        int dealerScore = calculateHandValue(dealerHand);

        analyzeResult(playerScore, dealerScore, playerHand, dealerHand);
    }

    private static void showResult(List<Integer> playerHand, List<Integer> dealerHand) {
        System.out.printf("Your cards: %s\n", formatHand(playerHand));
        System.out.printf("Dealer's cards: %s\n", formatHand(dealerHand));
    }

    private static void analyzeResult(int playerScore, int dealerScore, List<Integer> playerHand, List<Integer> dealerHand) {
        if (playerScore > 21) {
            System.out.println("Bust! You lose.");
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins!");
        } else if (playerHand.size() < dealerHand.size()) {
            System.out.println("You win!");
        } else if (playerHand.size() > dealerHand.size()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private static boolean dealersTurn(List<Integer> dealerHand) {
        int handValue = calculateHandValue(dealerHand);
        while (handValue < 17) {
            dealerHand.add(drawCard(random));
            handValue = calculateHandValue(dealerHand);
        }
        System.out.printf("Dealer's cards: %s\n", formatHand(dealerHand));
        if (handValue > 21) {
            System.out.println("Dealer busts! You win.");
            return true;
        }
        return false;
    }

    private static boolean playersTurn(List<Integer> playerHand) {
        int handValue = calculateHandValue(playerHand);
        while (handValue <= 15) {
            playerHand.add(drawCard(random));
            handValue = calculateHandValue(playerHand);
            if (handValue > 21) {
                System.out.printf("Your cards: %s\n", formatHand(playerHand));
                System.out.println("Bust! You lose.");
                return true;
            }
        }

        while (true) {
            System.out.printf("Your cards: %s\n", formatHand(playerHand));
            System.out.println("Do you want to hit or stand?");
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("hit")) {
                playerHand.add(drawCard(random));
                handValue = calculateHandValue(playerHand);
                System.out.printf("Your cards: %s\n", formatHand(playerHand));
                if (handValue > 21) {
                    System.out.println("Bust! You lose.");
                    return true;
                }
            } else if (action.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid action. Please type 'hit' or 'stand'.");
            }
        }
        return false;
    }


    private static boolean initialCheck(List<Integer> playerHand) {
        if (playerHand.get(0) == 11 && playerHand.get(1) == 11) {
            System.out.println("Blackjack! You win!");
            return true;
        }
        return false;
    }

    private static void initialTurn(List<Integer> hand) {
        hand.add(drawCard(random));
        hand.add(drawCard(random));
    }

    private static int drawCard(Random random) {
        return random.nextInt(10) + 2;
    }

    private static int calculateHandValue(List<Integer> hand) {
        int value = 0;
        for (int card : hand) {
            value += card;
        }
        return value;
    }

    private static String formatHand(List<Integer> hand) {
        int value = calculateHandValue(hand);
        int count = hand.size();
        return String.format("%s (%d/%d)", hand, value, count);
    }
}
