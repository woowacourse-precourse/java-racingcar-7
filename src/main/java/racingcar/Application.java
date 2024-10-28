package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
class RacingGame {
    List<Car> cars;
    int round;

    public void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        cars = new LinkedList<>();
        for (String name : carNames) {
            name = name.trim();
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름의 최대길이는 5글자 입니다.");
            }
            cars.add(new Car(name));
        }
    }

    public void inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            round = Integer.parseInt(input);
            if (round <= 0) {
                throw new IllegalArgumentException("라운드 수는 양수로 설정해야 합니다.");
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public void runGame() {
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.moveForward(Randoms.pickNumberInRange(0, 9));
            }
            printRoundStatus();
        }
    }

    private void printRoundStatus() {
        for (Car car : cars) {
            String status = car.getName() + " : ";
            status += "-".repeat(car.getPosition());
            System.out.println(status);
        }
        System.out.println();
    }


    public void printWinners() {
        List<Integer> positions = new LinkedList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }

        int maxPosition = 0;
        for (int position : positions) {
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        List<String> winners = new LinkedList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 :" + String.join(", ", winners));
    }
}