package racingcar.car;

public class CarImpl implements Car{
    private String name;
    private int position;

    public CarImpl(String name) {
        this.name = name;
        this.position = 0;
    }
    public void forward() {
        this.position += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
