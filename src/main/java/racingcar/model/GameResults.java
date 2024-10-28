package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * GameResults 클래스는 경주 게임의 진행 상태 및 최종 결과를 관리한다.
 * 각 라운드마다 자동차의 상태 및 최종 우승자를 계산하는 역할을 수행한다.
 */
public class GameResults {

    private final List<RacingCar> cars;  // 경주에 참가하는 자동차 리스트
    private final int trial;  // 경주 시도 횟수

    /**
     * GameResults 생성자
     * @param cars 경주에 참가하는 RacingCar 객체 리스트
     * @param trial 시도 횟수
     */
    public GameResults(List<RacingCar> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    /**
     * 시도 횟수만큼 반복하여 시도 마다의 상태와 최종 우승자를 반환한다.
     * @return (각 시도마다의 자동차 상태 문자열) + (최종 우승자 문자열)
     */
    public String getResults() {
        return getCarStatesPerTrial() + getResultOfGame();
    }

    /**
     * 각 시도마다의 자동차 상태를 문자열로 저장하여 반환한다.
     * @return 모든 시도에 대한 자동차 상태 문자열
     */
    private String getCarStatesPerTrial() {
        StringBuilder result = new StringBuilder();
        result.append("\n실행 결과\n");

        for (int i = 0; i < trial; i++) {
            moveCars(cars);
            for (RacingCar car : cars) {
                result.append(car.getCarName())
                        .append(" : ")
                        .append(car.getPositionAsString())
                        .append("\n");
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * 최종 우승자를 계산하여 문자열로 반환한다.
     * @return 우승자 이름을 포함한 문자열
     */
    private String getResultOfGame() {
        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ");

        List<RacingCar> winners = findWinners();
        StringJoiner joiner = new StringJoiner(", ");
        for (RacingCar car : winners) {
            joiner.add(car.getCarName());
        }

        result.append(joiner.toString());
        return result.toString();
    }

    /**
     * 최종 우승자 리스트를 계산하여 반환한다.
     * @return 최종 우승자 RacingCar 객체 리스트
     */
    private List<RacingCar> findWinners() {
        List<RacingCar> winners = new ArrayList<>();
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);

        for (RacingCar car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    /**
     * GameResults에서 관리하는 모든 자동차를 이동시킨다.
     * @param cars 이동할 RacingCar 객체 리스트
     */
    private void moveCars(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.move(isMovable());
        }
    }

    /**
     * 자동차가 이동할 수 있는지를 랜덤으로 결정한다.
     * @return 이동 가능 여부를 나타내는 boolean 값
     */
    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
