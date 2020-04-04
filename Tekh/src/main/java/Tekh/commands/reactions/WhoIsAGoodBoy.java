package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class WhoIsAGoodBoy extends ListenerAdapter
{
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Checks for prefix and command (cheer or cheers)
        if (args[0].equalsIgnoreCase(Program.prefix + "whoisagoodboy"))
        {
            //Ignores bot
            if (!e.getMember().getUser().isBot())
            {
                e.getChannel().sendMessage("I'm a good boy!").queue();;
            }
        }
    }
}
