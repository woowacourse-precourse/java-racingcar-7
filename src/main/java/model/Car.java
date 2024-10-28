package model;

//Car라는 객체 Field 선언
public class Car {
    private String name;
    private int position;

    //생성자(Constructor)
    public Car(String name){
        if(name.length()>5){
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다");
        }
        this.name = name;
        this.position = 0;
    }

    //Car class의 method(역할을 부여)
    public void move(int randomValue){
        if(randomValue>=4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
