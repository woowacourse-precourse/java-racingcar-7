package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class CarReady {
    private final List<Car> cars = new ArrayList<>();
    private final int chance;

    public CarReady() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.chance = Integer.parseInt(Console.readLine());
        createCars(names);
    }

    private void createCars(final String participants) {
        String[] participantNames = participants.split(",");
        for (String name : participantNames) {
            cars.add(new Car(name));
        }
    }

    public void startRace() {
        Racing racing = new Racing(cars, chance);
        racing.startRace();
    }
}
