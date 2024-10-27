package racingcar;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // 차명 입력
            String[] carNames = getCarNames(scanner);
            // 레이스 횟수 입력
            int raceRounds = getRaceRounds(scanner);
            // 차 객체 생성
            List<Car> cars = initializeCars(carNames);
            // 레이스 시작
            startRace(cars, raceRounds);
            // 우승자 출력
            printWinners(cars);

        } catch (IllegalArgumentException e) { // 잘못된 값 예외 처리
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // 차 이름 입력
    private static String[] getCarNames(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = scanner.nextLine().split(",");
        // 이름 유효성 검사
        checkCarNames(carNames);
        return carNames;
    }

    // 차 이름 유효성 검사
    public static void checkCarNames(String[] carNames) {
        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.length() > 5 || carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    // 레이스 횟수 입력 및 한 자리 수 이상인지 유효성 검사
    private static int getRaceRounds(Scanner scanner) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceRounds = scanner.nextInt();
        if(raceRounds < 1){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return raceRounds;
    }

    // 차 배열 초기화
    private static List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++ ){
            cars.add(new Car(carNames[i].trim()));
        }
        return cars;
    }

    // 경주 시작 후 차 이동 및 결과 출력
    private static void startRace(List<Car> cars, int raceRounds){
        Random random = new Random();
        System.out.println("실행 결과");

        for (int i = 0; i < raceRounds; i++) { // 지정된 시도 횟수만큼 반복
            for (Car car : cars) {
                if (random.nextInt(10) >= 4) {
                    car.moveForward();
                }
            }
            for (Car car : cars) {
                System.out.println(car);
            }
            System.out.println();
        }
    }

    // 우승자 결정 및 출력
    private static void printWinners(List<Car> cars){
        List<String> winners = new ArrayList<>();
        int topPosition = 0;

        for(Car car : cars){
            if(car.currentPosition() > topPosition ){
                topPosition = car.currentPosition();
            }
        }

        for(Car car : cars){
            if(car.currentPosition() == topPosition){
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

// 차 객체 생성
class Car {
    private final String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void moveForward(){
        location++;
    }

    public String getName(){
        return name;
    }

    public int currentPosition(){
        return location;
    }

    public String toString(){
        return name + " : " + "-".repeat(location);
    }
}
