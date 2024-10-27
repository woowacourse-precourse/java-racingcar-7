package racingcar.car;

public class Car {

    private final String name;
    private int location;

    public Car(String name) {
        nameValidation(name);
        this.name = name;
        this.location = 0;
    }

    public void forwardOne() {
        this.location++;
    }

    public String getCurrentLocation() {
        return "-".repeat(this.location);
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    private void nameValidation(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
