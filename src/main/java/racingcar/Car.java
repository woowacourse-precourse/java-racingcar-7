package racingcar;

public class Car {

    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public void increaseCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return name + " : " + printCountResult(this.count);
    }

    private String printCountResult(int count) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
