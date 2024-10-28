package Service;

import Entity.Car;
import Entity.Moveable;
import Entity.Result;
import Entity.Transfortation;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GameManagement {
    private ArrayList<Transfortation> targets;
    private Result result;
    public GameManagement() {
        targets = new ArrayList<Transfortation>();
        result = new Result();
    }

    public Result start(ArrayList<String> carNames, int n) {
        makeTargets(carNames);

        for (int i = 0; i < n; i++) {
            forward();
            save();
        }

        analysis();

        return this.result;
    }

    public void makeTargets(ArrayList<String> carNames) {
        for (String name: carNames) {
            Transfortation temp = new Car(name);
            targets.add(temp);
        }
    }

    public void forward() {
        for (Transfortation target: targets) {
            Moveable t = (Moveable) target;
            int number = Randoms.pickNumberInRange(0, 9);
            t.move(number);
        }
    }

    public void save() {
        for (Transfortation target: targets) {
            result.addResult(target.getName()+ " : " + target.getPath() + "\n");
        }
        result.addResult("\n");
    }

    public void analysis() {
        targets.sort(Comparator.comparing(Transfortation::getMoveCount).reversed());

        result.addResult("최종 우승자 : ");
        ArrayList<String> winners = new ArrayList<>();

        int maxMovement = targets.get(0).getMoveCount();
        winners.add(targets.get(0).getName());

        for (int i = 1; i < targets.size(); i++) {
            if (maxMovement == targets.get(i).getMoveCount())
                winners.add(targets.get(i).getName());
            else
                break;
        }

        result.addResult(String.join(", ", winners));
    }
}
