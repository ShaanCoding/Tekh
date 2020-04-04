package Tekh.commands.reactions;

import Tekh.Program;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class PayRespects extends ListenerAdapter
{
    private static String PAYRESPECT_GIF = "https://em.wattpad.com/d08004d2758fdac363434a22e55e0321ec83dda7/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f776174747061642d6d656469612d736572766963652f53746f7279496d6167652f7850706f532d70777830576a56513d3d2d3231333037353831332e313433323230346139363534396363392e676966?s=fit&w=1280&h=1280";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Checks if command is (f, payrespect, payrespects)
        if(args[0].equalsIgnoreCase(Program.prefix+"f") || args[0].equalsIgnoreCase(Program.prefix+"payrespect") || args[0].equalsIgnoreCase(Program.prefix+"payrespects"))
        {
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
}
