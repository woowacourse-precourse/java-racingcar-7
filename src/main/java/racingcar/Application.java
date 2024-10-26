package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        String[] carNames = InputHandler.getCarNames();
        int tryCount = InputHandler.getTryCount();

        int carNum = carNames.length;
        Car[] cars = createCars(carNames);

        whoWin(cars, tryCount, carNum);
        finalWin(whoMaxWin(cars, carNum));
    }

    private static Car[] createCars(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    //실행 결과 출력 메서드
    static void whoWin(Car[] carNames, int num, int carNum) {
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < carNum; j++) {
                System.out.println(carNames[j].name+" : "+carNames[j].isWin());
            }
            System.out.println();
        }
    }

    //최종 우승자 결과 출력 메서드
    static void finalWin(String[] whoMaxWin) {
        String result = String.join(", ", whoMaxWin);
        System.out.println("최종 우승자 : " + result);
    }

    //최종 우승자가 누군지 가리는 메서드
    static String[] whoMaxWin(Car[] carNames,int carNum) {
        for (int i = 0; i < carNum; i++) {
            if (Car.maxWin == carNames[i].win) {
                Car.winNum += 1;
            }
        }
        String[] winList = new String[Car.winNum];
        int index = 0;
        for (int i = 0; i < carNum; i++) {
            if (Car.maxWin == carNames[i].win) {
                winList[index] = carNames[i].name;
                index += 1;
            }
        }
        return winList;
    }
}

class InputHandler {
    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 빈 칸이 포함되어 있거나 잘못된 형식입니다.");
            }
        }
        return carNames;
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= 0) {
            throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
        }
        return tryCount;
    }
}

class Car{ //car 객체 생성
    static int maxWin;
    static int winNum;
    Random random = new Random();
    int randomNumber;

    int win = 0;
    String strWin = "";
    String name;
    Car(String name) {
        this.name = name;
    }

    String isWin(){
        randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            win += 1;
            strWin += "-";
        }
        if (win >= maxWin) {
            maxWin = win;
        }
        return strWin;
    }
}
