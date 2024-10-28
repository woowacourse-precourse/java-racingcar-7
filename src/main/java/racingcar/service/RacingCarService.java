package racingcar.service;


import camp.nextstep.edu.missionutils.Randoms;
import racingcar.exception.UserErrorMessage;
import racingcar.model.RacingCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarService {

    // 시도 횟수 입력값 알맞은지 확인
    public boolean validateCount(String inputCount) {
        if (inputCount == null || inputCount.isEmpty()) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_BLANK);
        }

        try{
            int count = Integer.parseInt(inputCount);
            if(count <= 0) {
                throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_ZERO_NEGATIVE_NUMBER);
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(UserErrorMessage.NOT_ALLOWED_CHARACTER);
        }
    }

    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    public boolean checkCondition(int randomNumber) {
        return randomNumber >= 4;
    }

    public List<RacingCar> setRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(InputView.userInputCarNames(), ",");
        while(st.hasMoreTokens()) {
            String carName = st.nextToken();
            RacingCar racingCar = new RacingCar(RacingCar.validateCarName(carName));
            racingCars.add(racingCar);
        }
        return racingCars;
    }

    public void moveRacingCar() {
        List<RacingCar> racingCars;
        racingCars = setRacingCars();

        int count = 0; // 시도 횟수 정수형
        String sCount = InputView.userInputCount(); // 시도 횟수 문자열
        if(validateCount(sCount)){
            count = Integer.parseInt(sCount);
        }

        System.out.println("실행결과");
        for(int i=0; i<count; i++) {
            for (RacingCar racingCar : racingCars) {
                if (checkCondition(createRandomNumber())) {
                    racingCar.plusResultToMove();
                }
            }
            System.out.println(OutputView.userResultOutput(racingCars));
        }
    }

}
