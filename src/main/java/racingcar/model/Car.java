package racingcar.model;

public class Car {

    private String name;
    private int forward;

    private Car(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.forward = 0;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName(){
        return name;
    }

    public int getForward(){
        return forward;
    }

    public void move(int count){
        forward += count;
    }


}
