package Entity;

public class Result {
    private StringBuilder builder;

    public Result() {
        builder = new StringBuilder();
        builder.append("실행 결과\n");
    }

    public void addResult(String msg) {
        builder.append(msg);
    }

    public String getResult() {
        return builder.toString();
    }
}
