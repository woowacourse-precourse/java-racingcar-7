package racingcar;

public class Car {
    String name;
    String result = "";
    public Car(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
