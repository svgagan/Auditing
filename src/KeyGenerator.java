import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class KeyGenerator {

	Random rr=new Random();

public int  getKeys(){

	
	String str="";
	str=String.valueOf(rr.nextInt(10))+String.valueOf(rr.nextInt(10))+String.valueOf(rr.nextInt(10))+String.valueOf(rr.nextInt(10))+String.valueOf(rr.nextInt(10))+String.valueOf(rr.nextInt(10));
	return Integer.parseInt(str);
	
	
}
	

public static void main(String args[]){

KeyGenerator Generator = new KeyGenerator();

System.out.println(Generator.getKeys());

}

}