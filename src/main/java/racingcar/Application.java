package racingcar;

import camp.nextstep.edu.missionutils.Console;
import determiner.WinnerDeterminer;
import process.MovePolicy;
import race.Race;
import separator.Separator;
import view.RaceView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String text = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        List<String> carNames = Separator.split(text);
        MovePolicy policy = new MovePolicy();
        Race race = new Race(carNames);
        for (int i = 0; i < count; i++) {

            for (String car : carNames) {
                if (policy.run()) {
                    race.updateProgress(car);
                }
            }

            RaceView.view(race.getAllProgress());
        }

        WinnerDeterminer determiner = new WinnerDeterminer();
        List<String> winners = determiner.run(race.getAllProgress());
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
