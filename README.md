# 자동차 경주 게임
---
## 1. 자동차
### a. 전진
      - 전진 횟수 상태값이 1만큼 증가 한다.
      - 전진 후 이름 및 전진 횟수의 상태값을 출력한다.

### b. 정지
      - 정지 후 이름 및 전진 횟수 상태값을 출력한다.

### c. 이름 세팅
      - 이름을 정해주면, 해당 이름으로 객체를 생성하고 반환한다. 
---
## 2. 경주 게임 매니저
### a. 게임 준비 
        - 자동차를 게임에 참여 시키키 전에, 입력된 자동차의 이름의 유효성을 검증기로 확인한다.
        - 입력된 이름으로 자동차를 생성하고, 게임 리스트에 생성된 자동차를 참여시킨다.

### b. 게임 시작
      - 게임 시작전에, 입력된 게임 진행 횟수의 유효성을 검증기로 확인한다.
      - 입력된 횟수만큼 게임 라운드를 진행 시킨다.
      - 게임을 종료 시킨다.

### c. 게임 진행
    - 0 ~ 9 사이의 랜덤값을 추출한다.
    - 랜덤값이 4 이상이면 해당 자동차는 전진한다.
    - 랜덤값이 3 이하이면 해당 자동차는 정지한다.

### d. 우승 자동차 선정
    - 경기 결과에서 가장 많은 전진 횟수 기록을 찾는다.
    - 해당 기록을 가지고 있는 자동차들을 우승자로 선정한다.

### e. 우승 자동차 발표
    - 선정된 우승 자동차의 이름을 출력한다.
    - 우승자가 여러명이라면, 쉼표(,)로 구분하여 출력한다.
---
## 3. 입력값 검증기
    - 검증 실패시 IllegalArgumentException을 발생시킨다.
    - 자동차 이름 검증: 이름은 반드시 입력되어야 하고, 5글자 이하여야 한다.
    - 경기 진행 횟수 검증: 경기 진행 횟수는 최소 1회 이상 입력 되어야 한다.
