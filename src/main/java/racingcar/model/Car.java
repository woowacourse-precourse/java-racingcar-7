package racingcar.model;

public class Car{
    private String name;
    private int position = 0;

    public Car(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public void move(){
        position++;
    }

    public String displayPosition(){
        return "-".repeat(position);
    }
}