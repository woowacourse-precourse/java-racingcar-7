package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameRounds;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private final static String CAR_POSITION = "-";

    @Override
    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printTryCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void printGameRounds(GameRounds result) {
        printResultMessage();
        List<Cars> gameRounds = result.getGameRoundList();
        for (Cars cars : gameRounds) {
            printOneRound(cars.getCarList());
            printEmptyLine();
        }
    }

    private void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    private void printOneRound(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + CAR_POSITION.repeat(car.getDistance()));
        }
    }

    @Override
    public void printWinner(List<String> winnerNameList) {
        String winner = String.join(", ", winnerNameList);
        System.out.println("최종 우승자 : " + winner);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
