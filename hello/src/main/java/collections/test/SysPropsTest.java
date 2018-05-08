package collections.test;
import java.util.*;

class SysPropsTest{

	public static void main(String[] args){
		if(args.length > 0)
			System.out.println(System.getProperty(args[0]));
		else{
			Properties props = System.getProperties();
			Set<Object> keys = props.keySet();
			for(Iterator<Object> i = keys.iterator(); i.hasNext();){
				String key = (String) i.next();
				System.out.println(key + " = " + props.getProperty(key));
			}
		}
	}	
}