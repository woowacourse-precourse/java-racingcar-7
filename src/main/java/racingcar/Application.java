package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.domain.Car;
import racingcar.enums.ErrorMessage;
import racingcar.enums.ViewMessage;

public class Application {

    public static void main(String[] args) {
        System.out.println(ViewMessage.PROMPT_CAR_NAMES.getMessage());
        String inputString = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(inputString, ",");
        List<Car> cars = new ArrayList<>();
        List<String> winners = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getMessage());
            }
            cars.add(new Car(carName));
        }
        System.out.println(ViewMessage.PROMPT_PLAY_TIMES.getMessage());
        inputString = Console.readLine();
        System.out.println(ViewMessage.PRINT_BLANK.getMessage());
        System.out.println(ViewMessage.PRINT_RESULT.getMessage());
        int playTime = Integer.parseInt(inputString);
        int maxMoveCount = 0;
        while (playTime-- > 0) {
            for (Car car : cars) {
                int value = Randoms.pickNumberInRange(0, 9);
                car.move(value);
                maxMoveCount = Math.max(maxMoveCount, car.moveCount);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Car car : cars) {
                stringBuilder.append(car);
                stringBuilder.append(ViewMessage.PRINT_BLANK.getMessage());
            }
            System.out.println(stringBuilder);
        }
        for (Car car : cars) {
            if (car.moveCount == maxMoveCount) {
                winners.add(car.name);
            }
        }
        String result = String.join(", ", winners);
        System.out.printf(ViewMessage.PRINT_WINNERS.getMessage(result));
    }
}
