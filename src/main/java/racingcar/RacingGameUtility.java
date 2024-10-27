package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameUtility {

    public static void runGame() {
        printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> nameList = splitStringToArray(input, ",");
        List<RacingCar> carList = generateRacingCar(nameList);

        printMessage("시도할 횟수는 몇 회인가요?");
        int count = 0;
        try {
            count = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력하셔야 합니다.");
        }

        printMessage("\n실행결과");
        for(int i = count; i > 0; i--) {
            for (RacingCar car : carList) {
                moveRacingCar(car);
                printMessage(car.racingCarInfo());
            }
            printMessage("");
        }

        printMessage(getResultMessage(carList));
    }

    public static void moveRacingCar(RacingCar car) {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            car.raiseMoveCount();
        }
    }

    public static void checkNameLength(String input) {
        if(input.isEmpty() || input.length() > 5) {
            throw new IllegalArgumentException(input + " ::: 이름은 5자 이하만 가능합니다.");
        }
    }

    public static List<String> splitStringToArray(String input, String delimiter) {
        String[] list = input.split(delimiter);

        Arrays.stream(list).forEach(RacingGameUtility::checkNameLength);

        return Arrays.stream(list).collect(Collectors.toList());
    }

    public static List<RacingCar> generateRacingCar(List<String> nameList) {
        List<RacingCar> carList = new ArrayList<>();
        nameList.forEach(str -> {
            carList.add(new RacingCar(str));
        });

        return carList;
    }

    public static String getResultMessage(List<RacingCar> carList) {
        int max = carList.stream().mapToInt(RacingCar::getMoveCount).filter(count -> count >= 0).max().orElse(0);
        List<RacingCar> winner = carList.stream().filter(racingCar -> racingCar.getMoveCount() == max).toList();

        String result = winner.stream().map(RacingCar::getName).collect(Collectors.joining(", "));

        return "최종 우승자 : " + result.trim();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
