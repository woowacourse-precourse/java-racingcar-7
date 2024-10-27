package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.RacingGameInitializationRequest;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RacingCarGameModel {
    private final ArrayList<ParticipantEntity> participantEntities = new ArrayList<>();
    private int time = 0;

    public void initializationGame(RacingGameInitializationRequest request) {
        String[] participants = request.participants().split(",");

        participantNumberCount(participants);

        for (String participant : participants) {
            participantEntities.add(new ParticipantEntity(nameValidation(participant)));
        }

        time = timeValidation(request.time());
    }

    public String startGame() {
        return java.util.stream.IntStream.range(0, time)
                .mapToObj(turn -> forwardCar())
                .collect(Collectors.joining("\n\n"));
    }

    public String winnerParticipants() {
        int maxDistanceLength = participantEntities.stream()
                .mapToInt(p -> p.getDistance().length())
                .max()
                .orElse(0);

        return participantEntities.stream()
                .filter(p -> p.getDistance().length() == maxDistanceLength)
                .map(ParticipantEntity::getName)
                .collect(Collectors.joining(", "));
    }

    private String forwardCar() {
        return participantEntities.stream()
                .peek(entity -> {
                    int randomNumber = Randoms.pickNumberInRange(0, 9);

                    if (randomNumber >= 4) {
                        successForward(entity);
                    }
                })
                .map(entity -> entity.getName() + " : " + entity.getDistance())
                .collect(Collectors.joining("\n"));
    }

    private void successForward(ParticipantEntity participantEntity) {
        participantEntity.forward();
    }

    private void participantNumberCount(String[] participants) {
        if (participants.length < 2) {
            throw new IllegalArgumentException("참가자는 2명이상 가능합니다.");
        }
    }

    private String nameValidation(String name) {
        name = name.trim();

        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("참가자의 이름은 1글자 이상, 5자 이하만 가능합니다.");
        }

        return name;
    }

    private int timeValidation(String time) {
        int validationTime = 0;

        try {
            validationTime = Integer.parseInt(time.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("시행횟수는 숫자만 가능합니다.");
        }

        return validationTime;
    }
}
