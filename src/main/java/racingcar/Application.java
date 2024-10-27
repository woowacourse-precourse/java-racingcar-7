package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.gameinit();
        System.out.println("실행 결과");
        gameController.gameStart();
        gameController.gameResult();
    }
}
