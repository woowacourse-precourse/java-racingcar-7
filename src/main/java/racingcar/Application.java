package racingcar;

import delimiter.InputDelimiter;
import input.CarName;
import input.Move;
import java.util.List;
import racingGame.WholeCycleGame;

public class Application {
    public static void main(String[] args) {
        CarName carName = new CarName();
        Move move = new Move();

        // 게임에 필수적인 인자인 참가한 자동차 리스트, 움직이는 횟수 객체 구현
        List<String> participateCarList = carName.inputHandler();
        int numberOfMove = move.inputHandler();

        WholeCycleGame wholeCycleGame = new WholeCycleGame();

        // 레이싱게임 시작
        wholeCycleGame.gameStart(participateCarList, numberOfMove);
    }
}
