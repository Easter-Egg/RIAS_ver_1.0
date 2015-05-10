/*
 * 
 * ReportBolt
 * 분석 결과를 종합하는 볼트. 분석 대상의 출현 횟수를 종합하는 것으로 생각 중
 * Mongo DB를 연구하여 가능하면 해당 볼트가 필요 없을 수도 있을 듯
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

		// .getDB()로 디비를 연결하고 .getClooection()으로 컬렉션을 가져온다.
		DB db = mongo.getDB("car");
		DBCollection coll = db.getCollection("carCount");
		// BasicDBObject를 생성하여 다큐먼트를 만든다.
		BasicDBObject doc = new BasicDBObject();
		doc.put("video", "" + video);
		doc.put("totalCount", "" + traffic);
		doc.put("datetime", new Date());

		// 생성한 다큐먼트를 .insert() 함수로 컬렉션에 삽입한다.
		coll.insert(doc);
	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
		// TODO Auto-generated method stub

	}

}
