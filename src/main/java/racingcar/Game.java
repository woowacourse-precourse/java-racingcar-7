package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private int moves;

    public void run() {
    }

    private void game(int moves) {
        for (int i = 0; i < moves; i++) {
            judgeCarMove();
            currentCarPositions();
        }
    }

    private boolean isCarMove() {
        return 4 <= Randoms.pickNumberInRange(0, 9);
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
            System.out.println(car.getName() + " : " + convertIntegerToHyphen(car.getPosition()));
        }
    }

    private String convertIntegerToHyphen(int num) {
        return "-".repeat(Math.max(0, num));
    }

}
