/*
 * 
 * CountBolt
 * How to count it? Count what?
 * �νĵ� ��ü�� ī����
 * �νĵ� ��ü�� Ư���� ǥ�ø� ���� (�Ϲ������� �簢���̳� ���� ���� ������ �̿�)
 * Ư���� ǥ�ø� ī����
 * ���� �ٸ� ������ �� ȭ�鿡 ���� �� �ٸ��� �ľ��ؾ� �� > Haar-Feature �� �����ϴٰ� ���� < difficult...
 * RecogBolt�� ���������� �̹��� �м� ���� ������ �켱������ �����ؾ���
 * ����� ���ؼ� ��� ���� ��Ʈ�� "�̹�����, ����Ƚ��"�� ���� ���� ������ �����ͷ� ����
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
