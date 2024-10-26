package racingcar;

public class Car {

    private String name;
    private String position;


    public Car(String name) {
        this.name = name;
        this.position = "";

    }

    public String getPosition() {
        return name + " : " + position;

    }

    public String getName() {
        return name;
    }


    public void move(int randomInt) {
        if (randomInt >= 4) {
            position += "-";
        } else {
            System.out.println(name + " : " + randomInt + "이(가) 나와 이동하지 못했습니다.");
        }

    }


}

