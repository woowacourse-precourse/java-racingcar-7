package racingcar.model.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    //to do : 삼항연산자 안 쓰게 고치기
    public int move(int randomNumber) {
        return randomNumber >= 4 ? this.position + randomNumber : this.position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
