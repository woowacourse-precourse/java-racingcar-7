package racingcar.domain.car;

public class Car {

    private final String name;
    private final ForwardPolicy policy;
    private int position = 0;

    public Car(String name, ForwardPolicy policy) {
        this.name = name;
        this.policy = policy;
    }

    public void tryForward() {
        if (policy.forward()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
