package racingcar;

import racingcar.domain.Cars;

public class UserOutputService {

    public UserOutputService() {

    }

    public void printResult(Cars winners) {
        System.out.print("최종 우승자: ");
        winners.printCarNames();
    }
}
