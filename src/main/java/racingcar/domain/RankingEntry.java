package racingcar.domain;

public class RankingEntry {
    private final String name;
    private final int position;

    public RankingEntry(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}