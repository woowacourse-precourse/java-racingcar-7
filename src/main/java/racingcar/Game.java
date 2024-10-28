package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    private static final int REPEAT_START = 0;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_COUNT = 4;
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";


    User user = new User();
    Winner winner = new Winner();

    private List<Car> cars;

    public void run() {
        cars = user.grantCarName();
        game(user.grantMoves());
        winner.result(cars);
    }

    private void game(int moves) {
        for (int i = REPEAT_START; i < moves; i++) {
            judgeCarMove();
            currentCarPositions();
            System.out.println();
        }
    }

    private boolean isCarMove() {
        return MOVE_COUNT <= Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    private void judgeCarMove() {
        for (Car car : cars) {
            if (isCarMove()) {
                car.move();
            }
        }
    }

    private void currentCarPositions() {
        for (Car car : cars) {
            System.out.println(car.getName() + COLON + convertIntegerToHyphen(car.getPosition()));
        }
    }

    private String convertIntegerToHyphen(int num) {
        return HYPHEN.repeat(Math.max(REPEAT_START, num));
    }

}
