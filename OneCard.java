//Jacob Gaylord
//jigaylord16@ole.augie.edu
//OneCard.java
import java.util.Scanner;
public class OneCard
{
  //Desc:	  Play the game of OneCard.  The game has 2 players, the user and the
  //        computer. The user is dealt 1 card, the computer is dealt 1 card.
  //        The user has the option to change the card once.  The winner is the
  //        player with the higher rank card (Ace>King>Queen>…>3>2).
  //        The suit is not relevant.
  //Input:  The user enters a character (Y/N) signaling whether the user wants
  //        to change the card.
  //Output: The user's card, followed by a message asking the user if he wants
  //        to change the card, followed optionally the user's new card,
  //        followed by the computer's card, followed by the result of the game.
  public static void play()
  {
    boolean again = true;
    String userCard = "";
    String dealerCard = "";
    int userRank = 0;
    int dealerRank = 0;
    DeckOfCards d = new DeckOfCards();
    d.shuffle();
    userCard = d.deal();
    System.out.println("Your card: " + userCard);
    Scanner input = new Scanner(System.in);
    System.out.print("Change card (y/n): ");
    char ch = input.nextLine().charAt(0);
    if(ch == 'y' || ch == 'Y')
      userCard = d.deal();
    dealerCard = d.deal();
    System.out.println("Your card: " + userCard);
    System.out.println("Dealer card: " + dealerCard);
    userRank = findRank(userCard);
    dealerRank = findRank(dealerCard);
    whoWins(userRank, dealerRank);
  }
    //Return: An integer representing the rank of a dealt card from a DeckOfCards
    //        object.
    public static int findRank(String card)
    {
      int rank = 0;
      if(card.startsWith("Two")) rank = 2;
      else if(card.startsWith("Three")) rank = 3;
      else if(card.startsWith("Four")) rank = 4;
      else if(card.startsWith("Five")) rank = 5;
      else if(card.startsWith("Six")) rank = 6;
      else if(card.startsWith("Seven")) rank = 7;
      else if(card.startsWith("Eight")) rank = 8;
      else if(card.startsWith("Nine")) rank = 9;
      else if(card.startsWith("Ten")) rank = 10;
      else if(card.startsWith("Jack")) rank = 11;
      else if(card.startsWith("Queen")) rank = 12;
      else if(card.startsWith("King")) rank = 13;
      else rank = 14;
      return rank;
    }
    //Output: Prints the result of a OneCard game.
    public static void whoWins(int card1, int card2)
    {
      if(card1 == card2) System.out.println("You tied");
      else if(card1 > card2) System.out.println("You won");
      else System.out.println("You lost");
    }
}
