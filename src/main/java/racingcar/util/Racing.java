package racingcar.util;

import racingcar.domain.Player;

public class Racing {

    private static final int MOVING_FORWARD = 4;

    public static void move(Player player, int number) {
        if (number >= MOVING_FORWARD) {
            player.increment();
        }
    }
}
