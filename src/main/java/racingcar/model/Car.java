package racingcar.model;

public class Car implements Comparable{

    private Long mileage = 0L;

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, Long mileage) {
        this.name = name;
        this.mileage = mileage;
    }

    public boolean validate(String name) {
        return true;
    }

    public void forward() {
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
