/*
 * 
 * ReportBolt
 * 분석 결과를 종합하는 볼트. 분석 대상의 출현 횟수를 종합하는 것으로 생각 중
 * Mongo DB를 연구하여 가능하면 해당 볼트가 필요 없을 수도 있을 듯
 * 
 */

package analysisAlgorithm;

import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;

public class ReportBolt implements IRichBolt {

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
