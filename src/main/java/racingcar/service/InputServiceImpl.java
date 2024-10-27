package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.dto.RacingCar;

public class InputServiceImpl implements InputService {
    private static InputService inputServiceInstance = new InputServiceImpl();

    private InputServiceImpl() {
    }

    public static InputService getInstance() {
        return inputServiceInstance;
    }

    @Override
    public String[] inputRacingUsersAndSplit() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputArr = Console.readLine().split(",");

        if (Arrays.stream(inputArr).allMatch(x -> x.length() <= 5)) {
            return inputArr;
        } else {
            throw new IllegalArgumentException("플레이어 이름이 5자 이하여야 합니다.");
        }
    }

    @Override
    public int inputMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            return checkCollectSequence(Integer.parseInt(Console.readLine()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요!");
        }
    }


    @Override
    public List<RacingCar> splitUsersAndReturnList(String[] inputStrData) {
        return Arrays.stream(inputStrData)
                .map(this::strToRacingCar)
                .toList();
    }

    private RacingCar strToRacingCar(String str) {
        return new RacingCar(str, 0);
    }

    private int checkCollectSequence(int sequence) {
        if (sequence >= 1) {
            return sequence;
        }

        throw new IllegalArgumentException("1이상 값을 입력해주세요!");
    }
}
