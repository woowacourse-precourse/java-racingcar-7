package racingcar.io.Output;

import java.util.List;
import racingcar.domain.Car.Car;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void printCarNameRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void printRoundRequest() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void printCarProgress(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    @Override
    public void printNewLine() {
        System.out.println();
    }
}
