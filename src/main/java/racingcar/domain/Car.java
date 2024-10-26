package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4){
            this.position = position + 1;
        }
    }
}
