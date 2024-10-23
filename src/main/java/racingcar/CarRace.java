package racingcar;

public class CarRace {
    public static String start(String cars, int moveAttempts){
        String[] carNames = cars.split(",");

        // 입력값에 포함될 수 있는 공백 제거
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }

        return "";
    }

    public static void printFinalWinner(){

    }
}
