package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Cringe extends Command
{
    private static String CRINGE_GIF = "https://media.giphy.com/media/bAoCxF6jjFQje/giphy.gif";

    public Cringe()
    {
        this.name = "cringe";
        this.aliases = new String[]{"cringes", "cringed"};
        this.category = new Category("Reactions");
        //TODO write proper helpme
        this.help = "Type cringe for info TEST";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        if(!e.getMember().getUser().isBot())
        {
            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle("Oh god why, god please why");
            if(args.length == 1)
            {
                embedBuilder.setDescription("Cringes with " + e.getMember().getAsMention());
            }
            else
            {
                String argsString = "";
                for(int i = 1; i < args.length; i++)
                {
                    argsString += args[i] + " ";
                }
                embedBuilder.setDescription("Cringes at " + argsString);
            }
            embedBuilder.setColor(new Color(0x8000FF));
            embedBuilder.setImage(CRINGE_GIF);
            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }
    }
}
