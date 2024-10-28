# java-racingcar-precourse
해당 프로젝트는 사용자의 입력에 따라 진행하는 초간단 자동차 경주 게임을 구현하는 것을 목표로 한다.

<br>

# To do List
- [x] 입력 안내 메시지 출력
- [x] 사용자 문자열 입력 받기
- [x] 자동차 이름 저장
- [x] 무작위 값 구하기
- [x] 경주 결과 출력
- [x] 우승자 확인
- [x] 실행 오류 반환 및 출력

<br>

# 프로젝트 요구사항 정의
[해당 문서 참조](./Docs/requirement.md)

<br>

# Commit Message Convention
[해당 문서 참조](./Docs/commit.md)

<br>

# 구현 함수 목록 및 설명

| Class Name | Return Type | Method Name | Description |
| --- | --- |  --- | --- |
| [Application](/src/main/java/racingcar/Application.java) | ```void``` | [```setArguments()```](./src/main/java/racingcar/Application.java#L24) | 프로그램을 수행하기 위해 사용자에게 문자열을 입력받습니다. |
| [Application](/src/main/java/racingcar/Application.java) | ```void``` | [```progressRace()```](./src/main/java/racingcar/Application.java#L43) | 입력된 값들을 활용하여 경주를 진행합니다.<br>각 자동차의 전진을 시도한 후, 시도 결과를 출력합니다. |
| [Application](/src/main/java/racingcar/Application.java) | ```List<String>``` | [```searchWinner()```](./src/main/java/racingcar/Application.java#L57) | 경주를 모두 마친 후, 경주의 우승자를 탐색합니다. |
| [Application](/src/main/java/racingcar/Application.java) | ```int``` |  [```getWinnerMoveForwardCount()```](./src/main/java/racingcar/Application.java#L74) | 경주의 우승자가 전진한 횟수를 반환합니다. |
| [Application](/src/main/java/racingcar/Application.java) | ```void``` |  [```printWinners(List<String> winners)```](./src/main/java/racingcar/Application.java#L88) | 경주 우승자 명단을 통해 최종 우승자를 출력합니다. |
| [CarInitializer](/src/main/java/racingcar/CarInitializer.java) | ```List<String>``` | [```splitCarNameString(String inputString)```](./src/main/java/racingcar/CarInitializer.java#L19) | 사용자에게 입력받은 이름 문자열을 지정된 구분자를 활용하여 구분한 후, List로 반환합니다. |
| [CarInitializer](/src/main/java/racingcar/CarInitializer.java) | ```void``` | [```setStateMap(List<String> nameList)```](./src/main/java/racingcar/CarInitializer.java#L32) | 이름 List를 경주할 자동차로 등록합니다. |
| [ProgressCarRace](/src/main/java/racingcar/ProgressCarRace.java) | ```void``` | [```moveForward(Map<String, Integer> stateMap)```](./src/main/java/racingcar/ProgressCarRace.java#L16) | 각 자동차의 전진을 한 차례 시도합니다.<br>전진 조건은 무작위 값이 일정 수치 이상인 경우입니다. |
| [ProgressCarRace](/src/main/java/racingcar/ProgressCarRace.java) | ```String``` | [```printStates(Map<String, Integer> stateMap)```](./src/main/java/racingcar/ProgressCarRace.java#L28) | 현재 각 자동차의 상황(전진 횟수)을 문자열로 반환합니다. |