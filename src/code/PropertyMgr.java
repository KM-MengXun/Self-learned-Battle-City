package code;

import java.io.IOException;
import java.util.Properties;

//class to read the configration file
//configration makes it easier to change the value that used in the code
//https://blog.csdn.net/weixin_33691700/article/details/86276895?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
public class PropertyMgr {
	static Properties props = new Properties();
	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object get(String key) {
		if (props == null)
			return null;
		return props.get(key);
	}
//	public static void main(String[] args)
//	{
//		System.out.println(PropertyMgr.get("initTankCount"));
//		System.out.println(PropertyMgr.get("tankSpeed"));
//	}

}
