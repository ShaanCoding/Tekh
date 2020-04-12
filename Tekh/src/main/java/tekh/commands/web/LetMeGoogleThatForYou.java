package tekh.commands.web;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import tekh.Program;

public class LetMeGoogleThatForYou extends Command
{
    public LetMeGoogleThatForYou()
    {
        this.name = "lmgtfy";
        this.aliases = new String[]{"letmegooglethatforyou", "lmgtfys", "letmegooglethatforyous"};
        this.category = new Command.Category("Web");
        this.arguments = "String";
        this.help = "Provides you a \"let me google that for you\" link";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Checks if user is bot
        if(!e.getMember().getUser().isBot())
        {
            if(args.length < 2)
            {
                e.getChannel().sendMessage("**Error:** Command Entered Incorrectly, Please Use **" + Program.configSettings.GetPrefix() + this.name + " " + this.arguments + "**").queue();
            }
            else
            {
                String lmgtfyLink = LMGTFYLinkGenerator(args);
                e.getMessage().getChannel().sendMessage(lmgtfyLink).queue();
                //DO FUNCTION
            }
        }
    }

    private static String LMGTFYLinkGenerator(String[] args)
    {
        String returnString = "https://lmgtfy.com/?q=";

        for(int i = 1; i < args.length; i++)
        {
            if(i < args.length - 1)
            {
                returnString += args[i] + "+";
            }
            else
            {
                returnString += args[i];
            }
        }

        return returnString;
    }
}
