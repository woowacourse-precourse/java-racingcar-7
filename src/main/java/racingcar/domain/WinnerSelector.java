package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 우승자 선정 기능을 제공하는 클래스
 */
public class WinnerSelector {

    /**
     * 주어진 자동차 리스트에서 최종 우승자를 선정하여 반환합니다.
     * 여러 자동차가 공동 우승일 경우, 모두 반환합니다.
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