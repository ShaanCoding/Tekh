package tekh.commands.web;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poll extends Command
{
    public Poll()
    {
        this.name = "strawpoll";
        this.aliases = new String[]{"poll", "polls", "strawpolls", "vote"};
        this.category = new Category("Web");
        this.arguments = "\"Title\" {\"Options\"}";
        this.help = "Automatically creates a strawpoll.";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        List<String> args = new ArrayList<String>();
        //Regex for removing spaces
        Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
        Matcher regexMatcher = regex.matcher(e.getMessage().getContentRaw());

        while(regexMatcher.find())
        {
            if (regexMatcher.group(1) != null) {
                // Add double-quoted string
                args.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                // Add single-quoted string
                args.add(regexMatcher.group(2));
            } else {
                // Add unquoted word
                args.add(regexMatcher.group());
            }
        }

        //Ignores the user if they are a bot
        if(!e.getMember().getUser().isBot())
        {
            //Checks argument length
            if(args.size() <= 3)
            {
                e.getChannel().sendMessage("REE");
            }
            else
            {
                e.getChannel().sendMessage(GetStrawPoll(args));
            }
        }
    }

    public static String GetStrawPoll(List<String> args)
    {
        String outputString = "";

        args.remove(0);

        try
        {

            String URLString = "https://strawpoll.me/api/v2/polls";
            URL url = new URL(URLString);

            Map<String,String> arguments = new HashMap<>();

            arguments.put("title", args.get(0));
            //Needs to be ["Option 1", "Option 2" ]

            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < args.size(); i++)
            {
                if(i < args.size() - 1)
                {
                    sb.append(args.get(i) + ", ");
                }
                else
                {
                    sb.append(args.get(i));
                }
            }

            arguments.put("options", sb.toString());

            StringJoiner sj = new StringJoiner("&");
            for(Map.Entry<String,String> entry : arguments.entrySet())
            {
                sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
            }

            System.out.println(sj.toString());

            byte[] postData = sj.toString().getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;

            HttpURLConnection conn= (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);

            DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
            wr.write(postData);

            outputString = wr.toString();
        }
        catch(Exception ex)
        {
            System.out.println("An exception has occured, refer to: " + ex.toString());
        }

        return outputString;
    }
}
