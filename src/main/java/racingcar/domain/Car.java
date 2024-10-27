package racingcar.domain;

public class Car implements Raceable {
    private final static int STEP_SIZE = 1;
    private final static char DISTANCE_SYMBOL = '-';
    private final static int NAME_MAX_LEGNTH = 5;
    private final static int NAME_MIN_LEGNTH = 1;
    private final String name;
    private int moveCount;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.moveCount = 0;
    }

    @Override
    public void moveFoward() {
        this.moveCount += STEP_SIZE;
    }

    @Override
    public String getCurrentDistance() {
        StringBuilder progressBuilder = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            progressBuilder.append(DISTANCE_SYMBOL);
        }
        return progressBuilder.toString();
    }

    public String getName(){
        return this.name;
    }

    private void validateNameLength(String name){
        if(name.length() > NAME_MAX_LEGNTH) {
            throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }else if(name.length() < NAME_MIN_LEGNTH){
            throw new IllegalArgumentException("이름은 1글자 이상만 가능합니다.");
        }
    }
}
