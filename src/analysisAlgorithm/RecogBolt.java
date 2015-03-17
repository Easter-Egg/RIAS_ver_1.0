/*
 * 
 * RecogBolt
 * ImageSpout를 통해서 받은 이미지를 분석
 * 분석 전략을 어떻게 할 것인가?
 * 움직이는 사물인식? 특정 물체 인식?
 * 스트림을 통해 들어오는 이미지를 분석
 * 이전 튜플과 다음 튜플을 비교하여 차영상으로 움직이는 물체 인식 가능?
 * 구체적 구현 보다 우선적으로 무엇을 인식할 것이며 어떻게 인식할 것인지 결정이 필요
 * 
 */

package analysisAlgorithm;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;

public class RecogBolt implements IRichBolt {

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Tuple arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
