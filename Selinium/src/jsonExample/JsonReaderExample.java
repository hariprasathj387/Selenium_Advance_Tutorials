package jsonExample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsonReaderExample {

	//JSON means==>JavaScript Object NOtation
	//this is a data representation..it is used to take data easy and light weight and fast
	//xml more than powerfull JSON
	//extension is user.json
	//class==>JSONObject,JSONArray,JSONParser
	//josn is a key and parred value so use put method like hasMap()..
	//there are important classe in the JSOn==>package==>org.json.simple.JSONO;
	//class==>JSONObject,JSONArray,JSONParse
	
	
	static void  JsonReader() throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		//read the location of file
		FileReader fileReader = new FileReader("F:\\Selinium\\haiprasath.json");
		
		Object objectParser = 	jsonParser.parse(fileReader);
		
		JSONObject jsonObject = (JSONObject) objectParser;
		
		String schoolName=(String)jsonObject.get("School");
		//JSON values only allowed float value..int datatype not allowed..float is big capacity of include the all numbers
		Long Age=(Long)jsonObject.get("Age");
		String TownName=(String)jsonObject.get("Town");
		String Name=(String)jsonObject.get("Name");
		String collegeName=(String)jsonObject.get("College");

		System.out.println("The School name is: "+schoolName);
		System.out.println("The person age is: "+Age);
		System.out.println("The Town name is: "+TownName);
		System.out.println("The Name is: "+Name);
		System.out.println("The  College Name is: "+collegeName);
		
		JSONArray jsonArray =(JSONArray) jsonObject.get("Specail Qualities");
		Iterator<String> iterator = jsonArray.iterator();
		int i=1;
		while(iterator.hasNext()) {
			if(i==1) {
			System.out.print("The special qualities are :- ");
			}
			i++;
			System.out.print(iterator.next()+",");
		
		}
		
	
		
	}
	
	
	
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
	JsonReader();	

	}

}
