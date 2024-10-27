package racingcar.io;

import java.util.List;
import racingcar.car.Car;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void showRacingCarNameComment() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void showRacingCarNumberComment() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void showResultComment() {
        System.out.println("실행 결과");
    }

    @Override
    public void showRaceResults(List<Car> cars) {
        System.out.println();
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getMileageDisplay());
        }
    }

    @Override
    public void showRaceWinner(List<String> winners) {
        System.out.println();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
