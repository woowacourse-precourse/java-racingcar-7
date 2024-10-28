package racingcar;

public class RacerName {
    private final String name;
    private static int naming = 1;

    public RacerName(String name) {
        this.name = checkName(name);
    }

    private String checkName(String name) {
        String racerName = name.trim();
        if (racerName.isEmpty()) {
            racerName = "car" + naming++;
        }
        if (racerName.length() > 5) {
            throw new IllegalArgumentException("이름이 5자를 초과했습니다.");
        }
        return racerName;
    }

    @Override
    public String toString() {
        return name;
    }
}
