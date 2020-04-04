package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class Cries extends ListenerAdapter
{
    private static String CRYING_GIF = "https://i.imgur.com/pls8egF.gif";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Check for prefix and command (cry or cries or cried)
        if(args[0].equalsIgnoreCase(Program.prefix+"cry") || args[0].equalsIgnoreCase(Program.prefix+"crys") || args[0].equalsIgnoreCase(Program.prefix+"cries") || args[0].equalsIgnoreCase(Program.prefix+"cried") || args[0].equalsIgnoreCase(Program.prefix+"crying"))
        {
            //Ignores if bot
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("This is so sad.");
                if(args.length == 1)
                {
                    embedBuilder.setDescription("Cries with " + e.getMember().getAsMention());
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription("Cries for " + argsString);
                }
                embedBuilder.setColor(new Color(0x019fde));
                embedBuilder.setImage(CRYING_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }
    }
}
