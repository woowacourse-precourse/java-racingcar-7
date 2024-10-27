package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {
        try {
            startGame();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    private static void startGame() {
        // 경주할 자동차 이름 입력(참가자 수)
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        // 사용자 입력에서 공백을 제거하고 쉼표로 구분해서 가변 컬렉션인 ArrayList에 저장
        List<String> inputList = new ArrayList<>(Arrays.asList(Console.readLine().split("\\s*,\\s*")));
        validateInput(inputList);
        checkRedundancy(inputList);
        checkCarNameLength(inputList);

        List<Participant> participantList = new ArrayList<>();
        createParticipantList(inputList, participantList);
        checkParticipantSize(participantList);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttemptCount = Console.readLine();
        checkAttemptCount(inputAttemptCount);
        int attemptCount = Integer.parseInt(inputAttemptCount);

        System.out.println("\n실행 결과");
        printExecutionResults(attemptCount, participantList);
    }

    // 게임 결과를 출력하는 메서드
    private static void printExecutionResults(int attemptCount, List<Participant> participantList) {
        for (int i = 0; i < attemptCount; i++) {
            moveForwardWithRandomValues(participantList);
            printInterimResults(participantList);
            System.out.println();
        }

        List<String> winnerList = getWinner(participantList);

        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    // 중간 결과를 출력하는 메서드
    private static void printInterimResults(List<Participant> participantList) {
        for (Participant participant : participantList) {
            System.out.println(participant);
        }
    }

    private static void moveForwardWithRandomValues(List<Participant> participantList) {
        for (Participant participant : participantList) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                participant.plusMoveCount();
            }
        }
    }

    // 우승자를 판별해서 List에 저장하는 메서드
    private static List<String> getWinner(List<Participant> participantList) {
        List<Integer> moveCountList = new ArrayList<>();

        for (int i = 0; i < participantList.size(); i++) {
            moveCountList.add(participantList.get(i).getMoveCount());
        }

        List<String> winnerList = new ArrayList<>();

        for (int i = 0; i < participantList.size(); i++) {
            if (Collections.max(moveCountList) == participantList.get(i).getMoveCount()) {
                winnerList.add(participantList.get(i).getCarName());
            }
        }
        return winnerList;
    }

    // 시도할 횟수가 숫자 형식, 양수인지 확인하는 메서드
    private static void checkAttemptCount(String input2) {
        if (!input2.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    // 자동차(참가자) 수가 2대 미만인지 확인하는 메서드
    private static void checkParticipantSize(List<Participant> participantList) {
        if (participantList.size() < 2) {
            throw new IllegalArgumentException("자동차 경주는 2대 이상부터 가능합니다.");
        }
    }

    // 사용자 입력을 사용해 참가자 객체를 생성하고 참가자 리스트에 객체를 저장하는 메서드
    private static void createParticipantList(List<String> inputList, List<Participant> participantList) {
        for (String carName : inputList) {
            Participant participant = new Participant(carName);
            participantList.add(participant);
        }
    }

    // 자동차 이름이 6자 이상인지 확인하는 메서드
    private static void checkCarNameLength(List<String> inputList) {
        ListIterator<String> iterator = inputList.listIterator();

        while (iterator.hasNext()) {
            String str = iterator.next();

            if (str.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void checkRedundancy(List<String> inputList) {
        if (inputList.size() != inputList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    // 사용자 입력에서 빈 문자열을 제거 하고 특수 문자가 있는지 확인하는 메서드
    private static void validateInput(List inputList) {
        ListIterator<String> iterator = inputList.listIterator();

        while (iterator.hasNext()) {
            String str = iterator.next();

            // 공백을 제거한 후 빈 문자열이 되면 List에서 제거하고 다음 인덱스로 넘어감
            if (str.trim().isEmpty()) {
                iterator.remove();
                continue;
            }

            // List에 저장된 문자열에 특수 문자가 있는지 정규 표현식을 사용해 검증
            if (str.matches(".*[`~!@#$%^&*()\\-_=+{}\\[\\];:'\",.<>/?|\\\\].*")) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }
}
