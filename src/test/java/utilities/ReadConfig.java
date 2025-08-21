package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	static Properties pro;
	public ReadConfig()
	{
		File srcPath = new File("./src/test/resources/config.properties");
		try {
			FileInputStream conFile=new FileInputStream(srcPath);
			 pro = new Properties();
			 pro.load(conFile);
			}
		
		catch (IOException e) {
			System.out.println("Exception is"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	public String getBaseURL()
	{
		String url = pro.getProperty("BaseURL");
		return url;
	}
	public String getUsername()
	{
		String uname = pro.getProperty("username");
		return uname;
	}
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	    public static String getProperty(String key) {
        return pro.getProperty(key);
    }

}
