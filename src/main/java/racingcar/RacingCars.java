package racingcar;

import static racingcar.TextFormat.RACING_TRY_RESULT;
import static racingcar.TextString.NEW_LINE;
import static racingcar.TextString.RACING_POSITION_TEXT;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(String[] racingCarNames) {
        for (String racingCarName : racingCarNames) {
            racingCarList.add(new RacingCar(racingCarName));
        }
    }

    public void moveRacingCars(List<Integer> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            racingCarList.get(i).forwardRacingCarPosition(randomNumbers.get(i));
        }
    }

    public String receiveRacingCarTryResult() {
        StringBuilder racingCarTryResult = new StringBuilder();
        for (RacingCar racingCar : racingCarList) {
            racingCarTryResult.append(RACING_TRY_RESULT.format(racingCar.readRacingCarName()));
            for (int i = 0; i < racingCar.checkCurrentPosition(); i++) {
                racingCarTryResult.append(RACING_POSITION_TEXT);
            }
            racingCarTryResult.append(NEW_LINE);
        }
        return racingCarTryResult.toString();
    }
}
