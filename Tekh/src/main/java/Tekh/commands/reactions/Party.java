package Tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Party extends Command
{
    private static String PARTY_GIF = "https://media.giphy.com/media/10hO3rDNqqg2Xe/giphy.gif";

    public Party()
    {
        this.name = "party";
        this.aliases = new String[]{"partys", "parties", "partied"};
        this.category = new Category("Reactions");
        //TODO write proper helpme
        this.help = "Type party for info TEST";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        if(!e.getMember().getUser().isBot())
        {
            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle("It's time to party!");
            if(args.length == 1)
            {
                embedBuilder.setDescription("Parties with " + e.getMember().getAsMention());
            }
            else
            {
                String argsString = "";
                for(int i = 1; i < args.length; i++)
                {
                    argsString += args[i] + " ";
                }
                embedBuilder.setDescription("Parties for " + argsString);
            }
            embedBuilder.setColor(new Color(0x9278FF));
            embedBuilder.setImage(PARTY_GIF);
            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }
    }
}
