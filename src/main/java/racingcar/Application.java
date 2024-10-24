package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.presentation.RacingStarter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            RacingStarter.startRace();
        } finally {
            Console.close();
        }
    }
}
