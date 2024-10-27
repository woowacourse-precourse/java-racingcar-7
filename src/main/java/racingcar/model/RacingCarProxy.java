package racingcar.model;

import racingcar.common.constant.MessageConstants;
import racingcar.ui.OutputUI;

/**
 * RacingCarProxy는 RacingCar의 프록시 역할을 하며, 자동차의 이동을 기록하고 출력하는 기능을 추가합니다.
 */
public class RacingCarProxy implements Drivable {

    private static final String DISTANCE_INDICATOR = "-";
    private final RacingCar racingCar;

    private RacingCarProxy(RacingCar racingCar) {
        this.racingCar = racingCar;
    }

    /**
     * RacingCarProxy를 생성하는 팩토리 메소드입니다.
     *
     * @param name 자동차의 이름입니다.
     * @return Drivable 인터페이스를 구현한 RacingCarProxy 객체
     */
    public static Drivable create(String name) {
        return new RacingCarProxy(new RacingCar(name));
    }

    @Override
    public void move() {
        racingCar.move(); // 실제 RacingCar를 이동시킵니다.
        printRaceRecord(); // 이동 후 기록을 출력합니다.
    }

    /**
     * 자동차의 이동 기록을 출력합니다.
     */
    private void printRaceRecord() {
        String carName = racingCar.getName();
        String distanceIndicator = getDistanceIndicator();

        OutputUI.printResult(MessageConstants.OUTPUT_RACE_RECORD_TEMPLATE, carName, distanceIndicator);
    }

    /**
     * 현재 거리를 기준으로 거리 표시기를 반환합니다.
     *
     * @return 거리 표시기 문자열
     */
    private String getDistanceIndicator() {
        int distance = racingCar.getDistance();
        return DISTANCE_INDICATOR.repeat(distance); // 거리에 따른 표시기 생성
    }

    @Override
    public int getDistance() {
        return racingCar.getDistance(); // RacingCar의 현재 거리 반환
    }

    @Override
    public String getName() {
        return racingCar.getName(); // RacingCar의 이름 반환
    }
}
