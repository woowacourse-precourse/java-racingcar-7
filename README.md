# java-racingcar-precourse

# 기능 목록
## 1. 자동차 이름 입력받기
- 쉼표로 구분된 자동차 이름 입력 받음
- 예외처리: 자동차 이름은 5자 이하

## 2. 시도 횟수 입력받기
- 입력된 수는 1 이상
- 예외처리: 0, 음수 등

## 3. 자동차(Car) 객체 생성
- 자동차의 이름, 위치 

## 4. 라운드별 전진 여부 결정 및 실행
- 0에서 9 사이의 무작위 값을 생성
- 4 이상일 경우 자동차를 한 칸 전진

## 5. 라운드 결과 출력
- 자동차이름:현재위치 출력
- 시도 횟수로 반복문

## 6. 최종 우승자 판별
- 위치가 가장 높은 자동차 출력
- 공동 우승자의 경우, 우승자 모두 출력

## 7. 테스트 코드 
- 공동 우승자인 경우 테스트 추가
- 시도횟수가 예외인 경우 테스트 추가
- 자동차 이름이 공백이거나 중복인 경우 테스트 추가