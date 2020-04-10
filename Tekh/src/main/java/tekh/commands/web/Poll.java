package tekh.commands.web;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import sun.security.krb5.Config;
import tekh.Program;

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
                e.getChannel().sendMessage("**Error:** Command Entered Incorrectly, Please Use **" + Program.configSettings.GetPrefix() + this.name + " " + this.arguments + "**").queue();
            }
            else
            {
                e.getChannel().sendMessage(GetStrawPoll(args)).queue();
            }
        }
    }

    private static String GetStrawPoll(List<String> args)
    {
        String title = args.get(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < args.size(); i++)
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

        System.out.println(title);
        System.out.println(sb.toString());
        StrawPollWrapper strawPoll = new StrawPollWrapper(title, sb.toString());
        strawPoll.create();
        return "**StrawPoll Created:** " + strawPoll.getPollURL();
    }
}
