package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import com.aerospike.client.*;
import java.util.*;
import plugins.*;

public class Application extends Controller {

private static final String defaultNamespace = "test";
private static final String todoSet = "todos";
private static final String userSet = "users";
private static final AerospikeClient client = Play.application().plugin(ASPlugin.class).getASClient();

	public static Result index() {
		if (!client.isConnected())	{
			return ok(index.render(false,"Connection to Aerospike cluster failed! Please check your Aerospike IP and Port settings in application.conf",null));
		}
		try {
	  	Map<String, String> todos = new HashMap<String, String>();

			// Get how many todos the user has; NOTE: for simplicity, this is a single-user app so the user id is hardcoded to 'newuser'
			Key userKey = new Key(defaultNamespace, userSet, "newuser");
			Record userRecord = client.get(null, userKey);

			if (userRecord != null)	{					
				int todoCount = (Integer) userRecord.getValue("todocount");

				if (todoCount > 0)	{
					//	Retrieve existing to-dos using batch operation

					// 	Create an array of keys so we can initiate batch read operation
					Key[] keys = new Key[todoCount];
					for (int i = 0; i < keys.length; i++) {
						keys[i] = new Key(defaultNamespace, todoSet, ("newuser:" + (i + 1)));
					}

					// Initiate batch read operation
					Record[] records = client.get(null, keys);
					for (int j = 0; j < records.length; j++) {
						if (records[j] != null)	{
							todos.put(records[j].getValue("k").toString(),records[j].getValue("todo").toString());
						}
					}
				} 
			} else	{
				// 	Create user record and set default todo count to 0
				Bin todoCountBin = new Bin("todocount", 0);
				client.put(null, userKey, todoCountBin);
			}
	    return ok(index.render(true,"ok",todos));
		} catch (AerospikeException e) {
	    return ok(index.render(false,"AerospikeException: " + e.toString(),null));
		} catch (Exception e) {
	    return ok(index.render(false,"Exception: " + e.toString(),null));
		} 
	}

	public static Result createTodo() {
		if (!client.isConnected())	{
			return ok(index.render(false,"Connection to Aerospike cluster failed! Please check your Aerospike IP and Port settings in application.conf",null));
		}
		try {
	  	//	Read To-Do entered in the form
			Map<String, String[]> values = request().body().asFormUrlEncoded();
		  String todo = values.get("todo")[0];

			//	Get how many todos the user has; NOTE: for simplicity, this is a single-user app so the user id is hardcoded to 'newuser'
			Key userKey = new Key(defaultNamespace, userSet, "newuser");
			Record userRecord = client.get(null, userKey);
			int todoCount = (Integer) userRecord.getValue("todocount");

			//	Create new To-Do
			//	NOTE: the todoId is in format <newuser>:# so that we can initiate batch read by iterating over todo keys from 0 to user's <tweetcount> which is stored in the user record
			String todoId = ("newuser:" + (todoCount + 1));
			Key todoKey = new Key(defaultNamespace, todoSet, todoId);
			Bin todoKeyBin = new Bin("k", todoId);
			Bin todoBin = new Bin("todo", todo);
			Bin todoTSBin = new Bin("ts", System.currentTimeMillis());
			client.put(null, todoKey, todoKeyBin, todoBin, todoTSBin);

			//	Increment todocount
			client.put(null, userKey, new Bin("todocount", todoCount + 1));		
		} catch (AerospikeException e) {
	      return ok(index.render(false,"AerospikeException: " + e.toString(),null));
		} catch (Exception e) {
	      return ok(index.render(false,"Exception: " + e.toString(),null));
		} 
		//	Redirect the user to home/index/default route which will automatically refresh/reload the To-Dos
	  return redirect("/");
	}

	public static Result deleteTodo() {
		if (!client.isConnected())	{
			return ok(index.render(false,"Connection to Aerospike cluster failed! Please check your Aerospike IP and Port settings in application.conf",null));
		}
		try {
	  	//	Read To-Do key passed in the form as hidden field
			Map<String, String[]> values = request().body().asFormUrlEncoded();
	    String todoId = values.get("todoKey")[0];

			//	Get how many todos the user has; NOTE: for simplicity, this is a single-user app so the user key is hardcoded
			Key userKey = new Key(defaultNamespace, userSet, "newuser");
			Record userRecord = client.get(null, userKey);
			int todoCount = (Integer) userRecord.getValue("todocount");

			//	Delete To-Do
			Key todoKey = new Key(defaultNamespace, todoSet, todoId);
			client.delete(null, todoKey);
		} catch (AerospikeException e) {
	      return ok(index.render(false,"AerospikeException: " + e.toString(),null));
		} catch (Exception e) {
	      return ok(index.render(false,"Exception: " + e.toString(),null));
		} 
		//	Redirect the user to home/index/default route which will automatically refresh/reload the To-Dos
	  return redirect("/");
	}

}
