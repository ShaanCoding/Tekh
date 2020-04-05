package tekh.commands.reactions;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import java.awt.*;

public class Poke extends Command
{
    public static String POKE_GIF = "https://media1.tenor.com/images/3b9cffb5b30236f678fdccf442006a43/tenor.gif?itemid=7739077";

    public Poke()
    {
        this.name = "poke";
        this.aliases = new String[]{"pokes", "poked"};
        this.category = new Category("Reactions");
        this.arguments = "[String]";
        this.help = "Pokes something or someone";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

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
