package racingcar.model;

/**
 * 해당 클래스는 자동차 정보를 저장하는 클래스 입니다.
 *
 * @author Kalsteve98
 * @since 1.0
 */
public class Car {

    private final String name;
    private Long position;

    /**
     * Car 객체를 생성합니다.
     *
     * @param name 자동차 이름
     */
    public Car(String name) {
        this.name = name;
        this.position = 0L;
    }

    /**
     * 자동차 이름을 반환합니다.
     *
     * @return 자동차 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 자동차의 현재 위치를 반환합니다.
     *
     * @return 자동차의 현재 위치
     */
    public Long getPosition() {
        return position;
    }

    /**
     * 자동차를 이동시킵니다.
     */
    public void move() {
        position++;
    }
}
