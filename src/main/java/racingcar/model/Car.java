package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private final List<String> advanceMarkers;

    private Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.advanceMarkers = new ArrayList<>();
    }

    public static Car from(String name) {
        return new Car(name.strip());
    }

    public void advance(int number) {
        if (number > 3) {
            advanceMarkers.add("-");
        }
    }

    public void addAdvanceMarker() {
        advanceMarkers.add("-");
    }

    public int getAdvanceMarkerCount() {
        return advanceMarkers.size();
    }

    public String getName() {
        return name;
    }

    public List<String> getAdvanceMarkers() {
        return advanceMarkers;
    }

    public void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다. 초과된 자동차 이름 : " + name);
        }
    }
}
