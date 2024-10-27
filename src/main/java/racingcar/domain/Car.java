package racingcar.domain;

import static racingcar.view.CommonMessage.ERROR_MESSAGE_PREFIX;

/**
 * Car 클래스는 개별 차량의 이름과 위치를 관리한다.
 * - 특정 조건에 따라 차량의 위치를 증가시킨다.
 */
public class Car {

    private static final int MOVABLE_POINT = 3;   // 이동 가능 조건: 난수가 3 이상일 때
    private final String name;   // 차량 이름
    private int position = 0;   // 차량 위치 (초기 위치 0)

    /**
     * 생성자에서 차량 이름의 길이를 검증하고, 이름을 초기화한다.
     */
    public Car(String name) {
        validateNameLength(name);   // 이름 길이 검증
        this.name = name;
    }

    public String getName() {
        return name;   // 차량 이름 반환
    }

    /**
     * 난수를 받아 이동 조건을 만족하면 위치를 증가시킨다.
     */
    public int movePosition(int number) {
        if (number >= MOVABLE_POINT) {   // 난수가 MOVABLE_POINT 이상일 때 위치 증가
            return ++position;
        }
        return position;   // 이동 조건 미충족 시 기존 위치 반환
    }

    /**
     * 현재 차량이 비교 대상보다 이동 거리가 짧은지 여부를 반환한다.
     */
    public boolean lessMoveThan(Car car) {
        return position < car.position;
    }

    /**
     * 차량 이름이 5자를 초과하면 예외를 발생시킨다.
     */
    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "자동차 이름은 5자 이하여야 한다.");
        }
    }
}
