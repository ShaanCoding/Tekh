package Tekh.commands.misc;

import Tekh.Program;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Donate extends Command
{
    public Donate()
    {
        this.name = "donate";
        this.aliases = new String[]{"donates", "donated", "donating"};
        this.category = new Command.Category("General");
        this.arguments = "";
        this.help = "Shows where and how to donate to Tekh to keep the bot running";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        if(!e.getMember().getUser().isBot())
        {
            e.getTextChannel().sendMessage("Tekh is a fully free public discord bot.\n" +
                    "Without donations this bot may go down once I run out of my paid server hosting.\n" +
                    "To keep Tekh up please donate at: " + Program.configSettings.GetWebsite()).queue();
        }
    }
}
