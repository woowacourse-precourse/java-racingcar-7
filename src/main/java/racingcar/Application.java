package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //입력 및 출력
        List<Car> cars = createCars();
        int tryCount = getTryCount();
        //3. 자동차 로직
        runRace(cars, tryCount);
        //4. 우승자 로직
        winners(cars);
    }

    private static List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            String trimmedName = name.trim();
            validateCarName(trimmedName);  // 이름 유효성 검사
            cars.add(new Car(trimmedName));
        }
        return cars;
    }

    private static void validateCarName(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.");
        }
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryCount;
    }

    // 3. 자동차 경주 로직 구현
    private static void runRace(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceRound(cars);
            System.out.println();
        }
    }

    private static void raceRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            System.out.println(car);
        }
    }
    //4.우승자 찾는 메소드
    private static void winners(List<Car> cars) {
        //cars의 mapToInt를 통해 객체를 정수값으로 변환하고 최대값 찾는 것. 만약 메서드값 X -> 0으로 반환
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        //winner 카운팅.
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
