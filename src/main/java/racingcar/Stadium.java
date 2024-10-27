package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Stadium {

    private String inputNames;

    private final Integer count;
    private final List<Car> carList = new ArrayList<>();

    public Stadium() {
        input();
        this.count = inputCount();
    }

    public void start() {
        for (int i = 0; count > i; i++) {
            for (Car car : carList) {
                car.advance(Randoms.pickNumberInRange(0, 9));
            }
            printResult();
        }
    }

    public List<String> getWinners() {
        Optional<Car> maxDistanceCar = carList.stream()
                .max(Comparator.comparing(Car::getDistance));
        if (maxDistanceCar.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int maxDistance = maxDistanceCar.get().getDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int inputCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputNames = Console.readLine();
        for (String name : tokenization()) {
            carList.add(new Car(name));
        }
    }

    private String[] tokenization() {
        String[] names = inputNames.split(",");
        validateNameLength(names);
        return names;
    }

    private void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해야 합니다.");
            }
        }
    }

    // 실행 출력
    public void printResult() {
        for (Car car : carList) {
            System.out.println(car);
        }

        System.out.println();
    }
}
