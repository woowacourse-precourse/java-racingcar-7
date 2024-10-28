package racingcar.model;

import java.util.Collections;
import java.util.List;

public class Car {
    String name;
    int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveForward() {
        this.distance++;
    }

    public void printCarDistance() {
        System.out.print(generateDistanceStatus());
    }

    public String generateDistanceStatus() {
        return name + " : " + "-".repeat(distance) + "\n";
    }

    // 거리 정보를 읽기 전용 리스트로 반환
    public List<Integer> getDistanceList() {
        return Collections.unmodifiableList(Collections.singletonList(distance));
    }
}