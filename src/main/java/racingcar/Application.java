package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static HashMap<String, Car> carStates = new HashMap<>();
    public static String[] carNamesList;
    public static ArrayList<String> winners = new ArrayList<>();

    public static void main(String[] args) {
        // 자동차 입력 받고 쉼표 기준으로 나누기
        carNamesList = Car.input();

        // 공백 제거 및 예외 처리
        for (String carName : carNamesList) {
            carName = carName.trim();
            Exception.carNames(carName);
            carStates.put(carName, new Car(carName));   // Car 객체 추가
        }

        // 시도할 횟수 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumStr = Console.readLine();
        int tryNum = Exception.tryNumber(tryNumStr);    // 예외 처리 및 int로 형변환

        // tryNum만큼 진행
        for (int i = 0; i < tryNum; i++) {
            for (String carName : carNamesList) {
                carName = carName.trim();
                Car car = carStates.get(carName);
                car.race();
                car.statePrint();
            }
            System.out.println();
        }

        Winner.who();
        Winner.print();
    }
}
