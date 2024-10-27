# java-racingcar-precourse

## 🛠️기능 목록

- 경주할 자동차 이름 입력 받기
    - 자동차는 여러대 일 수 있으며 쉼표(,)로 이름을 구분
    - 이름은 최대 5자
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- 이동 횟수 입력 받기
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- 전진하기
    - 0~9 사이 무작위 값을 구하여 4 이상일 경우 전진
    - `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
    - 예시) `Randoms.pickNumberInRange(0, 9);`
- 차수 별 진행 결과 출력하기
    - 전진 시 ‘-’ 추가
- 최종 우승자 출력하기
    - 우승자가 여러 명일 경우 쉼표(,)로 구분

## ⚡ 예외 상황

- [ ]  Car의 이름이 5를 초과할 경우
- [ ]  Car의 이름이 비어있을 경우
- [ ]  이름이 중복될 경우