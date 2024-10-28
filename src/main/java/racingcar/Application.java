package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
