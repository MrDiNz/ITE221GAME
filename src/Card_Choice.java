import java.util.Scanner;

public class Card_Choice {
    public static Card Card_Choice(Hero hero) {
        //basic method, prints inventory, picks the card out into a variable and returns it + replaces original card in the inventory for blank
        System.out.print(hero.getInventory());
        Scanner console = new Scanner(System.in);
        System.out.println("\nWhich card do you choose?");

        int input = console.nextInt();
        console.nextLine();
        Card card = hero.getCard(input-1);
        hero.setInventory(input);

       // console.close();
        return card;
    }
}
