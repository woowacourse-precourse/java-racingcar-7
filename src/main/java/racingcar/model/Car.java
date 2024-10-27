package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        validate();
    }

    private void validate(){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 없어요.");
        }
    }

    public String getName() {
        return name.trim();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position += position;
    }
}
