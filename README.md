# java-racingcar-precourse

<기능 구현 목록>

1. Application
 - 사용자에게 입력받기
   1) 자동차 이름을 정하세요. (쉼표로 구분, 1자에서 5자 이내로 입력)
   2) 몇번의 이동을 시도할 것인가요?
   3) 사용자가 값을 입력 : m회 (범위를 정한 후 벗어날 경우 에러 표시로 어플종료) 

2. Racing
 - 게임시작
   1) 랜덤 값 구하기(범위 : 0~9사이)
   2) 랜덤 값에 따라 1칸 전진 or 멈춤
    - 0~3일 경우 : 멈춤
    - 4~9일 경우 : 1칸 전진
   3) 전진하는 자동차 출력(자동차 위치 상태 표시)
    - 이동 거리에 따라 '-'로 출력
   4) 시도 횟수-1
    - 시도 횟수 1 이상일 경우 게임 시작 1번으로 되돌아가서 반복
    - 0일 경우 경주 완료
   5) 경주 완료 후 우승자 뽑기
    - 한명이거나 여러명 출력(우승자가 여럿일 경우 이름 사이에 쉼표로 구분)