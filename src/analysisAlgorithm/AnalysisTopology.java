package analysisAlgorithm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import backtype.storm.utils.Utils;

public class AnalysisTopology { // Topology that analysis image and recognize a
								// 'Thing' and count it.

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TopologyBuilder tBuilder = new TopologyBuilder();

		// attach a spout to emit images from video.
		tBuilder.setSpout("image-Spout", new ImageSpout(), 1);
/*
		// attach a bolt to recognize a 'Thing' from video.
		tBuilder.setBolt("recog-Bolt", new RecogBolt(), 1).shuffleGrouping(
				"image-Spout");

		// attach a bolt to count a 'Thing' from stream.
		tBuilder.setBolt("count-Bolt", new CountBolt(), 1).fieldsGrouping(
				"recog-Bolt", new Fields("iName"));

		// attach a bolt to report a result. using globalGrouping
		tBuilder.setBolt("report-Bolt", new ReportBolt(), 1).globalGrouping(
				"count-Bolt");
*/
		Config conf = new Config();

		conf.setDebug(true);

		if (args != null && args.length > 0) {				// on Cluster
			conf.setNumWorkers(3);
			StormSubmitter.submitTopology(args[0], conf,
					tBuilder.createTopology());
		} else {											// on Local cluster
			conf.setMaxTaskParallelism(1);
			LocalCluster cluster = new LocalCluster();
			cluster.submitTopology("analysis-image", conf,
					tBuilder.createTopology());
			Utils.sleep(60000);
			cluster.killTopology("analysis-image");
			cluster.shutdown();
		}
	}
}
