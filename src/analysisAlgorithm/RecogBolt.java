package analysisAlgorithm;

import java.util.Map;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

import com.atul.JavaOpenCV.Imshow;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class RecogBolt extends BaseBasicBolt {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void execute(Tuple arg0, BasicOutputCollector arg1) {
		

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		CascadeClassifier cascade = new CascadeClassifier("cars3.xml");
    	Mat frame = new Mat();
    	VideoCapture vc = new VideoCapture();
    	MatOfRect obj = new MatOfRect();
    	int i = 0;
    	
    	vc = (VideoCapture) arg0.getValue(0);

    	while(vc.read(frame)){
    		cascade.detectMultiScale(frame, obj, 1.1, 3, 0, new Size(10, 10), new Size(200, 200));
			Core.line(frame, new Point(160, 100), new Point(290, 100),
					new Scalar(255, 0, 0), 2);
			Core.line(frame, new Point(80, 50), new Point(200, 50),
					new Scalar(0, 0, 255), 2);
			
			for (Rect rect : obj.toArray()) {
				Core.rectangle(frame, new Point(rect.x, rect.y), new Point(
						rect.x + rect.width, rect.y + rect.height), new Scalar(
						0, 255, 0));
				/*
				if ((rect.x + (rect.width) / 2 > 90) && (rect.x +(rect.width) / 2 < 210)) {
					if (((rect.y) == 50)){
						j++;
						Core.line(frame, new Point(80, 50), new Point(200,
								50), new Scalar(0, 255, 0), 2);
						//System.out.println("ÇÏÇà : " + j);
					}
				}*/

				if ((rect.x + (rect.width) / 2 > 160) && (rect.x +(rect.width) / 2 < 300)) {
					if (((rect.y + rect.height) == 100)){
						i++;
						Core.line(frame, new Point(160, 100), new Point(290,
								100), new Scalar(0, 255, 0), 2);
					}
				}
			}
    	}
    	
    	arg1.emit(new Values("test_1", i));
    }

	@Override
	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub
		arg0.declare(new Fields("video_name", "traffic"));
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
