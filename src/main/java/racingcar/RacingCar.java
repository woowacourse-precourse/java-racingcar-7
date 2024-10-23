package racingcar;

public class RacingCar implements Car{
    private String name;

    public RacingCar(String name) {
        this.name = setName(name);
    }

    @Override
    public void setStaus() {

    }

    @Override
    public void move() {

    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        if (name.length()>5)
            throw  new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        this.name = name;
        return name;
    }
}
