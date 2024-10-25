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

    public void moveRacingCars(List<Integer> racingCarRandomNumbers) {
        for (int i = 0; i < racingCarRandomNumbers.size(); i++) {
            racingCarList.get(i).forwardRacingCarPosition(racingCarRandomNumbers.get(i));
        }
    }

    public String receiveRacingCarTryResult() {
        StringBuilder racingCarTryResult = new StringBuilder();
        for (RacingCar racingCar : racingCarList) {
            racingCarTryResult.append(RACING_TRY_RESULT.format(racingCar.readRacingCarName()));
            for (long i = 0L; i < racingCar.checkCurrentPosition(); i++) {
                racingCarTryResult.append(RACING_POSITION_TEXT.getText());
            }
            racingCarTryResult.append(NEW_LINE.getText());
        }
        return racingCarTryResult.toString();
    }

    public List<String> calculateGameResult() {
        long fastestPosition = 0L;
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            long currentPosition = racingCar.checkCurrentPosition();
            if (currentPosition > fastestPosition) {
                fastestPosition = currentPosition;
                winnerNames.clear();
                winnerNames.add(racingCar.readRacingCarName());
                continue;
            }

            if (currentPosition == fastestPosition) {
                winnerNames.add(racingCar.readRacingCarName());
            }
        }

        return winnerNames;
    }
}
