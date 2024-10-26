package racingcar;

public class Application {
    public static void main(String[] args) {
        Data data = new Data();
        Initializer.initData();
        RaceController.startRacing();
    }
}
