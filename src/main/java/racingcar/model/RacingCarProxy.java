package racingcar.model;

import racingcar.common.constant.MessageConstants;
import racingcar.ui.OutputUI;

/**
 * RacingCarProxy는 RacingCar의 프록시 역할을 하며, 자동차의 이동을 기록하고 출력하는 기능을 추가합니다.
 */
public class RacingCarProxy extends RacingCar {

    private static final String DISTANCE_INDICATOR = "-";

    private RacingCarProxy(String name) {
        super(name);
    }

    /**
     * RacingCarProxy를 생성하는 팩토리 메소드입니다.
     *
     * @param name 자동차의 이름입니다.
     * @return RacingCarProxy 객체
     */
    public static RacingCarProxy create(String name) {
        return new RacingCarProxy(name);
    }

    @Override
    public void move() {
        super.move(); // 실제 RacingCar를 이동시킵니다.
        printRaceRecord(); // 이동 후 기록을 출력합니다.
    }

    /**
     * 자동차의 이동 기록을 출력합니다.
     */
    private void printRaceRecord() {
        String carName = getName();
        String distanceIndicator = getDistanceIndicator();

        OutputUI.printResult(MessageConstants.OUTPUT_RACE_RECORD_TEMPLATE, carName, distanceIndicator);
    }

    /**
     * 현재 거리를 기준으로 거리 표시기를 반환합니다.
     *
     * @return 거리 표시기 문자열
     */
    private String getDistanceIndicator() {
        int distance = getDistance(); // 상위 클래스에서 현재 거리 가져오기
        return DISTANCE_INDICATOR.repeat(distance); // 거리에 따른 표시기 생성
    }
}
