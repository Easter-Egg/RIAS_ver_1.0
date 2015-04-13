# RIAS_ver_1.0

Repository for Real-time Image Analysis System

충남대학교 컴퓨터공학과 10학번 김태우 (a.k.a Skidmarkii) Storm을 이용한 실시간 대용량 이미지 분석 시스템을 위한 저장소입니다.

궁금한 점이 있으면 tu_k@naver.com로 메일을 보내주시길 바랍니다.

-----------------------------------------------------------------------------------

150327 friday 수정사항

openCV를 이용하여 비디오를 읽어서 Emit (

7092 [Thread-8-image-Spout] INFO  backtype.storm.daemon.task - Emitting: image-Spout default [org.opencv.highgui.VideoCapture@124acbff]
true

true 값은 vc.open의 리턴값으로 파일을 정상적으로 열었는지 알 수 있다.

image-Spout가 VideoCapture 객체를 Emitting 하는 것을 확인할 수 있다.

-----------------------------------------------------------------------------------

150406 monday 수정사항

영상의 프레임으로부터 cascade 파일을 적용하여 객체를 배열로 저장 및 submat으로 접근 가능

카운팅 전략 수립

1. submat의 좌표값을 구해서 프레임상의 직선과 닿으면 (같은 좌표에 있으면) 카운팅

2. submat의 중앙값을 이용하여 프레임상의 직선에 닿으면 카운팅


3. submat의 좌표값이 직선을 지나 빠져 나갈 때 카운팅


4. submat들을 비교하여 중복된 객체들은 제거
