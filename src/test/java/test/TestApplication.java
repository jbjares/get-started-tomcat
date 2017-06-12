/*******************************************************************************
 * Copyright (c) 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/ 
package test;

import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.RetrieveAndRank;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrCluster.Status;
import com.ibm.watson.developer_cloud.retrieve_and_rank.v1.model.SolrClusterOptions;


public class TestApplication {
	
	public static void main(String[] args) throws InterruptedException {
		RetrieveAndRank service = new RetrieveAndRank();
		service.setUsernameAndPassword("dde0d58a-2f6b-436b-9ce0-5b72c6fbd7db", "MwA0Ei6BO5EJ");

		// 1 create the Solr Cluster
		SolrClusterOptions options = new SolrClusterOptions("note", 1);
		SolrCluster cluster = service.createSolrCluster(options).execute();
		System.out.println("Solr cluster: " + cluster);

		// 2 wait until the Solr Cluster is available
		while (cluster.getStatus() == Status.NOT_AVAILABLE) {
		  Thread.sleep(10000); // sleep 10 seconds
		  cluster = service.getSolrCluster(cluster.getId()).execute();
		  System.out.println("Solr cluster status: " + cluster.getStatus());
		}

		// 3 list Solr Clusters
		System.out.println("Solr clusters: " + service.getSolrClusters().execute());
	}

}
