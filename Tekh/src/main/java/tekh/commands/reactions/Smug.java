package tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Smug extends Command
{
    private static String SMUG_GIF = "https://media1.tenor.com/images/0c3c1c1394c9ab4f455873a4336aa3e6/tenor.gif?itemid=11146587";

    public Smug()
    {
        this.name = "smug";
        this.aliases = new String[]{"smugs"};
        this.category = new Category("Reactions");
        this.arguments = "[String]";
        this.help = "Acts smugly to something or to someone";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        if(!e.getMember().getUser().isBot())
        {
            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle("Hehe.");
            if(args.length == 1)
            {
                embedBuilder.setDescription(e.getMember().getAsMention() + " is looking a bit smug.");
            }
            else
            {
                String argsString = "";
                for(int i = 1; i < args.length; i++)
                {
                    argsString += args[i] + " ";
                }
                embedBuilder.setDescription(e.getMember().getAsMention() + " looks smugly at " + argsString);
            }
            embedBuilder.setColor(new Color(0x21FFA1));
            embedBuilder.setImage(SMUG_GIF);
            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }
    }
}
