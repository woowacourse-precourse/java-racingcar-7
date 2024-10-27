package racingcar.io.Output;

import java.util.List;
import racingcar.domain.Car.Car;

public class ConsoleOutputHandler implements OutputHandler {

    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    @Override
    public void printCarNameRequest() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
    }

    @Override
    public void printRoundRequest() {
        System.out.println(ROUND_REQUEST_MESSAGE);
    }

    @Override
    public void printCarProgress(String carName, int position) {
        System.out.print(carName + " : ");

        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        printNewLine();
    }

    @Override
    public void printWinners(List<Car> winners) {
        System.out.print(WINNERS_MESSAGE);

        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i).getName() + DELIMITER);
        }
        System.out.println(winners.getLast().getName());
        printNewLine();
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
