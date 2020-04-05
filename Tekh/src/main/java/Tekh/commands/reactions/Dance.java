package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Dance extends Command
{
    private static String DANCING_GIF = "https://media0.giphy.com/media/OkBcLrrPL6LM4/source.gif";

    public Dance()
    {
        this.name = "dance";
        this.aliases = new String[]{"dances", "danced", "dancing"};
        this.category = new Category("Reactions");
        this.arguments = "[String]";
        this.help = "Dances for something or with someone";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

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
