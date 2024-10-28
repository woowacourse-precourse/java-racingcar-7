package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.RacingCar;

public class GameView {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
        return Console.readLine();
    }

    public int inputRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void displayCurrentRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.printf("%s : ", racingCar.getCarName());
            System.out.println("-".repeat(racingCar.getPosition()));
        }
        System.out.println();
    }

    public void displayWinner(List<String> winners) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }
}
