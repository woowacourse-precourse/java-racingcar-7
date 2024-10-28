package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private final StringBuilder positionBuilder;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.positionBuilder = new StringBuilder(5);
    }

    public void move(boolean shouldMove){
        if(shouldMove) {
            this.position++;
        }
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        positionBuilder.setLength(0);
        positionBuilder.append(name).append(" : ");
        positionBuilder.append("-".repeat(Math.max(0, position)));
        return positionBuilder.toString();
    }
}