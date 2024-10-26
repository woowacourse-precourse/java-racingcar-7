package racingcar.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int location = 0;
    public Car(String name) {
        this.name = name;
        validateName();
    }
    public void move(){
        location++;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
    private void validateName() {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH || !isLowercaseAlphabet()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없으며, 5자 이하로 입력해야 합니다.");
        }
    }
    private boolean isLowercaseAlphabet(){
        return name.matches("^[a-z]+$");
    }
}
