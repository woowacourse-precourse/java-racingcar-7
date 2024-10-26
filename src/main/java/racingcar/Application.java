package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static List splitCarInput(String carName) {
        List<String> members = Arrays.asList(carName.split(","));
        return members;
    }

    static void chkCarName(List members) {
        for (int i = 0; i < members.size(); i++) {
            String carName = members.get(i).toString();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자 초과입니다.");
            } else if (carName.length() == 0) {
                throw new IllegalArgumentException("이름이 0글자 입니다.");
            }
        }
    }

    static void carForward(List members, int playNum) {
        List<Integer> carForawardList = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            carForawardList.add(0);
        }
        for (int i = 0; i < playNum; i++) {
            carForawardList = forwardCount(carForawardList);
        }
        for (int i = 0; i < members.size(); i++) {
            System.out.println(carForawardList.get(i));
        }
    }

    static int getRandomInt() {
        return Randoms.pickNumberInRange(0, 9);
    }

    static List forwardCount(List carForwardList) {
        for (int i = 0; i < carForwardList.size(); i++) {
            int forwardNum = getRandomInt();
            if (forwardNum >= 4) {
                int cnt = Integer.parseInt(carForwardList.get(i).toString());
                carForwardList.set(i, cnt + 1);
            }
        }
        return carForwardList;
    }

    public static void main(String[] args) {
        List<String> members = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        members = splitCarInput(carNameInput);
        chkCarName(members);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int playNum = Integer.parseInt(Console.readLine());
        carForward(members, playNum);
    }
}
