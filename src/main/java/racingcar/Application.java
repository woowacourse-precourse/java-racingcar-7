package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차들의 이름
        String inputStr = Console.readLine();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) " + inputStr);

        // 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
        String repeatRaceNum = Console.readLine();
        String[] carNames = splitCarsName(inputStr);

        // Check Error
        checkError(carNames, repeatRaceNum);

        // Check Error 후 시도 횟수 출력
        int repeatRaceIntNum = Integer.parseInt(repeatRaceNum);
        System.out.println("시도할 횟수는 몇 회인가요? : " + repeatRaceIntNum);

        int[] carProgressArr = new int[carNames.length];
        for (int i = 0; i < repeatRaceIntNum; i++) {
            if (i == 0) {
                System.out.println();
                System.out.println("실행 결과");
            }
            for (int car_ind = 0; car_ind < carNames.length; car_ind++) {
                int carProgress = canProgressWithRandomNum();
                carProgressArr[car_ind] += carProgress;
                printCarNameProgress(carNames[car_ind], carProgressArr[car_ind]);
            }
            System.out.println();
        }
        // 우승자 판별
        String winners = getWinners(carNames, carProgressArr);
        System.out.println("최종 우승자 : " + winners);

    }

    public static void checkError(String[] carNameArr, String repeatNum) {
        checkCarNameError(carNameArr);
        checkRepeatNumError(repeatNum);
    }

    public static void checkRepeatNumError(String repeatNum) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(repeatNum);

        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameError(String[] carNameArr) {
        for (String carName : carNameArr) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static String[] splitCarsName(String inputStr) {
        // 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
        String[] carsName = inputStr.split(",");
        return carsName;
    }

    public static int canProgressWithRandomNum() {
        // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            return 1;
        }
        return 0;
    }

    public static void printCarNameProgress(String carName, int progressNum) {
        String progressBar = "-".repeat(progressNum);
        System.out.println(carName + " : " + progressBar);
    }

    public static int getLargestProgress(int[] progressArr) {
        int maxNum = 0;
        for (int i : progressArr) {
            if (i > maxNum) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    public static String getWinners(String[] carNames, int[] progressArr) {
        ArrayList<String> winners = new ArrayList<String>();

        int largeProgressNum = getLargestProgress(progressArr);
        for (int i = 0; i < carNames.length; i++) {
            int progressNum = progressArr[i];
            if (progressNum == largeProgressNum) {
                winners.add(carNames[i]);
            }
        }
        var members = List.of(winners);
        var result = String.join(",", winners);
        return result;
    }

}