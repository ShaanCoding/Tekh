package tekh.commands.misc;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import tekh.Program;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Statistics extends Command
{
    public Statistics()
    {
        this.name = "stats";
        this.aliases = new String[]{"statistics", "stat", "statistic"};
        this.category = new Category("General");
        this.arguments = "";
        this.help = "Shows the bots current up-time and ping";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        if(!e.getMember().getUser().isBot())
        {
            RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
            long uptime = rb.getUptime();
            long seconds = uptime / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            String time = days + " Days " + hours % 24 + " Hours " + minutes % 60 + " Minutes " + seconds % 60 + " Seconds";

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Statistics:");
            embedBuilder.setDescription("**Status: **Online\n**Up-time: **" + time + "\n**Ping: **" + e.getMember().getJDA().getGatewayPing() + " ms");
            embedBuilder.setColor(new Color(0xadd8e6));

            e.getChannel().sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }
    }
}
