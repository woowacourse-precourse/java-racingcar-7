package racingcar;

class Car {

    private String name;
    private int currentLocation = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        currentLocation++;
    }

    public void rename(String newName) {
        name = newName;
    }

    public String name() {
        return name;
    }

    public int getcurrentLocation() {
        return currentLocation;
    }
}
