package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.model.Car;

public class RacingGameView {
    public String printInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String printInputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }

    public void printCurForward(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getForwardCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else {
            String join = String.join(", ", winners);
            System.out.println("최종 우승자 : " + join);
        }
    }
}
