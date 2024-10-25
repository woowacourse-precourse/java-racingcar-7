package racingcar;

public class Car {

    private String name;
    private int forwardLevel;

    public Car() {
        this.forwardLevel = 0;
    }

    public void nameCar(String name) {
        this.name = name;
    }

    public String getCarName() {
        return this.name;
    }

    public void printForwardLevel() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.forwardLevel; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
