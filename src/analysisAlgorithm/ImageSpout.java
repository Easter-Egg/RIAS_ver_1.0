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
 * 
 */

package analysisAlgorithm;

import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.utils.Utils;

public class ImageSpout extends BaseRichSpout {
	SpoutOutputCollector _collector;
	Random _rand;
	
	@Override
	public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
		_collector = arg2;
		_rand = new Random();
	}

	@Override
	public void nextTuple() {
		Utils.sleep(100);
	}


	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
	}
}
