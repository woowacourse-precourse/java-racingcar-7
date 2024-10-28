package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashSet;
import java.util.Set;

public class RacingGame {

    public void start() {
        Set<String> carNames = getCarNames();
        Set<Car> playingCars = PlayingCarFactory.createCars(carNames);
        int round = setRound();
        play(round, playingCars);
    }

    private int setRound() {
        System.out.println("시도할 회수는 몇 회인가요?");
        int round =  Integer.parseInt(Console.readLine());
        if (round < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return round;
    }

    private Set<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        Set<String> carNameSet = new LinkedHashSet<>();
        for (String carName : carNames) {
            carNameSet.add(carName);
            System.out.println(carNameSet);
        }
        if (carNameSet.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
        for (String carName : carNameSet) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNameSet;
    }

    private void play(int round, Set<Car> playingCars) {
        for (int i = 0; i < round; i++) {
            eachRoundResult(playingCars);
            System.out.println();
        }
        System.out.println("최종 우승자 : " + getWinner(playingCars));
    }

    private void eachRoundResult(Set<Car> playingCars) {
        for (Car car : playingCars) {
            car.move();
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private String getWinner(Set<Car> playingCars) {
        int maxPosition = playingCars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalArgumentException::new);
        return playingCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .reduce((a, b) -> a + ", " + " " + b)
            .orElseThrow(IllegalArgumentException::new);
    }
}
