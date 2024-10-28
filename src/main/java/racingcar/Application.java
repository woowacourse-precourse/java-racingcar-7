package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MOVE_THRESHOLD = 4;
    public static void main(String[] args) {
        // 입력 받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<Car> cars;

        try {
            cars = initializeCars(carNamesInput);
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
            throw e; // 오류 메시지 출력 후 프로그램 정상 종료
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds;

        try {
            rounds = Integer.parseInt(Console.readLine().trim());
            if (rounds <= 0) {
                throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("에러: 잘못된 입력입니다. " + e.getMessage());
            throw e; // 잘못된 입력 처리 후 프로그램 정상 종료
        }

        // 실행 결과
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            playRound(cars);
            printRoundResult(cars);
        }

    }

    // 자동차 초기화
    private static List<Car> initializeCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            name = name.trim();
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }

        return cars;
    }

    // 라운드 실행
    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    // 라운드 결과 출력
    private static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

}

// 자동차 클래스
class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return "-".repeat(position);
    }

    public int getPositionValue() {
        return position;
    }

    public void move() {
        position++;
    }
}
