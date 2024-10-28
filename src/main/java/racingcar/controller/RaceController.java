package racingcar.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceController {
    public void run() {
        String carNames = InputView.getCarNames();
        String[] carNamesList=wrongCheckName(carNames);
        int rounds = InputView.getRounds();
        negativeRoundCheck(rounds);
        Race race = new Race(Arrays.asList(carNamesList), rounds);
        startRace(rounds,race);
        selectWinners(race);
    }

    public void negativeRoundCheck( int round){
        if (round<0){
            throw new IllegalArgumentException("라운드 수가 음수임");
        }
    }
    public void startRace(int round, Race race){
        for (int i = 0; i < round; i++) {
            race.start();
            ResultView.printRoundResult(race.getCars());
        }
    }

    public void selectWinners(Race race){
        List<String> winners = race.getWinners();
        ResultView.printWinners(winners);
    }

    public String[] wrongCheckName(String carname){
        String[] CarNameList=carname.split(",");
        Set <String> names=new HashSet<>();
        for (String name: CarNameList){
            name=name.trim();
            if (!names.add(name)) {
                throw new IllegalArgumentException("이름이 중복됨");
            }
            if (name.length()>5) {
                throw new IllegalArgumentException("이름이 6글자 이상임");
            }
            if (!name.matches("[a-zA-Z]+")){
                throw new IllegalArgumentException("이름 형식 오류");
            }
            names.add(name);
        }
        return names.toArray(new String[0]);

    }
}