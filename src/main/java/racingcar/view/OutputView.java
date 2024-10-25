package racingcar.view;

import racingcar.model.GameTryCount;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;
import racingcar.model.RacingCarMove;
import racingcar.model.RandomNumber;

public class OutputView {

    public void printInitResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(final Object object) {
        System.out.println(object.toString());
    }

    public void printEndResult(final String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    private void printCurrentCarPosition(RacingCarMove racingCarMove, RandomNumber randomNumber) {
        for (RacingCar car : RacingCarList.get()) {
            car.move(racingCarMove, randomNumber);
            printRoundResult(car);
        }
    }

    public void printRoundResult() {
        final RacingCarMove racingCarMove = new RacingCarMove();
        final RandomNumber randomNumber = new RandomNumber();

        for (int i = 0; i < GameTryCount.get(); i++) {
            printCurrentCarPosition(racingCarMove, randomNumber);
            System.out.println();
        }
    }
}
