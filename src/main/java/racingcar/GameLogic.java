package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameLogic {
    private final List<Car> cars = new ArrayList<>();
    private final int numberOfRaces;

    public GameLogic(List<String> carNames, int numberOfRaces) {
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        this.numberOfRaces = numberOfRaces;
    }

    public void race() {
        for (int i = 0; i < numberOfRaces; i++) {
            raceOnce();
            displayResults();
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.advance();
            }
        }
    }

    private void displayResults() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void finalResults() {
        List<String> winners = determineWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));  // 우승자를 쉼표로 구분하여 출력
    }

    private List<String> determineWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)  // 최장 거리와 일치하는 자동차 필터
                .map(Car::getName)                               // 해당 자동차의 이름 반환
                .collect(Collectors.toList());                   // 리스트로 수집
    }
}
