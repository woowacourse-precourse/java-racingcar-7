package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputService {
    public String getRaceOutcomeForCarInRound(RacingCar racingCar) {
        return racingCar.name + " : " + racingCar.currentMovingPoint;
    }

    public String getWinnerRacingCar(List<RacingCar> racingCarList) {
        List<RacingCar> winnerRacingCarList = new ArrayList<>();
        int winnerCarMovingPoint = 0;
        for (RacingCar racingCar : racingCarList) {
            if (racingCar.currentMovingPoint.length() == winnerCarMovingPoint) {
                winnerRacingCarList.add(racingCar);
            }

            if (racingCar.currentMovingPoint.length() > winnerCarMovingPoint) {
                winnerRacingCarList.clear();
                winnerRacingCarList.add(racingCar);
                winnerCarMovingPoint = racingCar.currentMovingPoint.length();
            }
        }
        StringBuilder result = new StringBuilder();
        for (RacingCar racingCar : winnerRacingCarList) {
            result.append(" ");
            result.append(racingCar.name);
            result.append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        return "최종 우승자 :" + result;
    }
    public void run(){

    }
}
