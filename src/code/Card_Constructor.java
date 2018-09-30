package code;

//name of card, how much it gives of whatever, how much it costs, what does it give
public class Card_Constructor {
	
	
	
	public static Card[] Blank = {
			new Card("====="),
		};
	
	public static Card[] PotionCardsLow = {
			new Card("Health Potion", 20, 200, "health"),
			new Card("Damage Potion", 20, 200, "damage"),
			new Card("Escape code.Card", 1, 200, "escape"),
		};
	
	public static Card[] PotionCardsMed = {
			new Card("Health Potion", 40, 400, "health"),
			new Card("Damage Potion", 40, 400, "damage"),
			new Card("Escape code.Card", 40, 400, "escape"),
		};
	
	public static Card[] PotionCardsHigh = {
			new Card("Health Potion", 60, 600, "health"),
			new Card("Damage Potion", 60, 600, "damage"),
			new Card("Escape code.Card", 60, 600, "escape"),
		};
	
	}

