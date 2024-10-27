package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과하면 안됩니다.");
        }
        this.name = name;
    }

    public void move(boolean isMove){
        if(isMove){
            position++;
        }
    }

    // getter
    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
