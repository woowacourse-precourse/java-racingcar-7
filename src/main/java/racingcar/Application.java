package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String[] carNames = getCarNames();
        int moveCount = getMoveCount();

        List<Car> cars = createCars(carNames);
    }

    private static String[] getCarNames() {
        System.out.println("자동차 이름을 쉼표로 구분하여 입력하세요.");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int getMoveCount() {
        System.out.println("시도할 회수는 몇 번인가요?");
        String moveCountInput = Console.readLine();
        return validateMoveCount(moveCountInput);
    }

    public static int validateMoveCount(String moveCountInput) {
        int moveCount = Integer.parseInt(moveCountInput);
        if (moveCount < 0) {
            throw new IllegalArgumentException();
        }
        return moveCount;
    }

    // 자동차 객체 생성
    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}

class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public void printPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }
}
