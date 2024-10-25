package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Racing {
    private List<Car> carList;
    private int repeat;

    public Racing() {
        this.carList = new ArrayList<>();
        this.repeat = 0;
    }

    public void setting(List<Car> carList, int repeat) {
        this.carList = carList;
        this.repeat = repeat;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.repeat; i++) {
            race();
            printStatus();
        }
    }

    private void race() {
        for (Car car : this.carList) {
            int distance = canMove();
            car.forward(distance);
        }
    }

    private int canMove() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            return 1;
        }
        return 0;
    }

    private void printStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.carList) {
            stringBuilder.append(car);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
