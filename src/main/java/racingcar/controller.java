package racingcar;

import static racingcar.model.winner_list;
import static racingcar.model.car_list;
import static racingcar.model.gameCount;
import static racingcar.view.printGame;

public class controller {
    public static void checkCharValid(char inputChar) {
        if (inputChar > '9' || inputChar < '0') {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNumberValid(String input) {
        for (int i = 0; i < input.length(); i++) {
            checkCharValid(input.charAt(i));
        }
    }

    public static void checkNameValid(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static String checkSeperator(String name, char inputChar) {
        if (inputChar != ',') {
            return name += inputChar;
        }
        checkNameValid(name);
        car_list.add(new Car(name, 0));
        return "";
    }

    public static void saveCar(String user_input) {
        user_input += ",";
        String name = "";
        for (int i = 0; i < user_input.length(); i++) {
            name = checkSeperator(name, user_input.charAt(i));
        }
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
            tempCar.increaseCnt();
        }
    }

    public static void gameProgress() {
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            getRandomNum();
            printGame();
        }
        getWinner(getMaxNum());
    }
}
