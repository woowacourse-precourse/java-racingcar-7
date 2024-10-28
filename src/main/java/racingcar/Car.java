package racingcar;

public class Car {
    private String name;
    private int position =0;

    public Car(String name){
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name){
        if(name == null || name.isEmpty() || name.length() > 5 || !name.matches("[a-zA-Z]+")){
            throw new
                    IllegalArgumentException("자동차 이름은 1자 이상 5자이하");
        }
    }
    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    public void moveForward(){
        position++;
    }
    public boolean isAtPosition(int position){
        return this.position == position;
    }
}
