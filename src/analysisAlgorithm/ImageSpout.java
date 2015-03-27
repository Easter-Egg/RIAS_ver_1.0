/*
 * 
 * ImageSpout
 * 동영상으로부터 분할된 이미지를 받아와 볼트에 전달
 * 혹은 동영상을 받아와서 이미지로 캡처한 뒤 볼트로 전달
 * 동영상을 받아와 수집하는 전략이 필요
 * 리눅스 "wget"과 같은 명령어로 영상을 다운 받을 수 있음 > how to execute a command "wget"?
 * 리눅스에서는 자바에서 명령어를 수행하고 지정된 폴더에 접근하여 buffer를 통해서 읽어와 이미지로 변환
 * > how to do that in OS Window?
 * 혹은 동영상을 다운받을 수 있는 툴(웹사이트)를 이용하여 영상데이터를 수집
 * 
 * update 150327 Fri
 * imageCollector에서 영상에서 이미지를 추출하는 과정을 수행
 * 추출한 이미지를 특정경로 폴더에 저장하고 해당 폴더에 있는 이미지들을 읽어와서 emit
 * 
 * 추가 변경사항
 * 이미지를 분배하는게 아니라 영상 자체를 분배
 * 하나의 스트림이 하나의 영상을 처리
 * 이미지를 분배하면 신뢰도 급하락
 * 
 */

package analysisAlgorithm;

import java.util.Map;
import java.util.Random;

import org.opencv.core.Core;
import org.opencv.highgui.VideoCapture;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class ImageSpout extends BaseRichSpout {
	
	boolean checkOpenVideo;
	SpoutOutputCollector _collector;
	Random _rand;
	VideoCapture vc;
	
	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		_collector = arg2;
		_rand = new Random();
		checkOpenVideo = true;
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		vc = new VideoCapture();
	}

	@Override
	public void nextTuple() {
		Utils.sleep(1000);
		// read video at the folder that stores video and emit video.
		checkOpenVideo = vc.open("test_0.avi");
		System.out.println(checkOpenVideo);
		_collector.emit(new Values(vc));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		arg0.declare(new Fields("video_name"));
	}
}
