package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    public static void main(String[] args) {

        /*
         * 1. 자동차 이름이 중복되어서는 안된다
         * 2. 자동차 이름에 null, 공백, ""의 값은 들어올 수 없다
         * 3. pobi, leo, json 과 같이 구분자 사이에 공백이 있는건? trim()으로 없애자
         */
        System.out.println("경주할 자동차 이름을 입력하세요");
        String inputCarNames = Console.readLine();
        validateInputCarNames(inputCarNames);


        System.out.println("시도할 횟수는 몇 회인가요?");
        /*
         * 문자열이 들어올 경우 NumberFormatException 발생
         * 1. try catch 사용
         * 2. 아예 문자열로 입력을 받고 파싱하기
         */
        String inputRoofCount = Console.readLine();
        int roofCount = validateInputRoofCount(inputRoofCount);

        List<String> carNames = Arrays.asList(inputCarNames.split(","));
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < roofCount; i++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.moveForward();
                }
            }

            printCurrentResult(cars);
            System.out.println();
        }

        List<Car> winners = getWinners(cars);
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(",");
            }
        }

    }

    private static void validateInputCarNames(String input) {

    }

    private static int validateInputRoofCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자외의 값이 포함되어있습니다");
        }

        //음수여부도 isNumeric에서 처리되는 중
        //TODO readLine()상태에서 Enter를 입력할 경우 NumberFormatException
        if (isExistNegativeNumber(input)) {
            throw new IllegalArgumentException("양의 정수만 입력할 수 있습니다");
        }

        return Integer.parseInt(input);
    }

    /*
     * 1. 스트림을 사용할경우: 가독성은 좋지만 많은 연산이 필요할 경우 성능이 저하될 수 있음(언박싱,,오토박싱 등)
     * 2. 반복문을 사용할경우: 가독성은 좋지 않지만 많은 연산을 수행해도 성능측면에서 스트림보다 나음
     */
    //문자열이 숫자로만 이루어져있는가?
    private static boolean isNumeric(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    //문자열에 음수가 포함되어있지 않은가?
    private static boolean isExistNegativeNumber(String input) {
        final String NEGATIVE_SYMBOL = "-";
        return input.contains(NEGATIVE_SYMBOL);
    }

    private static List<Car> getWinners(List<Car> cars) {
        int highestPoint = 0;

        //stream max 사용 가능?
        for (Car car : cars) {
            int winningPoint = car.getWinningPoint();
            if (winningPoint > highestPoint) {
                highestPoint = winningPoint;
            }
        }

        //stream filter가 나을지도? 성능고려?
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.winningPoint == highestPoint) {
                winners.add(car);
            }
        }
        return winners;
    }

    //StringBuilder 사용하면 더 나을지도
    private static void printCurrentResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + parse(car.winningPoint));
        }
    }

    //StringBuilder 사용 하면 더 나을지도
    private static String parse(int point) {
        String result = "";
        for (int i = 0; i < point; i++) {
            result += "-";
        }
        return result;
    }

    public static class Car {
        private String name;
        private int winningPoint;

        public Car(String name) {
            this.name = name;
            this.winningPoint = 0;
        }

        public void moveForward() {
            winningPoint++;
        }

        public String getName() {
            return name;
        }

        public int getWinningPoint() {
            return winningPoint;
        }
    }
}

