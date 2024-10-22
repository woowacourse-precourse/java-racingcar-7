package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(","); // 쉼표로 구분하여 배열로

        try {
            InputValidator.validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // 시도할 횟수를 입력하는 곳
        System.out.println("시도할 횟수는 몇 회인가요?");
        String attemptsInput = Console.readLine();

        try {
            InputValidator.validateAttempts(attemptsInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        int attempts = Integer.parseInt(attemptsInput);

        // 동적 배열(ArrayList)로 자동차 리스트 관리
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        // 경주 진행
        for (int i = 0; i < attempts; i++) {
            for (Car car : carList) {
                car.move(); // 이동 로직
                System.out.print(car.getName() + ": " + "-".repeat(car.getPosition()) + "\n"); // 전진 결과 출력
            }
            System.out.println();
        }

        // 우승자 결정
        int maxPosition = carList.stream().mapToInt(Car::getPosition).max().orElse(0); // 가장 멀리 간 자동차의 위치
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        // 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
