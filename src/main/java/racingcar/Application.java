package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    private static void gameStart() {
        String[] carListName = initGame();

        int inputTry = initInputTry();

        ArrayList<Car> cars = initCarList(carListName);

        startRace(inputTry, cars);

        System.out.println("최종 우승자 : " + findWinners(cars));
    }

    private static void startRace(int inputTry, ArrayList<Car> cars) {
        System.out.println("실행 결과");
        carsMove(inputTry, cars);
    }

    private static int initInputTry() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNum = getTryNum();
        return tryNum;
    }

    private static int getTryNum() {
        int tryNum;
        try{
            tryNum = notZero(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("정상적인 숫자가 입력되지 않았습니다.");
        }
        return tryNum;
    }

    private static String[] initGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        String[] carListName = inputCarName.split(",");
        return carListName;
    }

    private static int notZero(int tryNum){
        if(tryNum == 0){
            throw new IllegalArgumentException("0 입력은 옳지 않습니다.");
        }
        return tryNum;
    }



    private static void carsMove(int inputTry, ArrayList<Car> cars) {
        for (int i = 0; i < inputTry; i++) {
            for (Car car : cars) {
                car.goStraight(0, 9, 4);
                car.print();
            }

            System.out.println();
        }
    }

    public static ArrayList<Car> initCarList(String[] carListName) {
        ArrayList<Car> carList = new ArrayList<>();

        for (String carName : carListName) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public static String findWinners(ArrayList<Car> cars) {
        StringBuilder sb = new StringBuilder();
        int maxDistance = 0;

        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        for (Car car : cars) {
            winnerList(car, maxDistance, sb);
        }
        return sb.toString();
    }

    private static void winnerList(Car car, int maxDistance, StringBuilder sb) {
        if (car.getDistance() == maxDistance) {
            BuilderIsEmpty(sb);
            sb.append(car.getCarName());
        }
    }

    private static void BuilderIsEmpty(StringBuilder sb) {
        if (!sb.isEmpty()) {
            sb.append(",");
        }
    }
}
