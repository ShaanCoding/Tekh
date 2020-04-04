package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class PayRespects extends ListenerAdapter
{
    private static String PAYRESPECT_GIF = "https://media1.tenor.com/images/4897527e0f678cc6876bafb02f2d8ba8/tenor.gif?itemid=5372255";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Checks if command is (f, payrespect, payrespects)
        if(args[0].equalsIgnoreCase(Program.prefix+"f") || args[0].equalsIgnoreCase(Program.prefix+"payrespect") || args[0].equalsIgnoreCase(Program.prefix+"payrespects"))
        {
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("Rest in peace");
                if(args.length == 1)
                {
                    embedBuilder.setDescription(e.getMember().getAsMention() + " pays respects.");
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription(e.getMember().getAsMention() + " pays respect to " + argsString);
                }
                embedBuilder.setColor(new Color(0x878989));
                embedBuilder.setImage(PAYRESPECT_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }
    }
}
