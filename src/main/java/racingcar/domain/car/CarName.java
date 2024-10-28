package racingcar.domain.car;

public class CarName {

    private final String carName;
    public final int NAME_THRESHOLD = 5;

    public CarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 " + NAME_THRESHOLD + "글자를 초과했습니다.");
        }
        this.carName = name;
    }

    public String getCarName() {
        return carName;
    }
}
