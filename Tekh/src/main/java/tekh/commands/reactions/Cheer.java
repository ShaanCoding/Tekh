package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Cheer extends Command
{
    private static String CHEER_GIF = "https://media2.giphy.com/media/l3V0wkQ2KKcAeW8Cs/giphy.gif";

    //args[].equalsIgnoreCase = prefix + command
    // e.getMember().getUser().isBot() // MUST IGNORE BOT
    //Embed builder function
    //set title, description, color, footer, send message then clear it
    //Split into args
    //e.getChannel().sendMessage().queue() QUEUE message looks like it is typing + async

    public Cheer()
    {
        this.name = "cheer";
        this.aliases = new String[]{"cheers"};
        this.category = new Category("Reactions");
        this.arguments = "[String]";
        this.help = "Cheers for something or for someone";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
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
