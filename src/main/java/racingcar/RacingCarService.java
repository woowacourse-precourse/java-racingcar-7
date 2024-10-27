package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    private int winnerCarMovingPoint = 0;

    public boolean moveOrStop(int randomNumber) {
        if (randomNumber >= 4 && randomNumber < 10) {
            return true;
        }
        if (randomNumber >= 0 && randomNumber < 4) {
            return false;
        }
        throw new IllegalArgumentException("무작위 값 설정에서 오류가 발생하였습니다");
    }

    public int randomNumberCreate() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }


    public void increasingCurrentMovingPoint(RacingCar racingCar, int randomNum) {
        if (moveOrStop(randomNum)) {
            racingCar.plusCurrentMovingPoint();
        }
    }

    public String getWinnerRacingCar(RacingCarList racingCarList) {
        List<RacingCar> winnerRacingCarList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList.getRacingCarList()) {
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

}
