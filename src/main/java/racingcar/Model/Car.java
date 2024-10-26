package racingcar.Model;

public class Car {
    final private String name;
    private int advance;

    public Car(String name) {
        this.name = name;
        this.advance = 0;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public String getName() {
        return name;
    }

    public int getAdvance() {
        return advance;
    }
}
