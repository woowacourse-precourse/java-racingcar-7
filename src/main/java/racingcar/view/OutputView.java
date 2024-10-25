package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class OutputView {

    private static final String CAR_POSITION_INDICATOR = "-";

    private static final String ASK_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_FOR_NUMBER_OF_ROUNDS = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printAskingForCarNames() {
        System.out.println(ASK_FOR_CAR_NAMES);
    }

    public void printAskingForNumberOfRounds() {
        System.out.println(ASK_FOR_NUMBER_OF_ROUNDS);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarsLocation(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.racingCarList()) {
            printCarCurrentLocation(racingCar);
        }
        System.out.println();
    }

    private void printCarCurrentLocation(RacingCar racingCar) {
        String carName = racingCar.name();
        int currentLocationValue = racingCar.currentLocationValue();
        System.out.println(carName + " : " + CAR_POSITION_INDICATOR.repeat(currentLocationValue));
    }
}
