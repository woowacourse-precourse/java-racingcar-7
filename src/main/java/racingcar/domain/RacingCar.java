package racingcar.domain;

import racingcar.util.RandomNumberGenerator;
import java.util.List;
import java.util.stream.Collectors;


public class RacingCar {
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars;
    private final int attemptCount;

    public RacingCar(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void startRace() {
        System.out.println("\nRace start!");
        for (int i = 0; i < attemptCount; i++) {
            raceOnce();       // 한 라운드 진행
            printRaceStatus(); // 라운드 결과 출력
        }
        printWinners();
    }

    private void raceOnce() {
        for (Car car : cars) {
            car.tryMove(); // Car의 이동 시도를 위임
        }
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.displayPosition());  // Car의 displayPosition() 메서드로 상태 출력
        }
        System.out.println();  // 라운드 간 줄바꿈
    }

    private void printWinners() {
        List<String> winners = determineWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> determineWinners() {
        int maxPosition = cars.stream()
                .mapToInt(car -> extractPositionFromDisplay(car.displayPosition()))
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> extractPositionFromDisplay(car.displayPosition()) == maxPosition)
                .map(car -> extractNameFromDisplay(car.displayPosition()))
                .collect(Collectors.toList());
    }

    private int extractPositionFromDisplay(String display) {
        return display.lastIndexOf('-') - display.indexOf(':');
    }

    private String extractNameFromDisplay(String display) {
        int colonIndex = display.indexOf(':');
        String name = display.substring(0, colonIndex);
        return name.trim();
    }
}
