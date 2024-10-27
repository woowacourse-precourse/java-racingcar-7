package racingcar;

import java.util.Arrays;
import java.util.List;

import static racingcar.RacingProcess.*;
import static racingcar.ResultPrint.*;
import static racingcar.WinnerPrint.*;

public class Application {

    public static List<String> nameList;
    public static int racingNumber;
    public static String[] processResult;
    public static int[] moveCount;

    public static void main(String[] args) {

        String carInput = InputSetting.nameSet();
        nameList = CarList.carList(carInput);

        String numberInput = InputSetting.numberSet();
        racingNumber = RacingNum.numValid(numberInput);

        //경기 결과 저장 배열 초기화
        processResult= new String[carNumber];
        Arrays.fill(processResult, "");

        moveCount = new int[carNumber];
        Arrays.fill(moveCount, 0);

        //횟수만큼 결과 출력 반복
        System.out.println("실행 결과");

        for (int i = 0; i < racingNumber; i++) {
            racingProcess();
            resultPrint();
        }

        winnerPrint();
    }
}