package tekh;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Help extends Command
{
    public Help()
    {
        this.name = "help";
        this.aliases = new String[]{"helps", "commands", "command"};
        this.category = new Category("General");
        this.arguments = "[Command]";
        this.help = "Help works by showing you all the commands available or if a specific command is selected it will show you information on that command";
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
                embedBuilder.setDescription(formatHelpNoArgs(e));
                embedBuilder.setColor(new Color(0x7115FF));
                e.getChannel().sendMessage(embedBuilder.build()).queue();
                embedBuilder.clear();
            }
            else
            {
                boolean isCommandFound = false;
                for (int i = 0; i < e.getClient().getCommands().size(); i++)
                {
                    //Check if command exists
                    List<String> aliasArray = Arrays.asList(e.getClient().getCommands().get(i).getAliases().clone());
                    if(args[1].equalsIgnoreCase(e.getClient().getCommands().get(i).getName()) || aliasArray.contains(args[1].toLowerCase()))
                    {
                        //If isn't admin command and isn't owner ID skips
                        if (!e.getClient().getCommands().get(i).isOwnerCommand() || e.getAuthor().getId().equals(e.getClient().getOwnerId()))
                        {
                            isCommandFound = true;

                            StringBuilder builder = new StringBuilder();
                          builder.append("\n**").append(e.getClient().getPrefix()).append(e.getClient().getCommands().get(i).getName())
                            .append(e.getClient().getCommands().get(i).getArguments()==null ? "**" : " "+e.getClient().getCommands().get(i).getArguments()+"**")
                            .append(" - ").append(e.getClient().getCommands().get(i).getHelp());

                          e.getChannel().sendMessage(builder).queue();
                        }
                        break;
                    }
                }

                if(isCommandFound == false)
                {
                    e.getTextChannel().sendMessage("This command could not be found.").queue();
                }
            }
        }

    }

    private static String formatHelpNoArgs(CommandEvent e)
    {
        StringBuilder builder = new StringBuilder("Below you can see all the commands I know.\nIf you need further help with something join our [Support Server](" + Program.configSettings.GetServerInvite() + ").\n\n**Have a nice day!**\n");
        Command.Category category = null;

        for(int i = 0; i < e.getClient().getCommands().size(); i++)
        {
            //If isn't admin command and isn't owner ID skips
            if(!e.getClient().getCommands().get(i).isOwnerCommand() || e.getAuthor().getId().equals(e.getClient().getOwnerId()))
            {
                //Displays new category if exists
                if(!Objects.equals(category, e.getClient().getCommands().get(i).getCategory()))
                {
                    category = e.getClient().getCommands().get(i).getCategory();
                    builder.append("\n\n  **").append(category==null ? "No Category" : category.getName()).append(":**\n");
                }

                if(i < e.getClient().getCommands().size() - 1)
                {
                    builder.append("``" + e.getClient().getCommands().get(i).getName() + "``").append(Objects.equals(category, e.getClient().getCommands().get(i).getCategory()) ? ", " : "");
                }
                else
                {
                    builder.append("``" + e.getClient().getCommands().get(i).getName() + "``");
                }
            }
        }

        builder.append("\n\nDo not include <>, [] or {} - <> means required, [] means optional and {} means optional looped."
                + "\n\n**Useful Links**\n[Invite Me](" + Program.configSettings.GetOAuthLink() + ") [Support Server]("
                + Program.configSettings.GetServerInvite() + ") [Website](" + Program.configSettings.GetWebsite() + ")");
        return builder.toString();
    }
}
