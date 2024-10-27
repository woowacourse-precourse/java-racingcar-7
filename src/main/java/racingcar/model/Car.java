package racingcar.model;

public class Car {

    private String name;
    private String mileage;

    public Car(String name) {
        this.name = name;
        this.mileage = "";
    }

    public String getName() {
        return this.name;
    }

    public int getMileage() {
        return this.mileage.length();
    }

    public String getStatus() {
        return this.name + " : " + this.mileage + "\n";
    }

    public void advance() {
        this.mileage += "-";
    }

}
