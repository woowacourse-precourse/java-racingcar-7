package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.NameException;
import racingcar.exception.TryNumberException;
import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {
    public List<Car> inputCarList () {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return Arrays.stream(carNames.split(","))
                .map(this::createCarWithNameCheck)  // 예외 체크용 메서드로 이름 검증
                .collect(Collectors.toList());
    }

    private Car createCarWithNameCheck(String name) {
        NameException nameException=new NameException();
        nameException.nameException(name);
        return new Car(name);
    }

    public int inputTryNumber(){
        System.out.println("시도할 횟수는 몇회인가요?");
        int tryNumber= Integer.parseInt(Console.readLine());
        TryNumberException tryNumberException=new TryNumberException();
        tryNumberException.tryNumberException(tryNumber);
        return tryNumber;
    }

}
