package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class RacingCarOutputView {
    private static final String OUTPUT_RACING_CAR_RESULT_MESSAGE = "실행 결과";
    private static final String OUTPUT_RACING_CAR_FINAL_RESULT_MESSAGE = "최종 우승자 : %s";

    public void printRacingCarResultMessage() {
        System.out.println(OUTPUT_RACING_CAR_RESULT_MESSAGE);
    }

    public void printCurrentRacingCar(Race race) {
        StringBuilder sb = new StringBuilder();
        for (Car car : race.getCars()) {
            sb.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        System.out.println(sb);
    }

    public void printRacingCarWinnerResult(String winner) {
        System.out.printf(OUTPUT_RACING_CAR_FINAL_RESULT_MESSAGE, winner);
    }
}
