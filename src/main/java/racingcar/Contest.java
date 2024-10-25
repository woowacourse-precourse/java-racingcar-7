package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Contest {
    private ArrayList<Car> cars = new ArrayList();
    private int gameCount = 0;


    public void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        carNameInput();
        System.out.println("시도할 횟수는 몇 회인가요?");
      gameCountInput();
    }

    private void carNameInput(){

        String inputCars = Console.readLine();
        String[] carNames = inputCars.split(",");
        validateCarNames(carNames); //예외처리
        createCars(carNames);
    }

    private void createCars(String[] carNames) {
        for(String name : carNames) {
            Car car = new Car(name.trim());
            cars.add(car);
        }
    }
    private void gameCountInput(){
        gameCount = Integer.valueOf(Console.readLine().trim());
        if (gameCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수이어야 합니다.");
        }
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("자동차 이름이 2개보다 작습니다.");
        }
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
            }
        }
    }
    public void startRace() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            this.carRun();
            gameInfoPrint();
            System.out.println();
        }
        gameEnd();
    }
    private void carRun(){
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) { //0~9 정수 중 한 개
                car.move();
            }
        }
    }
    private void gameInfoPrint(){
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), car.getDistance());
        }
    }

    private String whoIsWinner() {
        int maxDistance = -1;
        StringBuilder winnerBuilder = new StringBuilder();

        for (Car car : cars) {
            int distance = car.getPos();

            if (distance > maxDistance) {
                maxDistance = distance;
                winnerBuilder.setLength(0);
                winnerBuilder.append(car.getName());
            } else if (distance == maxDistance) {
                winnerBuilder.append(", ").append(car.getName());
            }
        }

        return winnerBuilder.toString();
    }
    public void gameEnd() {
        System.out.println("최종 우승자 : "+ whoIsWinner());
    }
}