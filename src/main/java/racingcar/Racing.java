package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> cars;
    private final int chance;

    public Racing(List<Car> cars, int chance) {
        this.cars = cars;
        this.chance = chance;
    }

    public void startRace() {
        for (int i = 0; i < chance; i++) {
            playRound();
            printProgress();
        }
        printWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move(); // 이동할 때마다 '-' 추가
            }
        }
    }

    private void printProgress() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    private void printWinners() {
        // 1. 각 자동차의 `progress` 문자열 길이를 사용해 최대 이동 거리를 구함
        int maxProgressLength = 0;
        for (Car car : cars) {
            maxProgressLength = Math.max(maxProgressLength, car.getProgress().length());
        }

        // 2. 최대 이동 거리를 달성한 자동차 이름을 리스트에 추가
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getProgress().length() == maxProgressLength) {
                winners.add(car.getName());
            }
        }

        // 3. 최종 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
