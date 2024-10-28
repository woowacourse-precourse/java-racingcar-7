package racingcar.View;

import racingcar.Model.RacingCar;

public class OutputView {

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printBars(RacingCar car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
    }
}
