package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class Party extends ListenerAdapter
{
    private static String PARTY_GIF = "https://media.giphy.com/media/10hO3rDNqqg2Xe/giphy.gif";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Check for prefix (party, partys, parties, partied)
        if(args[0].equalsIgnoreCase(Program.prefix+"party") || args[0].equalsIgnoreCase(Program.prefix+"partys") || args[0].equalsIgnoreCase(Program.prefix+"parties") || args[0].equalsIgnoreCase(Program.prefix+"partied"))
        {
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("It's time to party!");
                if(args.length == 1)
                {
                    embedBuilder.setDescription("Parties with " + e.getMember().getAsMention());
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription("Parties for " + argsString);
                }
                embedBuilder.setColor(new Color(0x9278FF));
                embedBuilder.setImage(PARTY_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }
    }
}
