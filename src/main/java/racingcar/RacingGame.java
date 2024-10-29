package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

// 게임 로직을 담당하는 클래스
public class RacingGame {
    private List<Car> cars;
    private int attempts;

    public void start() {
        inputCars();
        inputAttempts();
        play();
        announceWinners();
    }

    private void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        cars = new ArrayList<>();

        for (String name : carNames) {
            validateCarName(name);
            cars.add(new Car(name.trim()));
        }
    }

    public void validateCarName(String name) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
    }



    private void inputAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        attempts = validateAttempts(input);

    }

    public int validateAttempts(String input){
        try { // 시도할 횟수의 입력값 체크
            if (!input.matches("\\d+")) { // 입력값이 정수(양의 정수)인지 확인
                throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
            }
            int attemptCount = Integer.parseInt(input);

            return attemptCount;

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.", e);
        }
    }

    private void play() {
        for (int i = 0; i < attempts; i++) {
            raceOnce();
            printRoundResult();
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    private void announceWinners() {
        int maxDistance = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
