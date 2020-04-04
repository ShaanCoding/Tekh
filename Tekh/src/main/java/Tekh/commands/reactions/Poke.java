package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class Poke extends ListenerAdapter
{
    public static String POKE_GIF = "https://media1.tenor.com/images/3b9cffb5b30236f678fdccf442006a43/tenor.gif?itemid=7739077";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Check for prefix (poke, poked, pokes)
        if(args[0].equalsIgnoreCase(Program.prefix+"poke") || args[0].equalsIgnoreCase(Program.prefix+"pokes") || args[0].equalsIgnoreCase(Program.prefix+"poked"))
        {
            if(!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setTitle("Poke!");
                if(args.length == 1)
                {
                    embedBuilder.setDescription(e.getMember().getAsMention() + " pokes themselves. The silly sod!");
                }
                else
                {
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription(e.getMember().getAsMention() + " pokes " + argsString);
                }
                embedBuilder.setColor(new Color(0xFF002D));
                embedBuilder.setImage(POKE_GIF);
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
        }

    }
}
