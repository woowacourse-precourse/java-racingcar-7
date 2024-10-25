package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNamesInput = Console.readLine();
        if (carNamesInput.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
        if (carNamesInput.startsWith(",") || carNamesInput.endsWith(",")) {
            throw new IllegalArgumentException("입력 문자열 앞과 뒤에는 쉼표가 위치할 수 없습니다.");
        }
        if (carNamesInput.contains(",,")) {
            throw new IllegalArgumentException("입력 문자열에는 쉼표가 연속될 수 없습니다.");
        }

        // 수정 대상: 컬렉션을 사용하고, Immutable 하게 만든다.
        final String[] carNames = carNamesInput.split(",");
        if (carNames.length == 1) {
            throw new IllegalArgumentException("경주에 참가할 자동차를 최소 2개 이상 입력해주세요.");
        }

        CarManager carManager = new CarManager(carNames);
        final List<Car> cars = carManager.getCars();

        System.out.println("시도할 횟수는 몇 회인가요?");
        final String playTimesInput = Console.readLine();
        if (playTimesInput.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
        if (!playTimesInput.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수이어야 합니다.");
        }

        System.out.println("실행 결과");
        final int playTimes = Integer.parseInt(playTimesInput);
        for (int i = 0; i < playTimes; i++) {
            MoveStrategy moveStrategy = new RandomNumberMoveStrategy();
            cars.forEach(car -> car.move(moveStrategy));

            for (Car car : cars) {
                final String positionBar = "-".repeat(car.getPosition());
                System.out.println(car.getName() + " : " + positionBar);
            }
            System.out.println();
        }

        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        final List<Car> winningCars = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

        final StringBuilder resultBuilder = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winningCars.size(); i++) {
            final Car winningCar = winningCars.get(i);
            resultBuilder.append(winningCar.getName());
            if (i != winningCars.size() - 1) {
                resultBuilder.append(", ");
            }
        }
        System.out.println(resultBuilder);

        Console.close();
    }
}
