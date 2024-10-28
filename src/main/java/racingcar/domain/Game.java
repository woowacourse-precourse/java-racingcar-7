package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Participant> participants;
    private final ProgressedAmountRepository progressedAmountRepository;
    private final MoveConditionGenerator moveConditionGenerator;

    public Game(
            final List<Participant> participants,
            final ProgressedAmountRepository progressedAmountRepository,
            final MoveConditionGenerator randomGenerator
    ) {
        this.participants = participants;
        this.progressedAmountRepository = progressedAmountRepository;
        this.moveConditionGenerator = randomGenerator;
    }

    public void run(Round round) {
        while (true) {
            if (round.nextRound().isEmpty()) {
                break;
            }
            round = round.nextRound().get();
            runOneRound(round);
        }
    }

    private void runOneRound(final Round round) {
        for (final Participant participant : participants) {
            final MoveCondition moveCondition = moveConditionGenerator.getCondition();
            participant.move(moveCondition);
            progressedAmountRepository.save(round, participant.getInfo());
        }
    }

    public Winners getWinners() {
        final List<Participant> winners = new ArrayList<>();
        int max = -1;
        for (final Participant participant : participants) {
            if (participant.getScore() > max) {
                max = participant.getScore();
                winners.clear();
                winners.add(participant);
            } else if (participant.getScore() == max) {
                winners.add(participant);
            }
        }
        return new Winners(mapToCars(winners));
    }

    private List<ProgressedInformation> mapToCars(final List<Participant> participants) {
        return participants.stream()
                .map(participant -> participant.getInfo())
                .collect(Collectors.toList());
    }
}
