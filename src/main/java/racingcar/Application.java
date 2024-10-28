package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static HashMap<String, Integer> carScores = new HashMap<String, Integer>();
    static String[] cars;
    static int repeat = 0;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        getCarNames(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String repeatStr = Console.readLine();
        getRepeatNum(repeatStr);

        System.out.println("\n실행 결과");
        while (repeat-- > 0) {
            moveCars(cars);
            showCurrentStatus(cars);
        }

        System.out.println("최종 우승자 : " + getWinner());
    }

    public static void getCarNames(String names) {
        if (!names.matches("^[a-zA-Z가-힣]+(,[a-zA-Z가-힣]+)*$")) {
            throw new IllegalArgumentException("잘못된 입력 값입니다: , 외의 구분자를 사용했습니다. 이름은 한글, 영문만으로 이루어져야 합니다.");
        }
        cars = names.split(",");

        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5) {
                throw new IllegalArgumentException("잘못된 입력 값입니다: 이름은 5자 이하여야 합니다.");
            }
        }

        for (String car : cars) {
            carScores.put(car, 0);
        }
    }

    public static void getRepeatNum(String repeatStr) {
        try {
            repeat = Integer.parseInt(repeatStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다: 이동 횟수에 문자가 입력되었습니다.");
        }
        if (repeat < 0) {
            throw new IllegalArgumentException("잘못된 입력 값입니다: 이동 횟수가 음수입니다.");
        }
    }

    public static void moveCars(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            checkScoreAndMove(randomNum, cars, i);
        }
    }

    public static void checkScoreAndMove(int randomNum, String[] cars, int i) {
        if (randomNum >= 4) {
            int curScore = carScores.get(cars[i]);
            carScores.put(cars[i], curScore + 1);
        }
    }

    public static void showCurrentStatus(String[] cars) {
        for (String carName : cars) {
            int score = carScores.get(carName);
            String scoreStr = makeScoreString(score);
            System.out.println(carName + " : " + scoreStr);
        }
        System.out.println();
    }

    public static String makeScoreString(int score) {
        String result = "";
        while (score-- > 0) {
            result += "-";
        }
        return result;
    }

    public static String getWinner() {
        String result = "";
        int maxScore = 0;

        List<Map.Entry<String, Integer>> entryList = descendingSortByValue();
        List<String> winners = saveWinnerList(entryList, maxScore);
        winners.sort(Comparator.comparingInt(car -> Arrays.asList(cars).indexOf(car)));
        result = String.join(", ", winners);

        return result;
    }

    public static List<Map.Entry<String, Integer>> descendingSortByValue() {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(carScores.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return entryList;
    }

    public static List<String> saveWinnerList(List<Map.Entry<String, Integer>> entryList, int maxScore) {
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            int curScore = entry.getValue();
            if (maxScore <= curScore) {
                maxScore = curScore;
                winners.add(entry.getKey());
            } else {
                break;
            }
        }
        return winners;
    }
}
