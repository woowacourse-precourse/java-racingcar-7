package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private final List<String> advanceMarkers;

    private Car(String name) {
        this.name = name;
        this.advanceMarkers = new ArrayList<>();
    }

    public static Car from(String name) {
        return new Car(name);
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
}
