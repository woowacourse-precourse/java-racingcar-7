package racingcar.service;

import racingcar.model.RaceStatus;

public class SetUpService {
    private RaceStatus raceStatus;

    private SetUpService() {
        raceStatus = RaceStatus.getInstance();
    }

    private static class SingletonHelper {
        private static final SetUpService INSTANCE = new SetUpService();
    }

    public static SetUpService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public void setUpRace(String inputText) {
        String[] carNameArray = inputText.split(",", -1);

        int carNumber = carNameArray.length;
        checkCarNumber(carNumber);

        raceStatus.clearCarList();
        for (int index = 0; index < carNumber; index++) {
            raceStatus.setUpCar(carNameArray[index]);
        }
    }

    private void checkCarNumber(int carNumber) {
        if (carNumber > 10) {
            throw new IllegalArgumentException("경주에 참가한 자동차 수가 너무 많습니다.");
        }
    }
}
