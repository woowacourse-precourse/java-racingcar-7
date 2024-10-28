package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.Vector;

/**
 * RacingCar 클래스, <br>
 * 유저에게 자동차 이름과 경주를 시도할 횟수를 입력 받음 <br>
 * 입력된 횟수만큼 0~9 사이의 랜덤 정수 값을 발생시켜 4 이상일 경우 전진하는 것으로 저장 <br>
 * 각 참가자들이 전진한 횟수를 비교하여 가장 큰 값을 가진 우승자를 찾음 <br>
 * 우승자 출력
 */
public class RacingCar {
    // 각 참가자들의 자동차 이름과 전진 횟수를 저장
    private Vector<User> userList;

    RacingCar() {
        userList = new Vector<>();
    }

    /**
     * 유저에게 자동차 이름과 시도할 횟수를 입력 받음 <br>
     * 경주 시작부터 결과 출력까지 각 과정을 담당하는 메소드를 차례대로 호출
     *
     * @throws IllegalArgumentException 횟수로 입력된 값이 숫자가 아님
     * @see #setUserList(String[])
     * @see #checkRoundError(int)
     * @see #startRace(int)
     * @see #getWinner()
     * @see #showWinnerList(Vector)
     */
    public void run() {
        // 유저가 입력한 경주를 시도할 횟수
        int round;
        // 우승자 정보를 저장
        Vector<User> winnerList = new Vector<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 유저에게 경주할 자동차 이름 목록인 문자열을 입력 받아 저장
        String inputName = Console.readLine();
        // 입력 받은 문자열에서 공백 제거
        inputName = inputName.replaceAll(" ", "");
        // ','를 기준으로 각 이름을 구분하여 저장
        String usernameArray[] = inputName.split(",");
        // 입력된 값이 유효한지 체크
        setUserList(usernameArray);

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            // 유저에게 경주를 시도할 횟수를 입력 받아 저장
            String inputRound = Console.readLine();
            // 입력 받은 문자열에서 공백 제거
            inputRound = inputRound.replaceAll(" ", "");
            // 문자열을 Integer 객체로 변환
            round = Integer.valueOf(inputRound);
            // 입력된 값이 유효한 값인지 체크
            checkRoundError(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        startRace(round);
        winnerList = getWinner();
        showWinnerList(winnerList);
    }

    /**
     * 입력된 값이 유효한지 체크 <br>
     * 입력된 이름으로 각각 참가자의 정보를 저장하는 User 객체를 할당하여 벡터에 추가
     *
     * @param usernameArray 유저가 입력한 자동차 이름 목록
     * @throws IllegalArgumentException 이름이 입력 되지 않았음
     * @see #run()
     * @see #checkUsernameError(String)
     */
    private void setUserList(String usernameArray[]) {
        if (usernameArray.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < usernameArray.length; i++) {
            // 유저가 입력한 자동차 이름이 유효한 값인지 체크
            checkUsernameError(usernameArray[i]);

            // 각 참가자에게 User 객체를 할당하여 각 참가자들의 정보를 저장하는 벡터에 저장
            userList.add(new User(usernameArray[i]));
        }
    }

    /**
     * 유저가 입력한 자동차 이름이 유효한 값인지 체크
     *
     * @param username 자동차 이름
     * @throws IllegalArgumentException 입력된 이름이 빈 칸임
     * @throws IllegalArgumentException 입력된 이름이 6자 이상임
     * @see #setUserList(String[])
     */
    private void checkUsernameError(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException();
        } else if (username.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 유저가 입력한 경주를 시도할 횟수가 유효한 값인지 체크
     *
     * @param round 경주를 시도할 횟수
     * @throws IllegalArgumentException 입력된 횟수가 음수임
     * @see #run()
     */
    private void checkRoundError(int round) {
        if (round < 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 입력 받은 값 만큼 경주를 실행
     *
     * @param round 경주를 시도할 횟수
     * @see #run()
     * @see #runRaceForRound(int)
     */
    private void startRace(int round) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < round; i++) {
            runRaceForRound(i);
            System.out.println();
        }
    }

    /**
     * 각 참가자의 라운드 결과를 저장, 출력
     *
     * @param roundIndex 현재 진행하고 있는 라운드
     * @see #startRace(int)
     * @see #goOrStay(User)
     */
    private void runRaceForRound(int roundIndex) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            goOrStay(user);
            System.out.println(user);
        }
    }

    /**
     * 0~9 사이의 랜덤 값을 발생시켜 4 이상이면 참가자가 전진한 횟수를 1 만큼 추가
     *
     * @param user 현재 경주를 진행하고 있는 참가자의 정보를 갖고 있는 User 객체
     * @see #runRaceForRound(int)
     */
    private void goOrStay(User user) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            user.totalGo++;
        }
    }

    /**
     * 우승자를 찾아 목록에 저장, 반환
     *
     * @return 우승자 목록
     * @see #run()
     * @see #updateWinnerList(User, int, Vector)
     */
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

    /**
     * 인자로 받은 참가자가 전진한 횟수를 최댓값으로 갖고 있는지 비교 <br>
     * 현재의 최댓값과 참가자의 전진 횟수가 같은 경우, 우승자 목록에 추가 <br>
     * 참가자의 전진 횟수가 더 클 경우 최댓값과 우승자 목록을 갱신
     *
     * @param user 참가자
     * @param max 현재의 전진한 횟수 최댓값
     * @param winnerList 현재의 우승자 목록
     * @return 전진한 횟수 최댓값
     * @see #getWinner()
     */
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

    /**
     * 우승자를 출력
     *
     * @param winnerList 우승자 목록
     * @see #run()
     */
    private void showWinnerList(Vector<User> winnerList) {
        System.out.print("최종 우승자 : ");

        Iterator<User> iterator = winnerList.iterator();
        System.out.print(iterator.next().name);
        // 우승자가 2명 이상일 경우 ','와 함께 출력
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.print(", " + user.name);
        }
    }
}
