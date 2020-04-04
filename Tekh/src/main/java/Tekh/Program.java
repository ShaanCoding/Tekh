package Tekh;

import Tekh.commands.reactions.*;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Program
{
    public static String tokenKey = "";
    public static String prefix = "";
    public static String botMentionSelf = "";

    public static void main(String[] args) throws Exception
    {
        ConfigSettings configSettings = new ConfigSettings();
        tokenKey = configSettings.GetTokenKey();
        prefix = configSettings.GetPrefix();

        JDA jda = new JDABuilder(AccountType.BOT).setToken(tokenKey).build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB); //STATUS
        jda.getPresence().setActivity(Activity.watching("Boring developers cry")); //GAME ACTIVITY
        jda.setAutoReconnect(true);
        //Find way to get custom activity for bot i.e playing commands
        //jda.getPresence().setActivity(Activity.of(""));
        botMentionSelf = jda.getSelfUser().getAsMention();
        jda.addEventListener(new Cheer(), new Cringe(), new Cries(), new Dance(), new Party(), new Pat(), new Poke(), new Smug(), new PayRespects(), new WhoIsAGoodBoy());

    }

}
