package racingcar.model;

import static racingcar.model.OutputFormat.NAME_POSITION_DEVIDE;
import static racingcar.model.OutputFormat.POSITION;

import java.util.List;

public class Car {
    private final String name;
    private int position;

    public Car(String inputNames) {
        this.name = inputNames;
        position = 0;
    }

    public String move(int randomNumber) {
        if (isOverFour(randomNumber)) {
            position++;
            return name + NAME_POSITION_DEVIDE.getFormat() + showInString();
        }
        return name + NAME_POSITION_DEVIDE.getFormat() + showInString();
    }

    public int getPosition() {
        return position;
    }

    public List<String> addTopRankers(List<String> topRankers, int maxPosition) {
        if (isSamePosition(maxPosition)) {
            topRankers.add(name);
            return topRankers;
        }
        return topRankers;
    }

    private boolean isOverFour(int randomNumber) {
        return randomNumber >= 4;
    }

    private String showInString() {
        return POSITION.getFormat().repeat(Math.max(0, position));
    }

    private boolean isSamePosition(int maxPosition) {
        return position == maxPosition;
    }

    public static Car create(String inputNames) {
        return new Car(inputNames);
    }
}
