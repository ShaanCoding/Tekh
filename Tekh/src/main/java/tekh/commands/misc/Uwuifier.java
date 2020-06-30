package tekh.commands.misc;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.sun.imageio.spi.InputStreamImageInputStreamSpi;
import tekh.Program;

import java.util.Random;

public class Uwuifier extends Command
{
    public enum UwuEnum
    {
        Low,
        Medium,
        High
    }

    public Uwuifier()
    {
        this.name = "uwuify";
        this.aliases = new String[]{"uwu", "uwuifier"};
        this.category = new Category("Misc");
        this.arguments = "[Low, Medium, High] \"<String>\"";
        this.help = "Shows the bots current up-time and ping";
    }

    @Override
    protected void execute(CommandEvent e)
    {
        String[] args = e.getMessage().getContentRaw().split("\\s+");
        if(!e.getMember().getUser().isBot())
        {
            if(args.length == 1)
            {
                e.getChannel().sendMessage("**Error:** Command Entered Incorrectly, Please Use **" + Program.configSettings.GetPrefix() + this.name + " " + this.arguments + "**").queue();
            }
            else
            {
                UwuEnum uwuLevel;
                switch(args[1].toLowerCase())
                {
                    case "high":
                        uwuLevel = UwuEnum.High;
                        break;
                    case "medium":
                        uwuLevel = UwuEnum.Medium;
                        break;
                    case "low":
                        uwuLevel = UwuEnum.Low;
                        break;
                    default:
                        uwuLevel = UwuEnum.Medium;
                        break;
                }

                String inputString = "";
                for(int i = 2; i < args.length; i++)
                {
                    if(i != args.length - 1)
                    {
                        inputString += args[i] + " ";
                    }
                    else
                    {
                        inputString += args[i];
                    }
                }

                String returnString = ConvertToUwu(inputString, uwuLevel);
                e.getChannel().sendMessage(returnString).queue();
            }
        }
    }

    public String ConvertToUwu(String inputString, UwuEnum uwuLevel)
    {
        inputString = inputString.replaceAll("(?:R|L)", "W");
        inputString = inputString.replaceAll("(?:r|l)", "w");

        if(uwuLevel == UwuEnum.Medium || uwuLevel == UwuEnum.High)
        {
            inputString = inputString.replaceAll("n([aeiou])", "ny$1");
            inputString.replaceAll("N([aeiou])", "Ny$1");
            inputString.replaceAll("N([AEIOU])", "NY$1");
            inputString.replaceAll("z ", "z~ ");
        }

        if(uwuLevel == UwuEnum.High)
        {
            inputString = inputString.replaceAll("OVE", "UV");
            inputString = inputString.replaceAll("ove", "uv");

            Random random = new Random();

            String[] faces = {
                    " (o´∀`o)", " (#｀ε´)", " (๑•̀ㅁ•́๑)✧", " (*≧m≦*)", " (・`ω´・)", " UwU", " OwO", " >w<", " ｡ﾟ( ﾟ^∀^ﾟ)ﾟ｡"," ヾ(｀ε´)ﾉ",
                    " (´• ω •`)"," o(>ω<)o"," (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧", " (⁀ᗢ⁀)", " (￣ε￣＠)", " ( 〃▽〃)", " (o^ ^o)", " ヾ(*'▽'*)"
            };

            inputString = inputString.replaceAll("!", faces[random.nextInt(faces.length)]);

            inputString = inputString
                    .replace("nyzzwes", "nuzzles~")
                    .replace("ahh", "murr")
                    .replace("awesome", "pawsome")
                    .replace("awfuw", "pawful")
                    .replace("bite", "nom")
                    .replace("buwge", "bulgy-wulgy")
                    .replace("butthowe", "tailhole")
                    .replace("cewebwity", "popufur")
                    .replace("cheese", "sergal")
                    .replace("chiwd", "cub")
                    .replace("computew", "protogen")
                    .replace("wobot", "protogen")
                    .replace("cybowg", "protogen")
                    .replace("cum", "cummy wummy~")
                    .replace("disease", "pathOwOgen")
                    .replace("dog", "good boy")
                    .replace("dwagon", "derg")
                    .replace("eat", "vore")
                    .replace("fuck", "fluff")
                    .replace("fathew", "daddy")
                    .replace("foot", "footpaw")
                    .replace("fow", "fur")
                    .replace("hand", "paw")
                    .replace("heww", "hecc")
                    .replace("hyenya", "yeen")
                    .replace("kiss", "lick")
                    .replace("wmao", "hehe~")
                    .replace("mouth", "maw")
                    .replace("nyaughty", "knotty")
                    .replace("nyot", "knot")
                    .replace("pewfect", "purrfect")
                    .replace("pewsona", "fursona")
                    .replace("pewvewt", "furvert")
                    .replace("pown", "yiff")
                    .replace("shout", "awoo")
                    .replace("swut", "fox")
                    .replace("souwce", "saunce")
                    .replace("stwaight", "gay")
                    .replace("tawe", "tail")
                    .replace("the", "teh")
                    .replace("this", "dis")
                    .replace("toe", "toe been")
                    .replace("with", "wif")
                    .replace("you", "chu")
                    .replace("youw", "ur")
                    .replace(",", "~")
                    .replace(";", "~")
                    .replace(":)", ":3")
                    .replace(":O", "OwO")
                    .replace(":o", "owo")
                    .replace(":D", "UwU")
                    .replace("XD", "X3")
                    .replace("xD", "x3")
                    .replace("?", " uwu?");
        }

        return inputString;
    }
}
