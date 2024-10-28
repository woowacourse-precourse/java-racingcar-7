package racingcar;

public class Car implements Vehicle {
    private String name;
    private Engine engine;

    private static int MAX_NAME_LENGTH = 5;

    public Car(String name, Engine engine) {
        validateName(name);
        
        this.name = name;
        this.engine = engine;
    }

    @Override
    public int pushPedal() {
        return engine.accelerate();
    }

    @Override
    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
    }
}
