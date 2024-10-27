package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class RacingGame {
    private final String SPECIAL_CHARACTER_REGEX = ".*[`~!@#$%^&*()\\-_=+{}\\[\\];:'\",.<>/?|\\\\].*";
    private final int CAR_NAME_MAX_LENGTH = 5;
    private final int MIN_CARS_FOR_RACE = 2;
    private final int FORWARD_THRESHOLD = 4;

    private List<String> inputList;
    private List<Participant> participantList;
    private int attemptCount;

    public void start() {
        // 경주할 자동차 이름 입력(참가자 수)
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

        // 첫 번째 입력
        firstInput();

        System.out.println("시도할 횟수는 몇 회인가요?");

        // 두 번째 입력
        secondInput();

        // 게임 실행과 결과 출력
        printExecutionResults();
    }

    // 게임 결과를 출력하는 메서드
    private void printExecutionResults() {
        System.out.println("\n실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            moveForwardWithRandomValues(participantList);
            printInterimResults();
            System.out.println();
        }

        List<String> winnerList = getWinner();

        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    // 중간 결과를 출력하는 메서드
    private void printInterimResults() {
        for (Participant participant : participantList) {
            System.out.println(participant);
        }
    }

    // 우승자를 판별해서 List에 저장하는 메서드
    private List<String> getWinner() {
        List<Integer> moveCountList = new ArrayList<>();

        for (Participant participant : participantList) {
            moveCountList.add(participant.getMoveCount());
        }

        List<String> winnerList = new ArrayList<>();

        for (Participant participant : participantList) {
            if (participant.getMoveCount() == Collections.max(moveCountList)) {
                winnerList.add(participant.getCarName());
            }
        }
        return winnerList;
    }

    // 무작위 값을 이용해 4이상이 나오면 한 번 전진하는 메서드
    public void moveForwardWithRandomValues(List<Participant> participantList) {
        for (Participant participant : participantList) {
            if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
                participant.plusMoveCount();
            }
        }
    }

    // 시도할 횟수가 숫자 형식, 양수인지 확인하는 메서드
    private void checkAttemptCount(String inputAttemptCount) {
        if (!inputAttemptCount.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    // 자동차(참가자) 수가 2대 미만인지 확인하는 메서드
    private void checkParticipantSize() {
        if (participantList.size() < MIN_CARS_FOR_RACE) {
            throw new IllegalArgumentException("자동차 경주는 2대 이상부터 가능합니다.");
        }
    }

    // 사용자 입력을 사용해 참가자 객체를 생성하고 참가자 리스트에 객체를 저장하는 메서드
    private void createParticipantList() {
        for (String carName : inputList) {
            Participant participant = new Participant(carName);
            participantList.add(participant);
        }
    }

    // 자동차 이름이 6자 이상인지 확인하는 메서드
    private void checkCarNameLength() {
        for (String str : inputList) {
            if (str.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private void checkRedundancy() {
        if (inputList.size() != inputList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    // 사용자 입력에서 빈 문자열을 제거 하고 특수 문자가 있는지 확인하는 메서드
    private void validateInput() {
        ListIterator<String> iterator = inputList.listIterator();

        while (iterator.hasNext()) {
            String str = iterator.next();

            // 공백을 제거한 후 빈 문자열이 되면 List에서 제거하고 다음 인덱스로 넘어감
            if (str.trim().isEmpty()) {
                iterator.remove();
                continue;
            }

            // List에 저장된 문자열에 특수 문자가 있는지 정규 표현식을 사용해 검증
            if (str.matches(SPECIAL_CHARACTER_REGEX)) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    private void secondInput() {
        String inputAttemptCount = Console.readLine();
        checkAttemptCount(inputAttemptCount);
        attemptCount = Integer.parseInt(inputAttemptCount);
    }

    private void firstInput() {
        // 사용자 입력에서 공백을 제거하고 쉼표로 구분해서 가변 컬렉션인 ArrayList에 저장
        inputList = new ArrayList<>(Arrays.asList(Console.readLine().split("\\s*,\\s*")));
        validateInput();
        checkRedundancy();
        checkCarNameLength();

        participantList = new ArrayList<>();
        createParticipantList();
        checkParticipantSize();
    }
}
