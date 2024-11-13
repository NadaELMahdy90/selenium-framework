package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonDataReader {
    public  Map<String, String> map = new HashMap<String, String>();

    public  void JsonReader(String tcName) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();

        File srcFile = getFile("UserData");
        File testCaseFile = getFile("testCaseName");

        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        JSONObject jobject = (JSONObject) parser.parse(new FileReader(testCaseFile));

        int num = ((Long) jobject.get(tcName)).intValue() ;
        fillData(jarray , num);
    }
    private  File getFile(String fileName) throws FileNotFoundException {
        return new File("C:\\Users\\VEGA Laptop\\Desktop\\AutomationTask\\AutomationTask\\src\\test\\java\\data\\" + fileName + ".json");
    }

    private  void fillData(JSONArray jarray , int idx)
    {
        JSONObject person =(JSONObject) jarray.get(idx);
        map.put("userName", (String) person.get("userName"));
        map.put("password", (String) person.get("password"));
    }

}
