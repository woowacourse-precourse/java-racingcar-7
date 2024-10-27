package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int trialCount;
    private int currentTrial;

    /*public RacingGame(String[] carNames, int trialCount) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim())); // 자동차 이름 추가
        }
        this.trialCount = trialCount;
        this.currentTrial = 0;
    }*/

    // 수정된 생성자
    public RacingGame(List<Car> cars, int trialCount) {
        this.cars = cars; // List<Car>를 직접 사용
        this.trialCount = trialCount;
        this.currentTrial = 0;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9)); // Randoms API 사용
        }
        currentTrial++;
    }

    public boolean hasMoreTrials() {
        return currentTrial < trialCount; // 더 진행할 차수가 있는지 확인
    }

    public List<Car> getCars() {
        return cars; // 자동차 목록 반환
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.getPosition() == maxPosition).toList(); // 최대 위치의 자동차 반환
    }
}
