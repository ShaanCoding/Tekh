import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Program
{
    public static void main(String[] args) throws Exception
    {
        ConfigSettings configSettings = new ConfigSettings();
        String tokenKey = configSettings.GetTokenKey();

        JDA jda = new JDABuilder(tokenKey).build();
    }

}
