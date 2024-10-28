package racingcar.domain;

public class Car {

    public Car(String name) {
        this.name = name;
    }

    private int id;

    private String name;

    private Integer forwardCount = 0;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getForwardCount() {
        return this.forwardCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void goForward(){
        this.forwardCount++;
    }
}
