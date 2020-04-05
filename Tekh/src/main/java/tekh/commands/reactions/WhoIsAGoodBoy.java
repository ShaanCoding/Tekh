package tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class WhoIsAGoodBoy extends Command
{
    public WhoIsAGoodBoy()
    {
        this.name = "whoisagoodboy";
        this.aliases = new String[]{"goodboy", "wiagb"};
        this.category = new Category("Reactions");
        this.arguments = "";
        this.help = "Confirms that the bot is a good boy";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Ignores bot
        if (!e.getMember().getUser().isBot())
        {
            e.getChannel().sendMessage("I'm a good boy!").queue();
        }
    }
}
