package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.Message;
import racingcar.view.RacingCarView;

import java.util.*;

public class RacingCar {

    public void racing(String carsInput, String attemptInput){

        List <String> inputCarTokens = parseCarName(carsInput);
        int attemptInt = parseAttemptToInt(attemptInput);
        Map<String, Integer> carForwardCount = new HashMap<>();

        for(String name : inputCarTokens){
            carForwardCount.put(name, 0);
        }

        System.out.println("실행 결과");
        for(int i = 0; i<attemptInt; i++){
            forward(carForwardCount);
            RacingCarView.printRacingResults(inputCarTokens, carForwardCount);
        }

        RacingCarView.printWinners(carForwardCount);
    }


    private List<String> parseCarName(String carsInput){

        String delimiter = ",";
        String [] inputCarTokens = carsInput.split(delimiter);
        Set<String> uniqueNames = new HashSet<>();

        for (String token : inputCarTokens) {
            if (token.length() > 5) throw new IllegalArgumentException("차 이름은 5글자 이하여야 합니다.");
            else if (!uniqueNames.add(token)) throw new IllegalArgumentException("이미 입력된 차 이름 입니다.");
        }

        return Arrays.asList(inputCarTokens);
    }

    private int parseAttemptToInt(String attemptInput){

        try {
            int attemptInt = Integer.parseInt(attemptInput);
            return attemptInt;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ILLEGAL_ARGUMENT_ERROR.toString());
        }
    }

    private int createRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isGreaterThanThree(int number){
        return number >= 4;
    }

    private void forward(Map<String, Integer> carForwardCount){

        for(String carName : carForwardCount.keySet()){
            int number = createRandomNumber();
            if(isGreaterThanThree(number)){
                carForwardCount.put(carName, carForwardCount.get(carName) + 1);
            }
        }
    }

}
