package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.awt.*;

public class Pat extends ListenerAdapter
{
    private static String PAT_GIF = "https://i.makeagif.com/media/6-04-2014/1m4gQJ.gif";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Check for prefix (pat, pats, patted)
        if(args[0].equalsIgnoreCase(Program.prefix+"pat") || args[0].equalsIgnoreCase(Program.prefix+"pats") || args[0].equalsIgnoreCase(Program.prefix+"patted"))
        {
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("Pat pat.");
                if(args.length == 1)
                {
                    embedBuilder.setDescription(Program.botMentionSelf + " pats " + e.getMember().getAsMention());
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription(e.getMember().getAsMention() + " pats " + argsString);
                }
                embedBuilder.setColor(new Color(0xFFA47B));
                embedBuilder.setImage(PAT_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }
    }
}
