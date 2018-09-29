
public class Escape {
    public static boolean Escape(int num) {
        //num == player escape stat (4 by default, but may be reduce or increased by failed escape attempts and poitions)
        //if dice is bigger than num, that return true, player escaped
        //else player failed
        return Randomizer.Randomizer(1, 6) > num;
    }
}
