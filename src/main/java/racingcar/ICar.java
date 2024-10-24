package racingcar;

public interface ICar {

    /**
     * 전진
     *
     * @return 전진 후 현재 위치
     */
    int drive();

    String getName();

    /**
     * 현재 위치
     */
    int getPosition();
}
