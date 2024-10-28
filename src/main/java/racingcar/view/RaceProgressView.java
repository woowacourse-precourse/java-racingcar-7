package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;

public class RaceProgressView {
    private final String COLON_DELIMITER = " : ";
    private final String OUTPUT_MESSAGE = "실행 결과";
    private final String LINE_SPACE = "\n";

    public void displayOutputMessage() {
        System.out.println(LINE_SPACE + OUTPUT_MESSAGE);
    }

    public void displayRoundProgress(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            String result = racingCar.getName() + COLON_DELIMITER + racingCar.getDistance();
            System.out.println(result);
        }
        System.out.print(LINE_SPACE);
    }

}
