package racingcar;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if(RandomNumberGenerator.pickRandomNumber() >= 4) {
            position++;
        }
    }

    public void printCount() {
        System.out.print(name + " : ");
        for(int j = 0; j< position; j++){
            System.out.print("-");
        }
    }
}
