package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class Cringe extends ListenerAdapter
{
    private static String CRINGE_GIF = "https://media.giphy.com/media/bAoCxF6jjFQje/giphy.gif";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Check for prefix and command (cringe or cringes)
        if(args[0].equalsIgnoreCase(Program.prefix+"cringe") || args[0].equalsIgnoreCase(Program.prefix+"cringes"))
        {
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("Oh god why, god please why");
                if(args.length == 1)
                {
                    embedBuilder.setDescription("Cringes with " + e.getMember().getAsMention());
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription("Cringes at " + argsString);
                }
                embedBuilder.setColor(new Color(0x8000FF));
                embedBuilder.setImage(CRINGE_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }
    }
}
