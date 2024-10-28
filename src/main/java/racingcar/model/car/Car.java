package racingcar.model.car;

public class Car implements Comparable<Car> {
    private String name;
    private int status;

    public Car(String givenName) {
        this.name = givenName;
        this.status = 0;
    }

    public void forward() {
        increase();
    }

    public int getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

    private void setStatus(int givenStatus) {
        this.status = givenStatus;
    }

    private void increase() {
        if (getStatus() == Integer.MAX_VALUE) {
            return;
        }
        setStatus(getStatus() + 1);
    }

    @Override
    public int compareTo(Car o) {
        return o.getStatus() - this.getStatus();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

