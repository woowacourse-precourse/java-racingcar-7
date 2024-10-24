package racingcar.model;

public class Car {
    private String name;
    private int location;

    public Car(String name){
        if (name.length() > 5) {
            throw new IllegalStateException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.location = 0;
    }

    public void race(boolean carRace){
        if (carRace) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
