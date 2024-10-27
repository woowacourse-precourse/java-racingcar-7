# 자동차 경주

## 소개

초간단 자동차 경주 게임.

- 주어진 횟수 동안 랜덤으로 n대의 자동차를 `전진` or `멈추기` 하여 우승자를 가려내는 게임.


## 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- `전진` or `멈추기` 둘 중 하나만 가능.
- 각 자동차에 `쉼표(,)`를 기준으로 `이름` 부여, 이름의 `길이 <= 5`
- 시도할 횟수`(try_num)` 입력 필요.
- `Random`값이 `4 이상`일 경우 전진.
- 우승자는 `한 명 이상`일 수 있고, 이때 `쉼표(,)`를 사용
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시킨 후 애플리케이션 종료.

## 입출력 요구 사항

#### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
``` java
pobi,woni,jun
```
- 시도할 횟수
``` java
5
```

##### 출력

- 차수별 실행 결과
``` java
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구
``` java
최종 우승자 : pobi
```

- 공동 우승자 안내 문구
``` java
최종 우승자 : pobi, jun
```

- 실행 결과 예시

``` java
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 기능 목록

- `Application` 클래스
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Console API`사용해 입력
    - 입력받은 인자를 `Validate` 클래스를 사용해 검증
    - 입력받은 이름들, 그리고 Racing 시도 횟수를 `Racing` 클래스를 호출해 넘긴다.

- `Validate` 클래스 : 입력값 검증
    - `isNameLengthValid` : `name`이 5자 이하인지 검증
    - `isNameCommaSeparated` : `name` 리스트가 `쉼표(,)로 구분되는 지 검증
    - `isNumeric` : `시도횟수`가 숫자인지 검증

- `Racing` 클래스 : 랜덤으로 레이싱을 굴려 우승자를 가려내는 클래스
    - `random` 함수 : `camp.nextstep.edu.missionutils.Randoms`에서 제공하는 `pickNumberInRange()`로 랜덤값 하나 반환
    - `goStop` 함수 : 레이싱 카 번호를 받아서 `random` 함수를 이용해서 `전진` or `멈춤` 수행하는 함수
    - `run` 함수 : 시도횟수만큼 랜덤으로 게임을 수행하는 함수.
    - `findMaxProgress` 함수 : 가장 많이 전진(`go`)한 횟수 탐색
    - `win` 함수 : 우승자(`winner`) 탐색 후 출력
    - `nowProgress` : 현재 진행 상태 `ProgressBar`를 출력