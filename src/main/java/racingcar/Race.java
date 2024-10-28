package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            playRound();
            printRoundResult();
        }
    }

    // 각 라운드에서 랜덤값으로 자동차들을 움직임
    private void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    // 각 라운드 결과 출력
    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionDisplay());
        }
        System.out.println();
    }

    // 우승자 추출
    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    // 가장 멀리 간 자동차 위치 확인
    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}