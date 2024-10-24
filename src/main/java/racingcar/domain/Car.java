package racingcar.domain;

public class Car {

    private String name;
    private StringBuilder result;

    public Car(String name) {
        this.name = name.trim();
        this.result = new StringBuilder();
    }

    public String getName() {
        return name;
    }

    public void addResult() {
        result.append("-");
    }

    public String getResult() {
        return result.toString();
    }
}


