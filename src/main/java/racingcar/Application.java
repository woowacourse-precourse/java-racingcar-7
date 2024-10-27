package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//자동차 이름 및 위치 관리
class Car {
    private final String name;
    private int placement;

    public Car(String name) {
       checkCarName(name);
        this.name = name;
        this.placement = 0;
    }

    private void checkCarName(String name) {
        if (name.length() > 5) { throw new IllegalArgumentException();}
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) { this.placement++; }
    }

    public String getName() { return name; }
    public int getPlacement() { return placement; }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(placement);
    }
}


//자동차 경주 기능
class Racing {
    private final List<Car> cars;
    private final int trialCount;

    public Racing(List<String> carNames, int trialCount) {
        this.cars = createCars(carNames);
        this.trialCount = trialCount;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList  = new ArrayList<>();
        for (String name : carNames) { carList.add(new Car(name)); }
        return carList;
    }

    public void startRacing() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < trialCount; i++) {
            runTrial();
            System.out.println();
        }
    }

    private void runTrial() {
        for (Car car : cars) {
            car.move();
            System.out.println(car);
        }
    }

    public List<String> winners() {
        int maxPlacement = getMaxPlacement();
        return getWinners(maxPlacement);
    }

    private int getMaxPlacement() {
        return cars.stream()
                .mapToInt(Car::getPlacement)
                .max()
                .orElse(0);
    }

    private List<String> getWinners(int maxPlacement) {
        List<String> winners = new ArrayList<>();
        for (Car car: cars) { addWinnerIfMaxPlacement(winners, car, maxPlacement); }

        return winners;
    }

    private void addWinnerIfMaxPlacement(List<String> winners, Car car, int maxPlacement) {
        if (car.getPlacement() == maxPlacement) { winners.add(car.getName()); }
    }
}

//프로그램 시작점
public class Application {
    public static void main(String[] args) {
        try{
            List<String> carNames = inputCarNames();
            int trialCount = inputTrialCount();

            Racing racing = new Racing(carNames, trialCount);
            racing.startRacing();

            List<String> winners = racing.winners();
            System.out.println("최종 우승자 : " + String.join(", ", winners));

        } catch (IllegalArgumentException e) { throw new IllegalArgumentException(); }
    }

    //자동차 이름 기능
    private static List<String> inputCarNames() {
       System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
       String carNamesInput = Console.readLine();
       List<String> carNames = List.of(carNamesInput.split(","));
       checkCarName(carNames);
       return carNames;
    }

    private static void checkCarName(List<String> carNames) {
        if (carNames.isEmpty()) { throw new IllegalArgumentException(); }
        carNames.forEach(Application::checkSingleCarName);
    }

    private static void checkSingleCarName(String name) {
        if (name.isBlank()) { throw new IllegalArgumentException(); }
    }

    //경주 시도 횟수 기능
    private static int inputTrialCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialCountInput = Console.readLine();
        int trialCount = parseTrialCount(trialCountInput);
        checkTrialCount(trialCount);
        return trialCount;
    }

    private static int parseTrialCount(String trialCountInput) {
        try { return Integer.parseInt(trialCountInput); }
        catch (NumberFormatException e) { throw new IllegalArgumentException(); }
    }

    private static void checkTrialCount(int trialCount) {
        if (trialCount <= 0) { throw new IllegalArgumentException(); }
    }
}
