package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputService {

    private int winnerCarMovingPoint = 0;

    private final RacingCarService racingCarService;

    public OutputService(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }


    public String getWinnerRacingCar(List<RacingCar> racingCarList) {
        List<RacingCar> winnerRacingCarList = new ArrayList<>();

        for (RacingCar racingCar : racingCarList) {
            winningCarDecisionProcess(racingCar, winnerRacingCarList);
        }
        return buildFinalWinnerAnnouncement(winnerRacingCarList);
    }

    private void winningCarDecisionProcess(RacingCar racingCar, List<RacingCar> winnerRacingCarList) {
        if (racingCar.getCurrentMovingPointInteger() == winnerCarMovingPoint) {
            winnerRacingCarList.add(racingCar);
        }

        if (racingCar.getCurrentMovingPointInteger() > winnerCarMovingPoint) {
            winnerRacingCarList.clear();
            winnerRacingCarList.add(racingCar);
            winnerCarMovingPoint = racingCar.getCurrentMovingPointInteger();
        }
    }

    private String buildFinalWinnerAnnouncement(List<RacingCar> winnerRacingCarList) {
        String result = String.join(", ", winnerRacingCarList.stream()
                .map(RacingCar::getName)
                .toList());
        return "최종 우승자 : " + result;
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
            System.out.println(racingCar.getRaceOutcomeForCarInRound(racingCar));
        }
        System.out.println();
    }
}
