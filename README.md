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
