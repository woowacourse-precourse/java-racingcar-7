package racingcar;

public class Car {
    private String name;
    private Integer advance;

    public Car(String name, Integer advance) {
        this.name = name;
        this.advance = advance;
    }

    public String getName() {
        return name;
    }

    public Integer getAdvance() {
        return advance;
    }

    public void move() {
        this.advance++;
    }
}