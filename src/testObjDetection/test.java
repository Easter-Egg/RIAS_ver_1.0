package testObjDetection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;

import com.atul.JavaOpenCV.Imshow;

public class test {
	public static void main(String[] args) throws InterruptedException {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		VideoCapture vc = new VideoCapture("test_1.avi");
		Mat frame = new Mat();
		CascadeClassifier cascade = new CascadeClassifier();
		Boolean cascadeCheck = cascade.load("cars3.xml");
		MatOfRect obj = new MatOfRect();
		Imshow im = new Imshow("Test");

		int i;
		i = 0;
		
		if (!cascadeCheck)
			System.out.println("Cascade Open Error");

		if (!vc.isOpened())
			System.out.println("File Open Error");

		while (vc.read(frame)) {
			cascade.detectMultiScale(frame, obj);
			Core.line(frame, new Point(160, 100), new Point(290, 100),
					new Scalar(255, 0, 0), 2);
			Core.line(frame, new Point(100, 50), new Point(200, 50),
					new Scalar(0, 0, 255), 2);

			for (Rect rect : obj.toArray()) {
				Core.rectangle(frame, new Point(rect.x, rect.y), new Point(
						rect.x + rect.width, rect.y + rect.height), new Scalar(
						0, 255, 0));

				if ((rect.x + (rect.width) / 2 > 160)
						&& (rect.x + (rect.width) / 2 < 300))
					if ((rect.y + (rect.height) / 2 == 100)) {// || rect.y ==
																// 100 || rect.y
																// + rect.height
																// == 100){
						i++;
						Core.line(frame, new Point(160, 100), new Point(290,
								100), new Scalar(0, 255, 0), 2);
						System.out.println("ป๓วเ : " + i);
					}

			}

			im.showImage(frame);
			Thread.sleep(34);
		}
	}
}