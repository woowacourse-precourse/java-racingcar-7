package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleView {

    /* 입력 */
    public String[] inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        return carName.split(",");
    }

    public int inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    /* 출력 */
    public void outputResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    // 각 라운드 결과 출력 메소드
    public void outputRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    // 우승자 출력 메소드
    public void outputWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
