package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        int carNum = carNames.length;
        Car[] cars = new Car[carNum];

        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(Console.readLine());
        for (int i = 0; i < carNum; i++) {
            cars[i] = new Car(carNames[i]);
        }

        whoWin(cars, num, carNum); //실행 결과
        finalWin(whoMaxWin(cars,carNum)); //최종 우승자 결과
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
