/*
 * 
 * ImageSpout
 * ���������κ��� ���ҵ� �̹����� �޾ƿ� ��Ʈ�� ����
 * Ȥ�� �������� �޾ƿͼ� �̹����� ĸó�� �� ��Ʈ�� ����
 * �������� �޾ƿ� �����ϴ� ������ �ʿ�
 * ������ "wget"�� ���� ��ɾ�� ������ �ٿ� ���� �� ���� > how to execute a command "wget"?
 * ������������ �ڹٿ��� ��ɾ �����ϰ� ������ ������ �����Ͽ� buffer�� ���ؼ� �о�� �̹����� ��ȯ
 * > how to do that in OS Window?
 * Ȥ�� �������� �ٿ���� �� �ִ� ��(������Ʈ)�� �̿��Ͽ� �������͸� ����
 * 
 * update 150327 Fri
 * imageCollector���� ���󿡼� �̹����� �����ϴ� ������ ����
 * ������ �̹����� Ư����� ������ �����ϰ� �ش� ������ �ִ� �̹������� �о�ͼ� emit
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
