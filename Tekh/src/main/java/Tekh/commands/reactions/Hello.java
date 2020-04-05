package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Hello extends Command
{
    public Hello()
    {
        this.name = "hello";
        this.aliases = new String[]{"hi", "hiya", "hey"};
        this.category = new Category("Reactions");
        //TODO write proper helpme
        this.help = "Type hello for info TEST";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        if(!e.getMember().getUser().isBot())
        {
            e.getChannel().sendMessage("Hi! " + e.getMember().getAsMention()).queue();
        }
    }
}
