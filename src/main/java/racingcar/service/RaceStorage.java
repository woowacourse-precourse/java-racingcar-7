package racingcar.view;

public final class ResultStorage {
    private static final ResultStorage instance = new ResultStorage();
    private final StringBuilder storage;

    private ResultStorage() {
        storage = new StringBuilder();
    }

    public static ResultStorage getInstance() {
        return instance;
    }

    public void addResult(String result) {
        storage.append(result).append("\n");  // 줄바꿈 포함해 저장
    }

    public void addBlankLine() {
        storage.append("\n");
    }

    public String getResults() {
        return storage.toString();
    }

    public void clear() {
        storage.setLength(0);
    }
}
