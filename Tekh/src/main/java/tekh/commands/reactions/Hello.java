package tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Hello extends Command
{
    public Hello()
    {
        this.name = "hello";
        this.aliases = new String[]{"hi", "hiya", "hey"};
        this.category = new Category("Reactions");
        this.arguments = "";
        this.help = "Says hello to the user";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        if(!e.getMember().getUser().isBot())
        {
            e.getChannel().sendMessage("Hi! " + e.getMember().getAsMention()).queue();
        }
    }
}
