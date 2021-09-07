package com.example.java.kafka.consumer;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.couchbase.client.core.retry.FailFastRetryStrategy;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;


@Component
public class FirstTopicConsumer {
	
	private static int id=1;
	
    @KafkaListener(topics = "first_topic", groupId = "kafka-group")
    public void listen(String message) {
    	
    	final CouchbaseEnvironment env = DefaultCouchbaseEnvironment
		           .builder().connectTimeout(50000)
		           .retryStrategy(FailFastRetryStrategy.INSTANCE)
		           .build();
		CouchbaseCluster cluster = CouchbaseCluster.create(env,"127.0.0.1");
		cluster.authenticate("rupesh","rupesh");
		Bucket bucket = cluster.openBucket("example");
		
		
		JsonDocument doc = JsonDocument.create(""+id, JsonObject.create().put("message", message));
		id++;
		bucket.insert(doc);
        
    }
    

    
}
