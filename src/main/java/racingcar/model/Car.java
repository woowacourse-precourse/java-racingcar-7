package racingcar.model;

public class Car {

    private final static String FORWARD_MARK = "-";
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

    public String getForwardMark(){
        return FORWARD_MARK.repeat(forward);
    }

    public void move(){
        forward++;
    }


}
