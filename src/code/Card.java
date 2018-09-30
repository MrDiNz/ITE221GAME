package code;

public class Card extends Card_Constructor{
		private String name;
		private int cardStat; 
		private int price;
		private String tag; 
		
		public Card (String name, int cardStat, int price, String tag) {
			this.name = name;
			this.cardStat = cardStat;
			this.price = price;
			this.tag = tag;
		}
		
		public Card (String name) {
			this.name = name;

		}
		
		public String toString () {
			return "\t[Card]" + name
					+ "\n||use it to get buff " + cardStat + " to " + tag + "||";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCardStat() {
			return cardStat;
		}

		public void setCardStat(int cardStat) {
			this.cardStat = cardStat;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getTag() {
			return tag;
		}

		public void setTag(String tag) {
			this.tag = tag;
		}
}
