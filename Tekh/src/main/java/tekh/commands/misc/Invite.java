package tekh.commands.misc;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Invite extends Command
{
    public Invite()
    {
        this.name = "invite";
        this.aliases = new String[]{"invites", "invited", "inviting"};
        this.category = new Category("Misc");
        this.arguments = "";
        this.help = "Creates an instant invite link lasting 5 minutes, remember to invite your friends!";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        int timeInt = 3600; //Invite expires in 1 hour
        //Ignores bot
        if(!e.getMember().getUser().isBot())
        {
            e.getChannel().sendMessage("Want to invite a member? Cool!\nGive them this link: " + e.getTextChannel().createInvite().setMaxAge(timeInt).complete().getUrl()).queue();
        }
    }
}
