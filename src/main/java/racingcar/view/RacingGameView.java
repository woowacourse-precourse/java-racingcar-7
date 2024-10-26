package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class RacingGameView {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return List.of(Console.readLine().split(","));
    }

    public int getAttemptCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printGameStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarPositions(List<Car> cars) {
        cars.forEach(car ->
                System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()))
        );
        System.out.println();
    }

    public void printWinner(List<String> winnerCarNames) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerCarNames));
    }
}
