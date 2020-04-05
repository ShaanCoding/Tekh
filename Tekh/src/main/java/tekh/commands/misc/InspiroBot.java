package tekh.commands.misc;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class InspiroBot extends Command
{
    private static String sessionID = GetSessionID();

    public InspiroBot()
    {
        this.name = "inspire";
        this.aliases = new String[]{"shittyquote", "shittyquotes", "inspired", "inspiring"};
        this.category = new Category("Misc");
        this.arguments = "";
        this.help = "Generates a random terrible inspirational quote.";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        //Checks if bot
        if(!e.getMember().getUser().isBot())
        {
            e.getTextChannel().sendMessage("**Inspirational Quote: **" + GrabInspirationalQuote()).queue();
        }
    }

    public static String GetSessionID()
    {
        try
        {
            //Grabs token
            URL inspiroBotSessionID = new URL("https://inspirobot.me/api?getSessionID=1");
            BufferedReader in = new BufferedReader(new InputStreamReader(inspiroBotSessionID.openStream()));
            String inputLine = in.readLine();
            return inputLine;
        }
        catch(Exception ex)
        {
            System.out.println("An exception has occured, refer to: " + ex.toString());
            return null;
        }
    }

    public String GrabInspirationalQuote()
    {
        String post_id = "";

        try
        {
            String shittyQuoteURL = String.format("http://inspirobot.me/api?generateFlow=1&sessionID=%s", sessionID);
            java.io.InputStream is = new java.net.URL(shittyQuoteURL).openStream();
            String contents = new String(is.readAllBytes());

            JSONObject obj = new JSONObject(contents);
            JSONArray arr = obj.getJSONArray("data");
            for (int i = 0; i < arr.length(); i++)
            {
                if(!arr.getJSONObject(i).isNull("text"))
                {
                    post_id = arr.getJSONObject(i).getString("text");
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("An exception has occured, refer to: " + ex.toString());
        }

        return post_id;
    }
}
