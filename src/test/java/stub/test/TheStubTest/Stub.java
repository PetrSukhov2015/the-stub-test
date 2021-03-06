package stub.test.TheStubTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Stub {
	
	public String getTask(JSONObject jsonId) throws FileNotFoundException, IOException, ParseException  {
	
		// error
		JSONParser parser = new JSONParser();
		JSONObject jsonError = (JSONObject) parser
				.parse(new FileReader("json\\error.json"));

		// not found answer json
		parser = new JSONParser();
		JSONObject jsonNotFound = (JSONObject) parser
				.parse(new FileReader("json\\notFound.json"));

		// task json
		parser = new JSONParser();
		JSONObject jsonTask = (JSONObject) parser
				.parse(new FileReader("json\\task.json"));

		// create response json
		JSONObject jsonResp = new JSONObject();
		
		
		
		// get id from children nodes
		// properties/id/description
		String keyId;
		try{
			keyId = (((HashMap) ((HashMap) jsonId.get("properties")).get("id")).get("type")).toString();
		}catch(NullPointerException e){
			keyId = null;
		}
		//out of keys => error
		if(null == keyId){
			jsonResp=jsonError;
			// not found
		}else if( false == "76699046".equals(keyId) ){
			jsonResp=jsonNotFound;
			System.out.println(jsonResp.toString());
			//fast found
		}else{
			jsonResp=jsonTask;
		}
		return "HTTP/1.1 200 OK\r\n" +
        "Server: TheServer/2018-26-03\r\n" +
        "Content-Type: text/html\r\n" + //mime text not json
        "Content-Length: " + jsonResp.toString().length() + "\r\n" +
        "Connection: close\r\n\r\n" +
        jsonResp.toString();
		
		

	
	}
	

}
