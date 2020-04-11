package tekh.commands.web;

import com.google.gson.Gson;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import tekh.Program;

import java.awt.*;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrbanDictionary extends Command
{
    private static String URBAN_DICTIONARY_THUMBNAIL = "https://apprecs.org/gp/images/app-icons/300/ca/com.urbandictionary.android.jpg";

    public UrbanDictionary()
    {
        this.name = "urbandictionary";
        this.aliases = new String[]{"urbandictionary", "urbandictionaries", "urbandictionarys", "urbandict", "ub", "urban", "ud"};
        this.category = new Category("Web");
        this.arguments = "\"Word Name\"";
        this.help = "Searches and uploads urban dictionary for a specified word.";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        String queryString = "";

        for(int i = 1; i < args.length; i++)
        {
            if(i < args.length - 1)
            {
                queryString += args[i] + " ";
            }
            else
            {
                queryString += args[i];
            }
        }

        String title = queryString;
        queryString = queryString.replace(" ", "%20");

        //Checks if bot or not
        if(!e.getMember().getUser().isBot())
        {
            //Check parameter size
            if(args.length < 2)
            {
                e.getChannel().sendMessage("**Error:** Command Entered Incorrectly, Please Use **" + Program.configSettings.GetPrefix() + this.name + " " + this.arguments + "**").queue();
            }
            else
            {
                String definition = urbanDictionaryQuery(queryString);

                if(!definition.isEmpty())
                {
                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("Urban Dictionary: " + title);
                    embedBuilder.setDescription(definition);
                    embedBuilder.setThumbnail(URBAN_DICTIONARY_THUMBNAIL);
                    embedBuilder.setColor(new Color(0xFF8000));

                    e.getChannel().sendMessage(embedBuilder.build()).queue();
                    embedBuilder.clear();
                }
                else
                {
                    e.getChannel().sendMessage("Sorry! The specified word doesn't exist :c").queue();
                }
            }
        }
    }

    private static String urbanDictionaryQuery(String query)
    {
        String returnString = "";

        try
        {
            URL urbanDictionaryAPIURL = new URL(String.format("https://api.urbandictionary.com/v0/define?term=%s", query));

            InputStreamReader inputStreamReader = new InputStreamReader(urbanDictionaryAPIURL.openStream());
            Gson gson = new Gson();
            UrbanList wordDefinitions = gson.fromJson(inputStreamReader, UrbanList.class);

            if(wordDefinitions.getList().size() > 0)
            {
                returnString = wordDefinitions.getList().get(0).getDefinition();
                returnString = returnString.replace("[", "**").replace("]", "**");
            }
        }
        catch(Exception ex)
        {
            System.out.println("An exception has occured, please refer to: " + ex.toString());
        }

        return returnString;
    }
}

class UrbanList
{
    private ArrayList<Definitions> list;

    public ArrayList<Definitions> getList()
    {
        return list;
    }
}

class Definitions
{
    private String definition;
    private String permalink;
    private int thumbs_up;
    private String[] sounds_urls;
    private String author;
    private String word;
    private int defid;
    private String current_vote;
    private String written_on;
    private String example;
    private int thumbs_down;

    public String getDefinition()
    {
        return definition;
    }

    public String getPermalink()
    {
        return permalink;
    }

    public int getThumbs_up()
    {
        return thumbs_up;
    }

    public String[] getSounds_urls()
    {
        return sounds_urls;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getWord()
    {
        return word;
    }

    public int getDefid()
    {
        return defid;
    }

    public String getCurrent_vote()
    {
        return current_vote;
    }

    public String getWritten_on()
    {
        return written_on;
    }

    public String getExample()
    {
        return example;
    }

    public int getThumbs_down()
    {
        return thumbs_down;
    }
}
