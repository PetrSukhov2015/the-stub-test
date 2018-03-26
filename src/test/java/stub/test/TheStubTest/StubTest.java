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
		String resul = s.getTask(jsonId);		
	}

	
}
