package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars_name = getCarsName();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = getAttemptCount();
        runRace(cars_name, attemptCount);

    }


    public static List<String> getCarsName() {
        String input = Console.readLine();

        // 빈 문자열 예외 처리
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없다.");
        }
        // 이름 분리
        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    public static void validateCarNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();

        for (String name : carNames) {
            name = name.trim();
            // 개별 이름이 빈 문자열일 경우 예외 처리
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 빈 이름이 포함될 수 없다.");
            }

            // 이름이 5자를 초과할 경우 예외 처리
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다 ");
            }

            // 중복된 이름 예외 처리
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없다");
            }
        }
    }

    public static int getAttemptCount() {
        String input = Console.readLine();
        return validateAttemptCount(input);
    }

    // 유효성 검사만을 위한 메서드 추가
    public static int validateAttemptCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 빈 문자열일 수 없습니다.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException("시도 횟수는 공백을 포함할 수 없습니다.");
        }

        try {
            int attemptCount = Integer.parseInt(input);
            if (attemptCount < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 양수여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }

    // 자동차 경주 실행 메서드
    public static void runRace(List<String> carNames, int attemptCount) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        // 경주 횟수만큼 라운드 반복
        for (int i = 0; i < attemptCount; i++) {
            System.out.println("\n라운드 " + (i + 1));
            for (Car car : cars) {
                car.move();  // 각 자동차에 대해 무작위 이동 수행
                System.out.println(car);  // 자동차의 현재 위치 출력
            }
        }


    }


}


