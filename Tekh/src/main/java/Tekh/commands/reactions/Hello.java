package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Hello extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Takes input of (hello, hi, hiya, hey)
        if(args[0].equalsIgnoreCase(Program.prefix+"hello") || args[0].equalsIgnoreCase(Program.prefix+"hi") || args[0].equalsIgnoreCase(Program.prefix+"hiya") || args[0].equalsIgnoreCase(Program.prefix+"hey"))
        {
            if(!e.getMember().getUser().isBot())
            {
                e.getChannel().sendMessage("Hi! " + e.getMember().getAsMention()).queue();
            }
        }
    }
}
