package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RaceStatus;
import racingcar.model.dto.Car;

public class RacingService {
    private RaceStatus raceStatus;

    private RacingService() {
        raceStatus = RaceStatus.getInstance();
    }

    private static class SingletonHelper {
        private static final RacingService INSTANCE = new RacingService();
    }

    public static RacingService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public void race() {
        int carNumber = raceStatus.getCarNumber();

        for (int index = 0; index < carNumber; index++) {
            moving(index);
        }
    }

    private void moving(int index) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            raceStatus.moveForward(index);
        }
    }

    public String getRaceProgress() {
        StringBuilder raceProgress = new StringBuilder();
        int carNumber = raceStatus.getCarNumber();

        for (int index = 0; index < carNumber; index++) {
            Car car = raceStatus.getCarByIndex(index);
            raceProgress.append(car.toString())
                    .append("\n");
        }

        return raceProgress.toString();
    }

}
