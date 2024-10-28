package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.InputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingService {

    public boolean checkWhetherToAdvance() {
        int pickedRandomValue = Randoms.pickNumberInRange(0, 9);

        return pickedRandomValue >= 4;
    }

    public void updateRaceRecord(List<String> CarNames, Map<String, List<String>> RaceRecord) {

        for (String individualCarName : CarNames) {
            List<String> recordHistory = RaceRecord.get(individualCarName);
            String recentRecord = RaceRecord.get(individualCarName).getLast();

            if (checkWhetherToAdvance()) {
                recentRecord += "-";
            }

            recordHistory.add(recentRecord);
            RaceRecord.put(individualCarName, recordHistory);

            printUpdatedRecord(recentRecord);
        }

    }

    public void playRace(String carName, String attemptValue) {
        List<String> carNames = InputUtils.parseCarNames(carName);
        int valueOfAttempt = InputUtils.parseAttemptValue(attemptValue);

        Map<String, List<String>> raceRecord = new HashMap<>();

        for (String individualCarName : carNames) {
            List<String> recordHistory = new ArrayList<>();

            String initialRecord = individualCarName + " : ";
            recordHistory.add(initialRecord);

            raceRecord.put(individualCarName, recordHistory);
        }

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 1; i <= valueOfAttempt; i++) {
            updateRaceRecord(carNames, raceRecord);
            System.out.println();
        }

        List<String> winners = checkWinner(carNames, raceRecord);

        printWinner(winners);
    }

    public Map<String, Integer> getFinalRecord(List<String> CarNames, Map<String, List<String>> RaceRecord) {
        Map<String, Integer> finalRecord = new HashMap<>();

        for (String individualCarName : CarNames) {
            String recentRecord = RaceRecord.get(individualCarName).getLast();
            String finalAdvancedRecord = "";

            int beginOfAdvancedRecord = recentRecord.lastIndexOf(" ");

            finalAdvancedRecord = recentRecord.substring(beginOfAdvancedRecord + 1);
            int finalPosition = finalAdvancedRecord.length();

            finalRecord.put(individualCarName, finalPosition);
        }

        return finalRecord;
    }

    public List<String> checkWinner(List<String> CarNames, Map<String, List<String>> RaceRecord) {
        Map<String, Integer> finalRecord = getFinalRecord(CarNames, RaceRecord);
        List<String> winners = new ArrayList<>();

        int maxValue = -1;

        for (Integer valueOfFinalRecord : finalRecord.values()) {
            if (valueOfFinalRecord > maxValue) {
                maxValue = valueOfFinalRecord;
            }
        }

        for (Map.Entry<String, Integer> finalRecordByCarName : finalRecord.entrySet()) {
            if (finalRecordByCarName.getValue() == maxValue) {
                winners.add(finalRecordByCarName.getKey());
            }
        }

        return winners;
    }

    public void printUpdatedRecord(String updatedRecord) {
        System.out.println(updatedRecord);
    }

    public void printWinner(List<String> winner) {
        String result = String.join(",", winner);

        System.out.println("최종 우승자 : " + result);
    }
    
}
