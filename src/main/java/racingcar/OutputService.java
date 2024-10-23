package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputService {

    int winnerCarMovingPoint = 0;

    private final RacingCarService racingCarService;

    public OutputService(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public String getRaceOutcomeForCarInRound(RacingCar racingCar) {
        return racingCar.name + " : " + racingCar.currentMovingPoint;
    }

    public String getWinnerRacingCar(List<RacingCar> racingCarList) {
        List<RacingCar> winnerRacingCarList = new ArrayList<>();

        for (RacingCar racingCar : racingCarList) {
            winningCarDecisionProcess(racingCar, winnerRacingCarList);
        }
        return buildFinalWinnerAnnouncement(winnerRacingCarList);
    }

    private void winningCarDecisionProcess(RacingCar racingCar, List<RacingCar> winnerRacingCarList) {
        if (racingCar.currentMovingPoint.length() == winnerCarMovingPoint) {
            winnerRacingCarList.add(racingCar);
        }

        if (racingCar.currentMovingPoint.length() > winnerCarMovingPoint) {
            winnerRacingCarList.clear();
            winnerRacingCarList.add(racingCar);
            winnerCarMovingPoint = racingCar.currentMovingPoint.length();
        }
    }

    private String buildFinalWinnerAnnouncement(List<RacingCar> winnerRacingCarList) {
        StringBuilder result = new StringBuilder();
        for (RacingCar racingCar : winnerRacingCarList) {
            result.append(" ");
            result.append(racingCar.name);
            result.append(",");
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        return "최종 우승자 :" + result;
    }

    public void run(String carList, int count) {
        List<RacingCar> racingCarList = racingCarService.getCarListFromInput(carList);
        for (int i = 1; i <= count; i++) {
            System.out.println(i + "회차 결과");
            printOutRoundByRoundResults(racingCarList);
        }
        System.out.println(getWinnerRacingCar(racingCarList));
    }

    private void printOutRoundByRoundResults(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int stopOrMoveNumber = racingCarService.randomNumberCreate();
            racingCarService.increasingCurrentMovingPoint(racingCar, stopOrMoveNumber);
            System.out.println(getRaceOutcomeForCarInRound(racingCar));
        }
        System.out.println();
    }
}
