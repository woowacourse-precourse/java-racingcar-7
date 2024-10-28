package racingcar;

import java.util.HashMap;

public class Game {
    public static void play(String p, HashMap<String, String> games) {
        if (Dice.roll()) {
            String rail = games.get(p) + "-";
            games.put(p, rail);
        }
    }
}
