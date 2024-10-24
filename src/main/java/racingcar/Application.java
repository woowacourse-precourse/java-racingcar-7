package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarInputHandler carInputHandler = new CarInputHandler();
        String inputCarNames = carInputHandler.userInputCarNames();
        String[] separatedCarNames = carInputHandler.splitCarNames(inputCarNames);
        List<String> carNameList = new ArrayList<>(Arrays.asList(separatedCarNames));

        String howManyTimesMove = carInputHandler.userInputHowManyTimes();
        int numberOfMoves = Integer.parseInt(howManyTimesMove);
        // 출력 TEST 출력 메서드 따로 생성후 삭제 예정
        System.out.println(numberOfMoves);


    }
}
