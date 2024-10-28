package racingcar;

public class Car {
    String name;
    int distance;

    public void isOver6OrEmpty(String name){
        if (name.length() > 5 || name.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
