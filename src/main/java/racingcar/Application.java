package racingcar;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarGame game = GameFactory.of(List.of("1", "2", "3"), 5);
        game.play();
    }
}
