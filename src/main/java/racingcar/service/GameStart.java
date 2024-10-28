package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

public class GameStart {
    private static int max;

    public static int race(Car[] player) {

        for (Car car : player) {
            int progress = Randoms.pickNumberInRange(0, 9);
            decideToMove(progress, car);
            maxForward(car);
        }
        return max;
    }

    public static void decideToMove(int progress, Car car) {
        if (progress >= 4) {
            car.setForwardCount(car.getForwardCount() + 1);
        }
    }

    public static void maxForward(Car player) {
        if (player.getForwardCount() > max) {
            max = player.getForwardCount();
        }
    }

}
