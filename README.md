# java-racingcar-precourse

## 1차 기능 구현 목록

- 기본 입력
    - 경주할 자동차 이름 입력 - Console.readLine 활용
    - 시도 횟수 입력

- 자동차 이름 바탕으로 자동차 객체 및 리스트 생성 **(Done)**

- 경주 진행
    - 자동차마다 0 ~ 9 사이 무작위 값 추출 후 4 이상이면 전진 **(Done)**
    - Randoms.pickNumberInRange 활용 **(Done)**

- 우승자 찾기
    - 자동차의 전진 횟수 중 최댓값 구하기
    - 최댓값과 동일한 전진 횟수를 가진 자동차 찾기

- 경주 종료
    - 우승자 이름 반환
    - 우승자가 여러 명이면 쉼표 이용하여 구분

## 클래스 다이어그램

- 메시지를 선택한 후 메시지를 처리할 책임이 있는 객체를 할당하는 방법으로 클래스 다이어그램을 제작했습니다

![자동차 경주 1차 클래스 다이어그램 (3)](https://github.com/user-attachments/assets/69c51d52-ed68-4dd9-81bb-7fb7ba1dbdd5)

## 패키지 설계

- view
    - InputView : 자동차 이름, 시도 횟수 입력 문구 출력
    - ResultView : 경주 결과, 우승자 출력

- domain
    - CarFactory : 자동차 이름을 기준으로 Cars 생성
    - Cars : 생성된 여러 Car을 관리
    - Car : 각 자동차를 의미. 이동/정지 결정

- controller
    - RacingGame : 자동차 경주 게임을 실행

## 프로그래밍 요구사항

- 들여쓰기는 2까지 허용
- 삼항 연산자 금지
- 함수는 한 가지 일만 하도록
- Junit과 AssertJ를 이용하여 기능 목록 테스트
