package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Smug extends ListenerAdapter
{
    private static String SMUG_GIF = "https://media1.tenor.com/images/0c3c1c1394c9ab4f455873a4336aa3e6/tenor.gif?itemid=11146587";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Check for prefix (smug, smugs)
        if(args[0].equalsIgnoreCase(Program.prefix+"smug") || args[0].equalsIgnoreCase(Program.prefix+"smugs"))
        {
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("Hehe.");
                if(args.length == 1)
                {
                    embedBuilder.setDescription(e.getMember().getAsMention() + " is looking a bit smug.");
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription(e.getMember().getAsMention() + " looks smugly at " + argsString);
                }
                embedBuilder.setColor(new Color(0x21FFA1));
                embedBuilder.setImage(SMUG_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }
    }
}
