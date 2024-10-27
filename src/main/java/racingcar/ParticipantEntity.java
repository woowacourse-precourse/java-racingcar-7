package racingcar;

public class ParticipantEntity {
    private String name;
    private String distance;

    public ParticipantEntity(String name) {
        this.name = name;
        this.distance = "";
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
