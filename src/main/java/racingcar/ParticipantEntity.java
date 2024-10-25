package racingcar;

public class ParticipantEntity {
    String name;
    String distance;

    public ParticipantEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void forward() {
        distance += "-";
    }

    public String getDistance() {
        return distance;
    }
}
