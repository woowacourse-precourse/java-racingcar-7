package racingcar.domain;

public class ScoreEntry {
    private Integer rank;
    private String carName;
    private Integer forwardCount;

    public ScoreEntry(String carName, Integer forwardCount) {
        this.carName = carName;
        this.forwardCount = forwardCount;
    }
    public Integer getForwardCount() {
        return forwardCount;
    }

    public String getCarName() {
        return carName;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}