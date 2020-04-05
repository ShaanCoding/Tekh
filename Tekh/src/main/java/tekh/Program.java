package tekh;

import tekh.commands.misc.Donate;
import tekh.commands.misc.InspiroBot;
import tekh.commands.misc.Invite;
import tekh.commands.reactions.*;

import com.jagrosh.jdautilities.command.CommandClient;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

public class Program
{
    public static ConfigSettings configSettings = new ConfigSettings();
    public static JDA jda;

    public static String EMOJI_GLOBAL = ":comet:";

    public static void main(String[] args) throws Exception
    {
        jda = new JDABuilder(AccountType.BOT).setToken(configSettings.GetTokenKey()).build();
        jda.setAutoReconnect(true);

        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("Type !help | http://github.com/ShaanCoding/Tekh"));
        builder.setOwnerId(configSettings.GetOwnerID());
        builder.setPrefix(configSettings.GetPrefix());

        //Sets help command to custom command (uses lambda, only type of expression I could find)
        // m = message, s, f = success and failure success continues, failure replys with warning
        builder.useHelpBuilder(false);

        builder.addCommand(new Help());

        builder.addCommands(
                new Cheer(),
                new Cringe(),
                new Cries(),
                new Dance(),
                new Party(),
                new Pat(),
                new Poke(),
                new Smug(),
                new PayRespects(),
                new Hello(),
                new WhoIsAGoodBoy());

        builder.addCommands(
                new Invite(),
                new InspiroBot(),
                new Donate());

        CommandClient client = builder.build();
        jda.addEventListener(client);
    }
}
