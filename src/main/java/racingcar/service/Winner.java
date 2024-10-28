package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Entity.Car;

/**
 * 경주에서 우승자를 결정하는 서비스 클래스입니다.
 * 주어진 자동차 리스트에서 가장 높은 위치에 있는 자동차들을 우승자로 선정합니다.
 */
public class Winner {

    /**
     * 주어진 자동차 리스트에서 우승자를 결정하여 반환합니다.
     * 우승자는 가장 높은 위치에 있는 자동차 하나 이상일 수 있습니다.
     *
     * @param cars 우승자를 결정할 자동차들의 리스트
     * @return 우승자 자동차들의 리스트
     */
    public static List<Car> getWinners(List<Car> cars) {
        // 모든 자동차의 위치 중 최댓값을 찾습니다.
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        // 최댓값과 동일한 위치를 가진 자동차들을 우승자로 추가할 리스트를 초기화합니다.
        List<Car> winners = new ArrayList<>();

        // 각 자동차의 위치를 확인하여, 최댓값과 동일한 위치를 가진 자동차를 우승자 리스트에 추가합니다.
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        // 우승자 리스트를 반환합니다.
        return winners;
    }
}
