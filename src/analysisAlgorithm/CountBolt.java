/*
 * 
 * CountBolt
 * How to count it? Count what?
 * 인식된 물체를 카운팅
 * 인식된 물체에 특정한 표시를 남김 (일반적으로 사각형이나 원과 같은 도형을 이용)
 * 특정한 표시를 카운팅
 * 서로 다른 차량이 한 화면에 있을 때 다름을 파악해야 함 > Haar-Feature 가 적합하다고 생각 < difficult...
 * RecogBolt와 마찬가지로 이미지 분석 전략 수립을 우선적으로 수행해야함
 * 결과를 위해서 결과 수집 볼트로 "이미지명, 출현횟수"와 같은 일정 형식의 데이터로 전달
 * 
 */

package analysisAlgorithm;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class CountBolt extends BaseRichBolt {

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
