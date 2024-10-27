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

        return Console.readLine().split(",");
    }

    @Override
    public int inputMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return Integer.parseInt(Console.readLine());
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
}
