package racingcar;

import java.util.ArrayList;

import static racingcar.Constants.RESULT_NOTICE;
import static racingcar.Utils.println;

public class StartRace {
    protected ArrayList<Car> racingStart(final ArrayList<Car> cars, final int attempts) {
        println(RESULT_NOTICE);
        for (int i = 0; i < attempts; i++) {
            // 랜덤 값 생성하고 자동차 전진
            for (Car car : cars) {
                car.run();
            }
            printGameStatus(cars);
        }
        return cars;
    }

    private void printGameStatus(final ArrayList<Car> cars) {
        for (Car car : cars) {
            println(makeMovedAmountString(car.getName(), car.movedAmount));
        }
        println("\n");
    }

    public String makeMovedAmountString(final String carName, final int movedAmount) {
        String movedAmountString = "-".repeat(movedAmount);
        if (movedAmount == 0) {
            movedAmountString = "";
        }
        return String.format("%s : %s", carName, movedAmountString);
    }
}
