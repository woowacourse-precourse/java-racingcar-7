package racingcar;

public class Car {

    private String name;
    private String position;


    public Car(String name) {
        this.name = name;
        this.position = "";

    }

    public String getPosition() {
        return name + "의 현재위치: " + position;

    }

    public void move(int randomInt) {
        if (randomInt >= 4) {
            position += "-";
        } else {
            System.out.println(randomInt + "가 나와 이동하지 못했습니다.");
        }

    }


}

