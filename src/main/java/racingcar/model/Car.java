package racingcar.model;

public class Car {
    final private String name;
    private int advance;

    public Car(String name) {
        this.name = name;
        this.advance = 0;
    }

    public void go(){
        this.advance = this.advance + 1;
    }

    public String getName() {
        return name;
    }

    public int getAdvance() {
        return advance;
    }
}
