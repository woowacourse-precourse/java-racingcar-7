package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    Setting setting = new Setting();
    private List<Car> cars;

    public void run() {
        cars = setting.grantCarName();
        game(setting.grantMoveCount());
    }

    private void game(int moves) {
        for (int i = 0; i < moves; i++) {
            judgeCarMove();
            currentCarPositions();
            System.out.println();
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
