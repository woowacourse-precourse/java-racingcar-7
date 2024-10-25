package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.view.OutputView;


public class Race {
    private final String CAR_NAME_LENGTH_EXP_MSG = "자동차 이름은 5자 이하만 가능합니다.";

    private List<Car> racingCars = new ArrayList<>();

    public Race(String racingCarNames) {
        StringTokenizer st = new StringTokenizer(racingCarNames, ",");
        while (st.hasMoreTokens()) {
            String racingCarName = st.nextToken();
            if (racingCarName.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_EXP_MSG);
            }
            racingCars.add(new Car(racingCarName));
        }
    }

    public void runOneRound() {
        for (Car racingCar : racingCars) {
            racingCar.decideProgressByRandomNumber();
        }
        OutputView.printRoundResult(racingCars);

    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();

        int maxScore = 0;
        for (Car racingCar : racingCars) {
            maxScore = Math.max(racingCar.getProgressCount(), maxScore);
        }
        for (Car racingCar : racingCars) {
            if (racingCar.getProgressCount() == maxScore) {
                winnerNames.add(racingCar.getName());
            }
        }

        return winnerNames;
    }
    public List<Car> getRacingCars() {
        return racingCars;
    }

}
