package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private static final String SYSTEM_RACE_OUTPUT_MESSAGE = "실행 결과";
    private static final String SYSTEM_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String STRING_DELIMITER = ",";
    private static boolean isFirstOutput = true;

    public void printRace(List<Car> racingCarList) {
        // 실행 결과 문구는 처음에만 출력
        if (isFirstOutput) {
            System.out.println(SYSTEM_RACE_OUTPUT_MESSAGE);
            isFirstOutput = false;
        }
        printCarMove(racingCarList);
    }

    private void printCarMove(List<Car> racingCarList) {
        for (Car car : racingCarList) {
            System.out.println(car.getName() + " : " + getCarScoreDisplay((car)));
        }
        System.out.println();
    }

    private String getCarScoreDisplay(Car car) {
        return "-".repeat(car.getMoveCount());
    }
}
