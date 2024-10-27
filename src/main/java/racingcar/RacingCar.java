package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.Vector;

public class RacingCar {
    private Vector<User> userList;

    RacingCar() {
        userList = new Vector<>();
    }

    public void run() {
        int round;
        Vector<User> winnerList = new Vector<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        inputName = inputName.replaceAll(" ","");
        String usernameArray[] = inputName.split(",");
        setUserList(usernameArray);

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            String inputRound = Console.readLine();
            inputRound = inputRound.replaceAll(" ","");
            round = Integer.valueOf(inputRound);
            checkRoundError(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        startRace(round);
        winnerList = getWinner();
        showWinnerList(winnerList);
    }

    private void setUserList(String usernameArray[]) {
        if (usernameArray.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < usernameArray.length; i++) {
            checkUsernameError(usernameArray[i]);
            userList.add(new User(usernameArray[i]));
        }
    }

    private void checkUsernameError(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (username.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRoundError(int round) {
        if (round < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void startRace(int round) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            runRaceForRound(i);
            System.out.println();
        }
    }

    private void runRaceForRound(int roundIndex) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            goOrStay(user);
            System.out.println(user);
        }
    }

    private void goOrStay(User user) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            user.totalGo++;
        }
    }

    private Vector<User> getWinner() {
        Vector<User> winnerList = new Vector<>();
        int max = 0;

        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            max = updateWinnerList(user, max, winnerList);
        }
        return winnerList;
    }

    private int updateWinnerList(User user, int max, Vector<User> winnerList) {
        if (max == user.totalGo) {
            winnerList.add(user);
        } else if (max < user.totalGo) {
            max = user.totalGo;
            winnerList.clear();
            winnerList.add(user);
        }
        return max;
    }

    private void showWinnerList(Vector<User> winnerList) {
        System.out.print("최종 우승자 : ");

        Iterator<User> iterator = winnerList.iterator();
        System.out.print(iterator.next().name);
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.print(", " + user.name);
        }
    }
}
