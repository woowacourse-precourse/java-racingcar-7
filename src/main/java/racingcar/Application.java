package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        int attempts;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            carName = carName.trim(); // 이 부분 나중에 Car에 메세지를 주는식으로 바꿔도 될듯
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            cars.add(new Car(carName));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = readLine();
        try {
            attempts = Integer.parseInt(inputAttempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                int number = pickNumberInRange(0, 9);
                if (number >= 4) {
                    car.move();
                }
            }
            // 경주의 현재 상태를 출력한다.
            for (Car car : cars) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
        }

        // 우승자의 position 추출
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow(() -> new IllegalArgumentException("경주에 참가한 자동차가 없습니다."))
                .getPosition();

        // maxPosition과 같은 값을 가지는 자동차 추출
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        //최종 우승자 출력
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
