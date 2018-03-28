package stub.test.TheStubTest;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.JSONPointer;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StubTestReqFields {
	
	JSONObject jsonId;
	Stub s;
	
	@BeforeTest
	public void b() throws ParseException, FileNotFoundException, IOException {
		//create stub
		 s = new Stub();

		//parse file to json object
		JSONParser parser = new JSONParser();         
      
        jsonId = (JSONObject)parser
            .parse(new FileReader("json\\taskIdOutOfReqFieldsId.json"));
       //System.out.println(jsonId.toString());
	}
	

	@Test
	public void tValid() throws IOException, ParseException{
		//result
		String res = s.getTask(jsonId);	
		
		//check result
		//System.out.println(res);
		Assert.assertTrue(res.contains("HTTP/1.1 200 OK")
				&& res.contains("{\"title\":\"Error\",\"type\":\"object\",\"properties\":{\"code\":{\"type\":\"400\"},\"description\":{\"type\":\"Bad Request\"}}}") 
				);
			
		//{"title":"Error","type":"object","properties":{"code":{"type":"400"},"description":{"type":"Bad Request"}}}
	}

	
}
