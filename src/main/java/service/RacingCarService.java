package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import model.Car;

public class RacingCarService {

    // 한 라운드를 실행
    public void playRound(List<Car> cars) {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    // 우승자 찾기
    public List<String> findFinalWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return extractWinners(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> extractWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
