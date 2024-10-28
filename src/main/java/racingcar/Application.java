package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String pureInput = getInputCarNames();
        ArrayList<String> carName = new ArrayList<>(List.of(pureInput.split(",")));
        validateCarNames(carName);

        Integer playNum = getPlayNumber();

        checkNumberPositive(playNum);
        ArrayList<Integer> scoreList = new ArrayList<>();

        getScoreArray(carName, scoreList);

        doRace(carName, playNum, scoreList);

        Integer maxMove = getMaxMove(carName, scoreList);
        System.out.print("최종 우승자 : ");
        Boolean hasFirstElement = false;
        for (int i = 0; i < carName.size(); i++) {
            if (scoreList.get(i) == maxMove) {
                if (hasFirstElement) {
                    System.out.print(", ");
                }
                System.out.print(carName.get(i));
                hasFirstElement = true;

            }
        }
    }

    private static void doRace(ArrayList<String> carName, Integer playNum, ArrayList<Integer> scoreList) {
        for (int i = 0; i < playNum; i++) {
            moveAllCarOneTime(carName, scoreList);
            //진행사항 출력
            printCarsMoveStates(carName, scoreList);
        }
    }

    private static void checkNumberPositive(Integer playNum) {
        if (playNum < 0) {
            throw new IllegalArgumentException("횟수로 양수만 가능합니다.");
        }
    }

    private static Integer getMaxMove(List<String> carName, ArrayList<Integer> scoreList) {
        Integer maxMove = scoreList.get(0);
        for (int i = 0; i < carName.size(); i++) {
            if (maxMove < scoreList.get(i)) {
                maxMove = scoreList.get(i);
            }
        }
        return maxMove;
    }

    private static void printCarsMoveStates(List<String> carName, ArrayList<Integer> scoreList) {
        for (int j = 0; j < carName.size(); j++) {
            printCarMoveState(carName, scoreList, j);
        }
        System.out.println("");
    }

    private static void printCarMoveState(List<String> carName, ArrayList<Integer> scoreList, int j) {
        System.out.print(carName.get(j) + " : ");
        for (int k = 0; k < scoreList.get(j); k++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    private static void moveAllCarOneTime(List<String> carName, ArrayList<Integer> scoreList) {
        for (int j = 0; j < carName.size(); j++) {
            int delimiter = getMoveStep();
            scoreList.set(j, scoreList.get(j) + delimiter);
        }
    }

    private static int getMoveStep() {
        int randomNum = (int) (Math.random() * 10);
        if (randomNum < 4) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void getScoreArray(ArrayList<String> carName, ArrayList<Integer> scoreList) {
        for (int i = 0; i < carName.size(); i++) {
            scoreList.add(0);
        }
    }

    private static Integer getPlayNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Integer num;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수로 숫자만 가능합니다.");
        }
        return num;
    }

    private static void validateCarNames(ArrayList<String> carName) {
        for (int i = 0; i < carName.size(); i++) {
            checkLengthUnder6(carName.get(i));
            checkIsBlank(carName.get(i));
            checkNameDuplicate(carName);
        }
    }

    private static void checkNameDuplicate(ArrayList<String> carName) {
        if (isDuplicates(carName)) {
            throw new IllegalArgumentException("차 이름이 중복됩니다.");
        }
    }


    public static boolean isDuplicates(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set.size() < list.size();
    }


    private static void checkLengthUnder6(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("차의 이름은 5자 이하여야합니다.");
        }
    }

    private static void checkIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("차의 이름으로 공백은 불가능합니다");
        }
    }

    private static String getInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNames;
        try {
            carNames = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        return carNames;
    }
}
