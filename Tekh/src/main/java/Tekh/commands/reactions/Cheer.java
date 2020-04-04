package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Cheer extends ListenerAdapter
{
    private static String CHEER_GIF = "https://media2.giphy.com/media/l3V0wkQ2KKcAeW8Cs/giphy.gif";

    //args[].equalsIgnoreCase = prefix + command
    // e.getMember().getUser().isBot() // MUST IGNORE BOT
    //Embed builder function
    //set title, description, color, footer, send message then clear it
    //Split into args
    //e.getChannel().sendMessage().queue() QUEUE message looks like it is typing + async

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Checks for prefix and command (cheer or cheers)
        if (args[0].equalsIgnoreCase(Program.prefix + "cheer") || args[0].equalsIgnoreCase(Program.prefix + "cheers"))
        {
            //Ignores bot
            if (!e.getMember().getUser().isBot())
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();

                if(args.length == 1)
                {
                    embedBuilder.setTitle("It's a cause for celebration!");
                    embedBuilder.setDescription("Cheers with " + e.getMember().getAsMention());
                    embedBuilder.setColor(new Color(0xFF80FF));
                    embedBuilder.setImage(CHEER_GIF);
                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                    embedBuilder.clear();
                }
                else
                {
                    embedBuilder.setTitle("It's a cause for celebration!");
                    String argsString = "";
                    for(int i = 1; i < args.length; i++)
                    {
                        argsString += args[i] + " ";
                    }
                    embedBuilder.setDescription("Cheers for " + argsString);
                    embedBuilder.setColor(new Color(0xFF80FF));
                    embedBuilder.setImage(CHEER_GIF);
                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                    embedBuilder.clear();
                }
            }
        }
    }
}
