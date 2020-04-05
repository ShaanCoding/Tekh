package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Cries extends Command
{
    private static String CRYING_GIF = "https://i.imgur.com/pls8egF.gif";

    public Cries()
    {
        this.name = "cry";
        this.aliases = new String[]{"cries", "cried"};
        this.category = new Category("Reactions");
        //TODO write proper helpme
        this.help = "Type cry for info TEST";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Ignores if bot
        if(!e.getMember().getUser().isBot())
        {
            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle("Waaaaaa!.");
            if(args.length == 1)
            {
                embedBuilder.setDescription(e.getMember().getAsMention() + " is sad :c");
            }
            else
            {
                String argsString = "";
                for(int i = 1; i < args.length; i++)
                {
                    argsString += args[i] + " ";
                }
                embedBuilder.setDescription(e.getMember().getAsMention() + " is sad about " + argsString);
            }
            embedBuilder.setColor(new Color(0x019fde));
            embedBuilder.setImage(CRYING_GIF);
            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }
    }
}
