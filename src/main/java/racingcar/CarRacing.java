package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<>();

    // 자동차 이름 목록을 받아 Car 객체 리스트를 초기화하는 메서드
    public void initializeCars(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    // 지정된 횟수만큼 각 회차별로 경주 결과를 출력하는 메서드
    public void startRace(int attempts) {
        for (int i = 0; i < attempts; i++) {
            System.out.println("회차 " + (i + 1) + " 결과:");
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPositionDisplay());
            }
            System.out.println();
        }
    }

    // 사용자로부터 자동차 이름을 쉼표로 구분하여 입력받는 메서드
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine().trim();

        // 쉼표로 자동차 이름을 구분하여 리스트로 변환
        List<String> carNames = Arrays.asList(input.split(","));

        // 자동차 이름이 비어 있는지 확인
        if (carNames.isEmpty() || carNames.contains("")) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }

        return carNames;
    }

    // 사용자로부터 경주 횟수를 입력받는 메서드
    public int getRaceAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine().trim();

        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
    // 자동차 이름의 길이를 검사하는 메서드
    public void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
    }
}
