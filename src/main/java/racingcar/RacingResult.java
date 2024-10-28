package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<RacingSnapshot> snapshots;

    public RacingResult(int count) {
        this.snapshots = new ArrayList<>(count);
    }

    public List<RacingSnapshot> getSnapshots() {
        return snapshots;
    }

    public void takeSnapshot(List<Car> cars) {
        snapshots.add(new RacingSnapshot(cars));
    }

    public void print() {
        for (RacingSnapshot snapshot : snapshots) {
            snapshot.print();
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners()));
    }

    public List<String> winners() {
        return snapshots.getLast().winners();
    }
}
