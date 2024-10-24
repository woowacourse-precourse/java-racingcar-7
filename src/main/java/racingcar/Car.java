package racingcar;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    public void increaseDistance(){
        this.distance++;
    }

    public static void validateNameLength(String name){
        if(name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하의 문자열만 가능합니다.");
    }

    public String toString(){
        return this.name + " : " + "-".repeat(this.distance);
    }
}
