package racingcar;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class RacingGame {
    private List<Car> cars;
    private int attempts;

    public void start() {
        cars = createCars(inputCarNames());
        attempts = inputAttempts();

        for (int i = 0; i < attempts; i++) {
            playRound();
            printRoundResults();
        }
        printWinners();  // 최종 우승자 출력
    }

    private List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name)); // 각 이름으로 Car 객체 생성 후 리스트에 추가
        }
        return cars;
    }

    private String[] inputCarNames() { // 자동차 이름을 입력받음
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(","); // 입력된 이름을 쉼표로 분리
        validateNames(names); // 유효성 검증
        return names;
    }

    private void validateNames(String[] names) { // 유효성 검증
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private int inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 숫자여야 합니다.");
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRoundResults() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionDisplay());
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = getMaxPosition();  // 가장 멀리 전진한 위치를 찾음
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition(); // 최고 위치값을 갱신함
            }
        }
        return maxPosition;
    }
}