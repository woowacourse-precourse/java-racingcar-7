package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

class Car {
    String name;
    int move_cnt;

    Car(String name, int move_cnt) {
        this.name = name;
        this.move_cnt = move_cnt;
    }
}

public class Application {
    // static Car[] car_list;
    static int totalCount;
    // static Car[] winner_list;

    static List<Car> car_list = new ArrayList<>();
    static List<Car> winner_list = new ArrayList<>();

    public static void printWinner() {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner_list.size() - 1; i++) {
            Car tempCar = winner_list.get(i);
            System.out.print(tempCar.name);
            System.out.print(",");
        }
        Car tempCar = winner_list.get(winner_list.size() - 1);
        System.out.println(tempCar.name);
    }

    public static void getWinner(int score) {
        for (int i = 0; i < car_list.size(); i++) {
            Car tempCar = car_list.get(i);
            if (tempCar.move_cnt == score) {
                winner_list.add(tempCar);
            }
        }
    }

    public static int getMaxNum() {
        int maxi = 0;
        for (int i = 0; i < car_list.size(); i++) {
            Car tempCar = car_list.get(i);
            maxi = Math.max(maxi, tempCar.move_cnt);
        }
        return maxi;
    }

    public static void getRandomNum() {
        for (int i = 0; i < car_list.size(); i++) {
            Car tempCar = car_list.get(i);
            int random_num = pickNumberInRange(0, 9);
            if (random_num >= 4) {
                tempCar.move_cnt++;
            }
        }
    }

    public static void printGame() {
        String moveStr = "-";
        for (int i = 0; i < car_list.size(); i++) {
            Car tempCar = car_list.get(i);
            System.out.print(tempCar.name + " : ");
            System.out.println(moveStr.repeat(tempCar.move_cnt));
        }
        System.out.println();
    }

    public static void gameProgress() {
        System.out.println("실행 결과");
        for (int i = 0; i < totalCount; i++) {
            getRandomNum();
            printGame();
        }
        getWinner(getMaxNum());
    }

    public static void checkValid(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void saveCar(String user_input) {
        user_input += ",";

        String name = "";
        for (int i = 0; i < user_input.length(); i++) {
            if (user_input.charAt(i) != ',') {
                name += user_input.charAt(i);
            } else {
                checkValid(name);
                car_list.add(new Car(name, 0));
                name = "";
            }
        }
    }

    public static void inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String user_input = readLine();
        saveCar(user_input);
    }

    public static void checkInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) > '9' || input.charAt(i) < '0') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        checkInput(input);
        totalCount = Integer.parseInt(input);
    }

    public static void main(String[] args) {
        inputCar();
        inputCount();
        gameProgress();
        printWinner();
    }
}
