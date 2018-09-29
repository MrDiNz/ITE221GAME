public class Randomizer {

	public static int Randomizer(int x, int y) {
		
		int min = x;
		int max = y;
		
		double random = (min + Math.random() * (max + 1 - min));
		random = Math.floor(random);
		return (int) random;
		

	}
}
