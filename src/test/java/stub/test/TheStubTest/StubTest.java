package stub.test.TheStubTest;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.JSONPointer;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StubTest {
	
	JSONObject jsonIdObject;
	Stub s;
	
	@BeforeTest
	public void b() throws ParseException, FileNotFoundException, IOException {
		//create stub
		 s = new Stub();
		
		//create taskId
		//String filePath = "D:\\EclipseMars2\\TheStubTest\\json\\taskId.json";
		//JSONParser jsonParser = new JSONParser();
		//jsonIdObject = (JSONObject) jsonParser.parse(filePath);
		
		JSONParser parser = new JSONParser();

            Object object = parser
                    .parse(new FileReader("D:\\EclipseMars2\\TheStubTest\\json\\taskId.json"));
            
            //convert Object to JSONObject
            jsonIdObject = (JSONObject)object;
        
	}
	

	@Test
	public void tValid() throws IOException{
		//Assert.assertTrue(s.getTask(jsonIdObject), )
		System.out.println(s.getTask(jsonIdObject));
	}
	/*
	public void tUnValid() throws IOException{
		System.out.println(s.getTask("123"));
	}
	public void tBadParams() throws IOException{
		
		System.out.println(s.getTask("123"));
	}*/
}
