package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Pat extends Command
{
    private static String PAT_GIF = "https://i.makeagif.com/media/6-04-2014/1m4gQJ.gif";

    public Pat()
    {
        this.name = "pat";
        this.aliases = new String[]{"pats", "patted", "patting"};
        this.category = new Category("Reactions");
        this.arguments = "[String]";
        this.help = "Pats something or someone";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        if(!e.getMember().getUser().isBot())
        {
            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle("Pat pat.");
            if(args.length == 1)
            {
                embedBuilder.setDescription(e.getSelfUser().getAsMention() + " pats " + e.getMember().getAsMention());
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
