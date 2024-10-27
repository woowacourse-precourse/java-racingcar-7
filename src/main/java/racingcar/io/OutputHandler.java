package racingcar.io;

import racingcar.car.RacingCars;

public class OutputHandler {

    public void showCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRoundInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showGameResult(String gameResult) {
        System.out.print("\n실행결과\n" + gameResult);
    }

    public void showWinners(RacingCars racingCars) {
        String winnersName = String.join(", ", racingCars.getWinnersName());
        System.out.println("최종 우승자 : " + winnersName);
    }
}
