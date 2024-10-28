package racingcar.model;

/**
 * RacingCar 클래스는 경주 자동차의 상태와 동작을 관리한다.
 * 자동차의 이름, 위치, 위치를 출력하는 방식(repeater)을 포함한다.
 */
public class RacingCar {

    // 차의 이름을 저장하는 필드, 고유 식별자로 판단하여 final 설정
    private final String carName;

    // 차의 위치를 출력하기 위한 리피터, 생성자를 통해 설정하며 이후 변경 가능
    private String repeater;

    // 차의 위치를 저장하는 필드
    private int position;

    /**
     * RacingCar 생성자
     * @param carName 자동차 이름(고유 식별자로 사용)
     * @param position 초기 위치 값
     * @param repeater 위치 출력을 위한 문자열 반복자
     */
    public RacingCar(String carName, int position, String repeater) {
        this.carName = carName;
        this.repeater = repeater;
        this.position = position;
    }

    /**
     * 자동차 이름을 반환한다.
     * @return 자동차 이름 문자열
     */
    public String getCarName() {
        return carName;
    }

    /**
     * 자동차의 현재 위치를 반환한다.
     * @return 자동차 위치 값
     */
    public int getPosition() {
        return position;
    }

    /**
     * 이동 가능 여부에 따라 자동차의 위치를 이동시킨다.
     * @param isMovable 이동 가능 여부
     */
    public void move(boolean isMovable) {
        if (isMovable) {
            this.position++;
        }
    }

    /**
     * 현재 위치를 repeater를 기반으로 문자열로 변환하여 반환한다.
     * @return 위치를 시각적으로 표현하는 문자열
     */
    public String getPositionAsString() {
        return repeater.repeat(position);
    }

    /**
     * 위치 출력 방식(repeater)을 변경한다.
     * @param repeater 새로운 위치 출력 방식 문자열
     */
    public void setRepeater(String repeater) {
        this.repeater = repeater;
    }
}