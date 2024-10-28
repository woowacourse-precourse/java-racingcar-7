package racingcar.domain;

public class Car {

    private Long id;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }
}
