package racingcar;

public class Car {
    private final String name;
    private String progress;

    Car (String name) {
        this.name = name;
        progress = "";
    }

    Car (String name, String progress) {
        this.name = name;
        this.progress = progress;
    }

    public void forward() {
        progress += "-";
    }

    public String getName() {
        return name;
    }

    public String getProgress() {
        return progress;
    }
}
