package jsonExample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.firefox.FirefoxProfile;

public class JSONExample {

		
	 static void JsonObject() throws IOException {
		 
		 JSONObject jsonObject = new JSONObject();
		 jsonObject.put("Name", "Haripasath");
		 jsonObject.put("Age", 21);
		 jsonObject.put("School", "RMHSS");
		 jsonObject.put("College", "KSRCE");
		 jsonObject.put("Town", "Puliyur");
		 
		 //When u add arrray to using arrayClass of json:-
		 JSONArray jsonArray = new JSONArray();
		 jsonArray.add("My spacial quality is a witting coding ");
		 jsonArray.add("My Special quality is a dinking Alchocal ");
		 //System.out.println(jsonArray);
		 jsonObject.put("Specail Qualities", jsonArray);
		 FileWriter fileWriter =  new FileWriter("haiprasath.json");
		//==>or uses to toString Method...The fileWriter is a string character so write method not allowed to wite a object..so we convert to toString() (or)toJSONString();
		 fileWriter.write(jsonObject.toJSONString()); 
		 fileWriter.flush();
		 fileWriter.close();
		System.out.println("SucessFully Completed");
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		JsonObject();
	}


}
