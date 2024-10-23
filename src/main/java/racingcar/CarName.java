package racingcar;

public class CarName {
    private final String value;

    public CarName(String name) {
        if(name.length()>10){
                throw new IllegalArgumentException("자동차 이름은 최대 10자까지 가능합니다.");
        }
        if(name.length()<1){
                throw new IllegalArgumentException("자동차 이름은 최소 1자부터 가능합니다.");
        }
        this.value = name;
    }

    public static CarName createCarName(String name) {
        return new CarName(name);
    }

    public String getValue() {
        return this.value;
    }
}
