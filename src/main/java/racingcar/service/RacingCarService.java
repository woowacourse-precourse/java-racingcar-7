package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Race;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarService {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVE_CONDITION = 4;

    /***
     * 레이스 시작
     * @param race 경기에 참여하는 자동차들과 시도 횟수
     * @return 전체 라운드의 레이스 결과를 하나의 문자열로 반환
     */
    public String raceStart(Race race) {

        List<String> roundResults = new ArrayList<>();

        Integer round = race.getRound();
        List<Car> cars = race.getCars();

        for (int i = 0; i < round; i++) {
            roundResults.add(raceOneRound(cars));
        }

        return String.join("\n\n", roundResults);
    }

    /***
     * 한 라운드의 레이스 진행
     * @param cars 라운드에 참여하는 자동차들
     * @return 라운드별 레이스 결과를 문자열로 반환
     */
    public String raceOneRound(List<Car> cars) {

        List<String> roundResult = new ArrayList<>();

        cars.forEach(car -> {
            if (isMove()) {
                car.move();
            }
            roundResult.add(car.printPosition());
        });

        return String.join("\n", roundResult);
    }

    /***
     * 우승자 찾기
     * @param race 경기에 참여하는 자동차들과 시도 횟수
     * @return 최종 우승자를 문자열로 반환
     */
    public String findWinner(Race race) {

        int maxPosition = getMaxPosition(race.getCars());

        return race.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    /***
     * 최대 위치 찾기
     * @param cars 라운드에 참여하는 자동차들
     * @return 자동차들 중 최대 위치를 정수형으로 반환
     */
    public Integer getMaxPosition(List<Car> cars) {

        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    /***
     * 전진 가능 여부 판단
     * @return 전진 가능 여부를 불린형으로 반환
     */
    public Boolean isMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MOVE_CONDITION;
    }
}
