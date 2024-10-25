package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }
    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    //위치 업데이트
    public void move(){
        position++;
    }
    //이름 유효한 값인지 검사
    public void validateName(String name){
        if(name ==null || name.isEmpty() || name.length()>5){
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력하세요.");
        }
    }
}
