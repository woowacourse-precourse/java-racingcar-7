# java-racingcar-precourse

## 프로젝트 소개

초간단 자동차 경주 게임은 사용자가 입력한 자동차 이름과 시도 횟수에 따라 여러 대의 자동차가 경주를 하며, 최종 우승자를 결정하는 콘솔 기반 게임입니다. 간단한 로직을 통해 자동차의 전진 여부를 결정하고, 경주 결과를 실시간으로 출력합니다.

## 구현할 기능 목록

****게임 기능****

- **사용자 입력 처리**
  - 사용자가 경주할 자동차 이름을 입력할 수 있습니다.
  - 사용자가 시도할 횟수를 입력할 수 있습니다.
  - 잘못된 값이 입력될 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료합니다.

- **자동차 전진 및 정지**
    - 주어진 시도 횟수 동안 n대의 자동차가 전진하거나 멈출 수 있습니다.
    - 자동차의 전진 조건은 0에서 9 사이의 무작위 값을 생성한 후, 값이 4 이상일 경우 전진합니다.

- **자동차 이름 관리**
    - 각 자동차에 이름을 부여할 수 있으며, 이름은 쉼표(,)로 구분됩니다.
    - 자동차 이름은 5자 이하만 가능합니다.
    - 전진하는 자동차를 출력할 때 자동차 이름과 함께 이동 거리를 표시합니다.

- **우승자 결정 및 출력**
    - 경주가 완료된 후 우승자를 결정합니다.
    - 최종 우승자는 단독일 수도 있고, 여러 명일 수도 있습니다.
    - 우승자가 여러 명일 경우, 쉼표(,)로 구분하여 출력합니다.

## 실행 예시

```
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