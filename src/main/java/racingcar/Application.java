package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.Racing;

public class Application {

    public static void main(String[] args) {
        Racing racing = Racing.makeRacing();
        racing.start();
    }
}
