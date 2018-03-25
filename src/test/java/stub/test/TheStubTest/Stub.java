package stub.test.TheStubTest;

import java.io.IOException;

import org.json.simple.JSONObject;

public class Stub {

	public String getTask(JSONObject jsonId)  {

		//create simple json
		JSONObject jsonResp = new JSONObject();
		//int theId = Integer.parseInt((String) jsonId.get("Id") );
		
		//case valid id
		if (theId < 1000){ //valid id
			jsonResp.put("id", 76699046);
			jsonResp.put("name", "Task 1");
			jsonResp.put("mark", 3.5);
			
		} else if (1000<theId){ //error id
			jsonResp.put("code", 404);
			jsonResp.put("description", "Not Found");
			
		} else if (1000 == theId){//no params
			jsonResp.put("code", 400);
			jsonResp.put("description", "Bad Request");
			
		}
		return "HTTP/1.1 200 OK\r\n"+jsonResp.toString();
		
	}
	

}
