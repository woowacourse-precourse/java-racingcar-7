package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

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
