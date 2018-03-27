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

public class StubTest {
	
	JSONObject jsonId;
	Stub s;
	
	@BeforeTest
	public void b() throws ParseException, FileNotFoundException, IOException {
		//create stub
		 s = new Stub();

		//parse file to json object
		JSONParser parser = new JSONParser();         
      
        jsonId = (JSONObject)parser
            .parse(new FileReader("D:\\EclipseMars2\\TheStubTest\\json\\taskId.json"));
       
	}
	

	@Test
	public void tValid() throws IOException, ParseException{
		//result
		String res = s.getTask(jsonId);	
		
		//check result
		Assert.assertTrue(res.contains("HTTP/1.1 200 OK")
				&& res.contains("\"id\":{\"description\":\"The unique identifierfor a object\",\"type\":\"76699046\"}")
				&& res.contains("\"name\":{\"description\":\"Task 1\"")
				&& res.contains("\"mark\":{\"type\":\"3.5\""));
		
		//{"id": 76699046, "name": "Task 1","mark": 3.5
		//{"title":"Task","type":"object","properties":{"name":{"description":"Task 1","type":"string"},"id":{"description":"The unique identifierfor a object","type":"76699046"},"mark":{"type":"3.5","exclusiveMinimum":0}},"required":["id","name","mark"]}

		//System.out.println("");
	}

	
}
