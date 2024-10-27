package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;
import racingcar.Winner;

public class ConsoleOutputHandler {

    public void printCarNameInstruction() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInstruction() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printExecumentInstruction(Car car) {
        System.out.print(car.getCarName() + " : ");
        printProgressLine(car.getForwardCount());
    }

    public void printProgressLine(int forwardCount) {
        for (int i = 0; i < forwardCount; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        String winnerMembers;
        if (winners.size() > 1) {
            winnerMembers = String.join(", ", winners.stream()
                    .map(Car::getCarName)
                    .collect(Collectors.toList()));
        }
        if (winners.size() == 1) {
            winnerMembers = winners.getFirst().getCarName();
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            if (i < winners.size() - 1) {
                System.out.print(winners.get(i).getCarName() + ", ");
                continue;
            }

            System.out.println(winners.get(i).getCarName());
            System.out.println();
        }
    }

}
