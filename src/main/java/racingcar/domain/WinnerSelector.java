package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {

    /**
     * 주어진 자동차 리스트에서 최종 우승자를 선정하여 반환한다.
     * 여러 자동차가 공동 우승일 경우, 모두 반환한다.
     *
     * @param cars 경주에 참여한 자동차 리스트
     * @return 우승자 이름 리스트
     */
    public static List<String> selectWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                winners.clear();
                winners.add(car.getName());
                maxPosition = car.getPosition();
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}