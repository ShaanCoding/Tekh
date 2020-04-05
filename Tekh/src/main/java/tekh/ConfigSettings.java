package tekh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigSettings
{
    public String GetTokenKey()
    {
        try
        {
            return ReadConfig("tokenKey");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String GetOwnerID()
    {
        try
        {
            return ReadConfig("ownerID");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String GetServerInvite()
    {
        try
        {
            return ReadConfig("serverInvite");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String GetWebsite()
    {
        try
        {
            return ReadConfig("websiteURL");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public String GetOAuthLink()
    {
        try
        {
            return ReadConfig("OAuthLink");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public String GetPrefix()
    {
        try
        {
            return ReadConfig("prefix");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private String ReadConfig(String property) throws IOException
    {
        String returnString = "";
        InputStream inputStream = null;
        try
        {
            Properties properties = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
            {
                properties.load(inputStream);
            }
            else
            {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            returnString = properties.getProperty(property);
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
        finally
        {
            //Garbage collector in case it still is open if a error occurs
            inputStream.close();
        }
        return returnString;
    }
}
