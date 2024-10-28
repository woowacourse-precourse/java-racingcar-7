package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location = 0;

    /**
     * 주어진 이름으로 Car 객체를 생성합니다.
     *
     * @param name 객체의 이름을 설정합니다.
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * 0~9 사이의 랜덤한 숫자를 뽑아서, 4 이상이면 한 칸 움직입니다.
     */
    public void attemptMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.location++;
        }
    }

    /**
     * 객체의 위치를 반환합니다.
     *
     * @return 객체의 위치
     */
    public int getLocation() {
        return location;
    }

    /**
     * 객체의 이름을 반환합니다
     *
     * @return 객체의 이름
     */
    public String getName() {
        return name;
    }
}
