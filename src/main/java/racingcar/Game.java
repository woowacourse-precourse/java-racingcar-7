package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));
        System.out.println("시도할 회수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        // TODO: 횟수 입력 검증

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        System.out.println("\n실행 결과");
        while (tryCount-- > 0) {
            cars.forEach(Car::tryMove);
            for (Car car: cars) {
                System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
            }
            System.out.println();
        }

        int winnerPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();

        List<String> winnerCarNames = cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .toList();
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerCarNames));
    }
}
