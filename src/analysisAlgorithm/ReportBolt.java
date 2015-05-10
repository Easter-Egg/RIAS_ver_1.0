/*
 * 
 * ReportBolt
 * �м� ����� �����ϴ� ��Ʈ. �м� ����� ���� Ƚ���� �����ϴ� ������ ���� ��
 * Mongo DB�� �����Ͽ� �����ϸ� �ش� ��Ʈ�� �ʿ� ���� ���� ���� ��
 * 
 */

package analysisAlgorithm;

import java.util.Date;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ReportBolt extends BaseRichBolt {

	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Tuple arg0) {
		// TODO Auto-generated method stub
		String video = arg0.getStringByField("video_name");
		int traffic = arg0.getIntegerByField("traffic");
		System.out.println(video + " : " + traffic);

		MongoClient mongo = new MongoClient("127.0.0.1", 27017);

		// .getDB()�� ��� �����ϰ� .getClooection()���� �÷����� �����´�.
		DB db = mongo.getDB("car");
		DBCollection coll = db.getCollection("carCount");
		// BasicDBObject�� �����Ͽ� ��ť��Ʈ�� �����.
		BasicDBObject doc = new BasicDBObject();
		doc.put("video", "" + video);
		doc.put("totalCount", "" + traffic);
		doc.put("datetime", new Date());

		// ������ ��ť��Ʈ�� .insert() �Լ��� �÷��ǿ� �����Ѵ�.
		coll.insert(doc);
	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub

	}

}
