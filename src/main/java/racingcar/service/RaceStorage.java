package racingcar.service;

public class RaceStorage {
    private final StringBuilder storage;

    public RaceStorage() {
        storage = new StringBuilder();
    }

    public void addResult(String result) {
        storage.append(result).append("\n");
    }

    public void addBlankLine() {
        storage.append("\n");
    }

    public String getResults() {
        return storage.toString();
    }

}
