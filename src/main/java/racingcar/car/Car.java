package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 자동차 경주 게임에서 사용되는 자동차를 표현하는 클래스. 각 자동차는 이름과 현재 위치를 가지며, 무작위로 전진할 수 있다.
 *
 * @author JBumLee
 * @version 2024/10/26
 */
public abstract class Car {
    private final String name;
    private int position = 0;

    /**
     * 자동차를 생성한다. 생성자는 private으로, 상속받은 자식에서만 생성 할 수 있다.
     *
     * @param name 자동차의 이름 (5자 이하)
     * @throws IllegalArgumentException 이름이 유효하지 않은 경우
     */
    protected Car(String name) {
        validateName(name);
        this.name = name;
    }

    /**
     * 자동차 이름의 유효성을 검사한다. 이름은 null이 아니어야 하고, 5자 이하여야 하며, 빈 문자열이 아니어야 한다.
     *
     * @param name 검사할 자동차 이름
     * @throws IllegalArgumentException 이름이 유효하지 않은 경우
     */
    private void validateName(String name) {
        if (name == null || name.length() > 5 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 하며, 빈 값일 수 없습니다.");
        }
    }

    /**
     * 자동차를 전진시킨다. 전진 조건이 충족되면 위치를 한 칸 증가시킨다.
     */
    public void move() {
        if (hasMoveCondition()) {
            position++;
        }
    }

    /**
     * 자동차의 전진 조건을 확인한다. 0-9 사이의 무작위 값이 4 이상인 경우 전진할 수 있다.
     *
     * @return 전진 가능 여부
     */
    private boolean hasMoveCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    /**
     * 자동차의 현재 위치를 반환한다.
     *
     * @return 현재 위치
     */
    public int getPosition() {
        return position;
    }

    /**
     * 자동차의 이름을 반환한다.
     *
     * @return 자동차 이름
     */
    public String getName() {
        return name;
    }
}