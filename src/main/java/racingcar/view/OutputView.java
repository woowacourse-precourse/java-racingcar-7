package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    public static void displayPrompt(int num) {
        if (num == 1) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        } else {
            System.out.println("시도할 횟수는 몇 회인가요?");
        }
    }

    public static void displayRacing(List<Car> cars) {
        String result = "";
        result += "실행 결과" + "\n";

        for (Car car : cars) {
            result += car.getName() + " : " + "-".repeat(car.getPosition()) + "\n";
        }

        System.out.println(result);
    }

    public static void displayWinners(List<Car> winners) {
        String result = "";
        result += "최종 우승자 : ";

        if (winners.size() == 1) {
            result += winners.get(0).getName();
        } else {
            String collect = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));
            result += collect;
        }
        System.out.print(result);
    }
}
