package analysisAlgorithm;

import java.util.Map;

import org.opencv.core.Core;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class RecogBolt extends BaseBasicBolt {
	
	CascadeClassifier cascade = new CascadeClassifier("cascade.xml");
	VideoCapture vc = new VideoCapture();
	
    @Override
    public void execute(Tuple arg0, BasicOutputCollector arg1) {
        // TODO Auto-generated method stub
    	vc = (VideoCapture) arg0.getValue(0);
    	vc.grab();
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
