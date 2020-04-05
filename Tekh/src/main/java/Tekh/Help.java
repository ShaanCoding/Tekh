package Tekh;

import Tekh.commands.reactions.Cheer;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Objects;

public class Help extends Command
{
    public Help()
    {
        this.name = "help";
        this.aliases = new String[]{"helps", "commands", "command"};
        //TODO write proper helpme
        this.help = "Type HELP for info TEST";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");

        //Checks it isn't bot to prevent inf loop
        if(!e.getMember().getUser().isBot())
        {
            if(args.length == 1)
            {
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setTitle(Program.EMOJI_GLOBAL + " Hello I'm " + e.getSelfUser().getName() + "!");
                embedBuilder.setDescription(formatHelp(e));
                embedBuilder.setColor(new Color(0x7115FF));
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
            else
            {
                //LOOK FOR COMMANDS TODO

            }

        }
    }

    public static String formatHelp(CommandEvent e)
    {
        StringBuilder builder = new StringBuilder("Below you can see all the commands I know.\nIf you need further help with something join our [Support Server](" + Program.configSettings.GetServerInvite() + ").\n\n**Have a nice day!**\n");
        Command.Category category = null;
        for(Command command : e.getClient().getCommands())
        {
            if(!command.isOwnerCommand() || e.getAuthor().getId().equals(e.getClient().getOwnerId()))
            {
                if(!Objects.equals(category, command.getCategory()))
                {
                    category = command.getCategory();
                    builder.append("\n\n  __").append(category==null ? "No Category" : category.getName()).append("__:\n");
                }
                builder.append("\n**").append(e.getClient().getPrefix()).append(command.getName())
                        .append(command.getArguments()==null ? "**" : " "+command.getArguments()+"**")
                        .append(" - ").append(command.getHelp());
            }
        }

        builder.append("\n\nDo not include <>, [] or {} - <> means required, [] means optional and {} means optional looped."
                + "\n\n**Useful Links**\n[Invite Me](" + Program.configSettings.GetOAuthLink() + ") [Support Server]("
                + Program.configSettings.GetServerInvite() + ") [Website](" + Program.configSettings.GetWebsite() + ")");
        return builder.toString();
    }
}
