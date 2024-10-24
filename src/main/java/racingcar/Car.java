package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
public class Car {

    private String carName;
    private String position;

    public Car(String carName) {
        setCarName(carName);
        this.position = "";
    }

    // setter
    public void setCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하이어야 합니다.");
        }
        this.carName = carName;
    }

    // getter
    public String getCarName() {
        return carName;
    }

    public String getPosition() {
        return position;
    }

    public void moveForward() {
        int randNum = Randoms.pickNumberInRange(0,9);
        if (randNum >= 4) {
            this.position += "-";
        }
    }
}
