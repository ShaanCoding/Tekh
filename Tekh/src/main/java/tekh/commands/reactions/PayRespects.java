package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class PayRespects extends Command
{
    private static String PAYRESPECT_GIF = "https://media1.tenor.com/images/4897527e0f678cc6876bafb02f2d8ba8/tenor.gif?itemid=5372255";

    public PayRespects()
    {
        this.name = "f";
        this.aliases = new String[]{"payrespect", "payrespects"};
        this.category = new Category("Reactions");
        this.arguments = "[String]";
        this.help = "Pays respect to something or to someone";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

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
