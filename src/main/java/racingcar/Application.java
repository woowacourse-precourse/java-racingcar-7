package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String carNamesInput = Console.readLine();
        if (carNamesInput.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
        if (carNamesInput.startsWith(",") || carNamesInput.endsWith(",")) {
            throw new IllegalArgumentException("입력 문자열 앞과 뒤에는 쉼표가 위치할 수 없습니다.");
        }
        if (carNamesInput.contains(",,")) {
            throw new IllegalArgumentException("입력 문자열에는 쉼표가 연속될 수 없습니다.");
        }

        // 수정 대상: 컬렉션을 사용하고, Immutable 하게 만든다.
        final String[] carNames = carNamesInput.split(",");
        if (carNames.length == 1) {
            throw new IllegalArgumentException("경주에 참가할 자동차를 최소 2개 이상 입력해주세요.");
        }

        final Set<String> registeredCarNames = new HashSet<>();
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            if (!registeredCarNames.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
            cars.add(new Car(carName));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        final String playTimesInput = Console.readLine();
        if (playTimesInput.isBlank()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }
        if (!playTimesInput.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수이어야 합니다.");
        }

        System.out.println("실행 결과");
        final int playTimes = Integer.parseInt(playTimesInput);
        for (int i = 0; i < playTimes; i++) {
            for (Car car : cars) {
                final int randomNumber = Randoms.pickNumberInRange(0, 9);
                car.move(randomNumber);
            }

            for (Car car : cars) {
                final String positionBar = "-".repeat(car.getPosition());
                System.out.println(car.getName() + " : " + positionBar);
            }
            System.out.println();
        }
    }
}
