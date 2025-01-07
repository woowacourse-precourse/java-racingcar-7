package racingcar;

public class Car {
    public static final int MINIMUM_MOVE_VALUE = 4;
    private static final String FORWARD_UNIT = "-";
    private static final int DEFAULT_POSITION = 0;
    private final Name name;
    private int position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void verifyCarName(String name) {
        if (name.isEmpty()) {
            throw new CustomException("자동차 이름을 입력해주세요");
        }
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new CustomException("자동차 이름은 최대 5자입니다.");
        }
    }

    public void move(int random) {
        if (random >= MINIMUM_MOVE_VALUE) {
            this.position++;
        }
    }

    public void printCarInfo() {
        StringBuilder forwardUnits = new StringBuilder();
        for (int i = 0; i < position; i++) {
            forwardUnits.append(FORWARD_UNIT);
        }
        System.out.printf("%s : %s%n", this.name, forwardUnits);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

}
