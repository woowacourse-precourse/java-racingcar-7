package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final int NAME_MAX = 5;
    private List<Car> cars;
    private int tryCount;

    public void ready() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = readLine();
        cars = createCars(createNames(inputNames));

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountStr = readLine();
        tryCount = changeTryCountToInt(tryCountStr);
    }

    public void start(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            startRound(cars);
        }
    }

    public void end(List<Car> cars) {
        List<String> winners = findWinners(cars);
        printWinners(winners);
    }

    private List<String> findWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getForwardCount(), max);
        }
        for (Car car : cars) {
            if (car.getForwardCount() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private void printWinners(List<String> winners) {
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else {
            String join = String.join(", ", winners);
            System.out.println("최종 우승자 : " + join);
        }
    }

    public void startRound(List<Car> cars) {
        for (Car car : cars) {
            car.goAndStop();
            printCurForward(car);
        }
    }

    public void printCurForward(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getForwardCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String[] createNames(String inputNames) {
        String[] names = inputNames.split(",");
        for (String name : names) {
            if (name.length() > NAME_MAX) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다");
            }
        }
        return names;
    }

    public ArrayList<Car> createCars(String[] names) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public int changeTryCountToInt(String tryCountStr) {
        int tryCount = Integer.parseInt(tryCountStr);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상 이어야 합니다");
        }
        return tryCount;
    }
}
