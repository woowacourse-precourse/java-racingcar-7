package racingcar.model;

public class Car {
    private static int INITPOSITION = 0;
    private static int NAME_LENGHTH_LIMIT = 5;
    private String name;
    private int position;

    public Car(String name) {
        carNameLengthLimit(name);
        this.name = name;
        this.position = INITPOSITION;
    }

    private void carNameLengthLimit(String name) {
        if (name.length() > NAME_LENGHTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. 프로그램을 종료합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 아무값도 들어가지 않았습니다. 프로그램을 종료합니다.");
        }
    }

    public void settingPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
