package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class Dance extends ListenerAdapter
{
    private static String DANCING_GIF = "https://media0.giphy.com/media/OkBcLrrPL6LM4/source.gif";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Check for prefix and command (dance, dances, danced)
        if(args[0].equalsIgnoreCase(Program.prefix+"dance") || args[0].equalsIgnoreCase(Program.prefix+"dances") || args[0].equalsIgnoreCase(Program.prefix+"danced"))
        {
            //Ignores if bot
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("It's time to dance!");
                if(args.length == 1)
                {
                    embedBuilder.setDescription(e.getMember().getAsMention() + " starts dancing");
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription(e.getMember().getAsMention() + " starts dancing for " + argsString);
                }
                embedBuilder.setColor(new Color(0xEB5146));
                embedBuilder.setImage(DANCING_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }
    }
}
