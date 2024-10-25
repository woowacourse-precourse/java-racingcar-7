package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;

public class OutputView {

    private OutputView() {
    }

    public static void inputCarNames() {
        print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
    }

    public static void inputTryCount() {
        print("시도할 횟수는 몇 회인가요?\n");
    }

    public static void roundResult(List<CarDto> cars) {
        print("실행 결과\n");
        cars.forEach(car ->
            print(String.format("%s : %s%n", car.name(), "-".repeat(car.position())))
        );
        print("\n");
    }

    public static void finalResult(List<CarDto> winners) {
        List<String> winnerNames = winners.stream()
            .map(CarDto::name)
            .toList();
        print(String.format("최종 우승자 : %s", String.join(", ", winnerNames)));
    }

    private static void print(String content) {
        System.out.print(content);
    }
}
