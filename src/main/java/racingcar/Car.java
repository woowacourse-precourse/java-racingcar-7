package racingcar;

public class Car {

    private final String name;
    private Long distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0L;
    }

    public void execute(final int command) {
        if (command >= 4) {
            this.distance++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.name + " : ");
        for (int i=0; i<this.distance; i++) {
            builder.append("-");
        }
        return builder.append("\n").toString();
    }
}
