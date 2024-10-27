# java-racingcar-precourse

## 1. User Story

- 사용자는 초간단 자동차 경주 게임을 하고 싶다.

## 2. 기능 목록

- 사용자로부터 n대의 자동차 이름에 대하여 쉼표로 구분된 형태의 문자열을 입력받는다.
    + 개별 자동차 이름이 5자를 초과한다면 IllegalArgumentException을 발생시킨다.
- 사용자로부터 몇 번의 race를 할 건지 입력받는다. (race round라고 정의)
- 각 자동차에 대해 입력받은 이름과 score를 부여하는데, 이 때 score의 초기 값은 0으로 한다.
- race round 마다 각 자동차별로 0에서 9까지에서 무작위 값을 구하고,
- 무작위 값이 4이상이면 score에 1을 더한다. (score를 얻는다는 건 전진하는 것을 의미)
- 매 race round 마다 각 자동차별 score를 출력해주는데, score의 크기만큼 "-"를 반복하여 표기한다.
- race round가 모두 끝나면 score가 가장 높은 자동차 이름을 출력하고,
- 우승자가 여러 명이면 쉼표를 이용하여 구분하여 출력한다.
