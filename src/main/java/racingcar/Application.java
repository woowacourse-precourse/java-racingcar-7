package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public void start() {
        inputCarNames();
        inputTryCount();
        race();
        printWinners();
    }

    private void inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= 0){
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        validateNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateNames(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private void race() {
        for ( int i =0; i < tryCount; i++) {
            moveCars();
            printRaceStatus();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPositionLength() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPositionLength());
        }
        return maxPosition;
    }

    private void printWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = findWinners(maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().start();
    }
}
