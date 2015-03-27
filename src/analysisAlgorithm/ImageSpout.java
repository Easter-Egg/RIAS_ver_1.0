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
 * �߰� �������
 * �̹����� �й��ϴ°� �ƴ϶� ���� ��ü�� �й�
 * �ϳ��� ��Ʈ���� �ϳ��� ������ ó��
 * �̹����� �й��ϸ� �ŷڵ� ���϶�
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
