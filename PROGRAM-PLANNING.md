# Discord Bot - Tekhs

## Preface

This program is a discord bot designed for the UTS FEIT discord server for students of UTS. The aim of this discord bot is to provide administrative tasks as well as provide a better quality of life of people using the UTS FEIT discord server by enhancing their experience through a list of commands either; automating or simplifying pre-existing discord lobbies or conversations.

## Features List

- Add the possibility of automatically recording discord share screens in lobbies for remote lectures

- Some music bot features such as listening to voice when the 'Hey Tekhs' command is given allowing people to remotely queue songs or adjust volume whilst in game without the requirement of typing

- Additional administrative features such as purge

- Other general bot commands

- Plugins as Alex suggested?

## Stack List

- SQL Lite

- FFMPEG (For Music Bot?)

- Google Cloud - Text to speech API

- [https://github.com/DV8FromTheWorld/JDA](Discord Java Wrapper)

## Discord Bots Basic Feature List

### General Idea

- Make this as a web-app menu for configuration (maybe and contain the majority of these functions as "plugins" allowing people to enable or disable features as they wish)

### Administrative Functions

> Embed builder - create a discord embedded message with custom text and colour, we have thought of a way of doing this but not too sure.
> 
> - Embeded builder will have to be reviewed
> 
> - How will input be structured maybe some sort of markup / markdown?



> '<JOIN MESSAGE>' This function automatically sends a message to the main lobby of the discord server upon joining. It says '<Tekh>' has joined with a custom joining message in addition with some information regarding the bot.



> Also auto-moderations to - mute, kick and ban after violation of rules.
> 
>  
> 
> This needs to be worked on!.



> !readRules '<bool>' | This command locks the chat until rules are accepted. There is an emoji with a checkbox sent required to be clicked in order to allow the user to access all the "default channels" of the server".



> !welcomeMessage '<bool>' '<string>' | If enabled this command sets out a custom welcome message in a custom generated image which is uploaded to the "joined messages chat". This will upload a custom image welcoming the user to the server with their profile picture, name and the custom welcome message.



> !rules '<int>' | displays the specified quotued rule number rule.



> !mute '<string>' '<time>' '<seconds || minutes || hours || days>' | This command temporarily mutes the user for a set amount of time preventing them from writing messages in any chat until they have time to "cool off".



> !kick '<string>' | This kicks the user from the discord server whilst also privately messaging them from the bot with the reason of why they've been kicked. It also writes in chat that they've been kicked.



> !ban | This bans the user from the discord server whilst also privately messaging them from the bot with the reason of why they've been kicked. It also writes in chat that they've been banned.
> 
> * This is done in order to prevent rogue admins from mass pruning servers with a one day activity limit, by preventing users from having admin rules and only the bot it prevents people from getting mass pruned without adequite permission
> 
> 

> !imageLock '<boolean>' | This locks a channel to images only.



> !textLock '<boolean>' | This locks a channel to text only.



> !purge  ('<all>'|'<number>') || ('<user>' ('<string>' || '<all>' || '<number>')) | This purges X amount of messages from a user or the entire chat.



> !botNick '<string>' | This changes the bots nickname, if you wanted this for some reason.



> !prefix '<string>' | This changes the bots prefix, from default "!" to a user specified string



> !autorole '<string>' | This automatically sets the role of users who join the discord server to '<string>'.



>  !recolorRole | Automatically recolors a role from one color to another.



> !goodbye '<boolean>' ['<string>'] | This enables or disables goodbye messages in addition to setting the message to '<string>'.



> !reactAssign '<add|post>' ['<string>' '<string>' ['<string>']]| This creates a react based role assignment post, where users can react with specific reactions to get a rank. This takes in the emoji string, the rank string and then an optional rank description string. 
> 
> * Perhaps have a way to split this across multiple channels such as #compsci-subjects #engineering-subjects with a quick link to the hidden lobby?
> 
> 

> !blackList '<string>' | Has the ability to blackList members from the bot, preventing spam, abuse or just annoying people from using the bot.



> !botChannel '<add|remove>' '<String>' | Adds or removes the ability for the bot to accept commands from that specific discord channel.



> !starBoard '<bool>' ['<string>'] | Adds the ability to enable or disable a starboard channel where when people who react with stars to a post, if the post exceeds 5 stars the post will be added to the starboard.



> !autoPrune '<boolean>' | Adds the ability to automatically prune discord the discord server periodically every 24 hours removing inactive users from the server.



> !disable '<string>' | Disables a class of the bot for the server.



> !enable '<string>' | Enables a class of the bot for the server.



### Voice Features

#### Voice Commands

> "Ignore me" - sends bot back to sleep.



> "Move" - any sentence will trigger movement, such as username or "me", "myself", "everyone" or "lobby" and channel name such as "this channel", "my channel", "our channel" or "here" or "Channel name".



> Play "" - either through !play or through text-to-speech api making a call itself.



> Volume
> 
> - "Increase" "up" "raise" will increase volume
> 
> - "Decrease" "down" "lower" will lower volume
> 
> - Including a number to volume will set volume of bot specifically
>   
>   - "turn the volume up"
>   
>   - "lower volume by 30"
>   
>   - "turn volume to 20"
>   
>   - Pause / stop
>   
>   - Resume / unpause
>   
>   - Skip
>   
>   - Summon

#### Music Bot

> Music from; Youtube, Soundcloud, Twitch and possibly Spotify?



> !summon | Summons the bot to your lobby.



> !move '<string>' {'<string>'} | Moves everyone in voice chat to another channel OR moves yourself to another channel. Specify the channel you wish everyone to move to and/or the group you wish to target the move to.



> !tts '<string>' | Makes the bot say text-to-speech words in voice chat, using googles WazeNet.



### Programming Documentation & Functions

> !docs '<string>' '<string>' | Search manual pages of; python doc, java doc etc for specific entry, in addition can also search stackoverflow for questions. The format of this is '<document type i.e javadocs, stackoverflow etc>' then '<query>'



> !beautify '<string>' | Detects and turns code into a nice readable format, it should allow plain text code to be input with beautifier and then will format it with indents and display it as a discord block with the specified language.
> 
> * It should in additional automatically delete the users message BUT include the name of the user who submitted it.



> !snippet '<string>' | Makes a database of snippets, when a snippet is requested paste it to chat, there is some intrested menu capabilities here allowing for displaying and navigating all snippets.

### Maths Tookit

> !latex '<string>' | Gives the ability to write LaTeX equations in discord with the bot formatting and uploading it.

### Image Generator Commands

> !showMeme | Displays a random meme.
> 
> * I've done webscraping quite a few times and have a /r/ProgrammingHumor meme scraping and reuploading to instagram bot - perhaps we can use that if needed (not finished though).



> !deepfry | Deepfries the users profile image.



### RPG Games & Gambling

#### Gambling

> !farmCoin | Allows the user to farm coin to gain a virtual currency (it just generates a random int).



> !betCoin '<int>' | Allows the user to bet coin with a 50-50 chance to double it or lose everything.



> !setCoin ['<string>'] '<int>' | Allows administrators to set a coin amount to a user or themselves.



> !payCoin '<string>' '<int>' | Allows users to give other people coins from their own wallet.



> !walletCoin | Allows the user to see how much coin they currently own.



> !hideCoin '<bool>' | Allows admins to set so that messages involving coin are automatically deleted (excluding the bots message).



> !dice '<int>' '<int>' | Allows the player to bet on the roll of a dice, input numbers between 1-6 in the first one and the bet in the second.



> !slots '<int>'  | Allows the players to play a round of slots.



#### RPG Games

> !rate '<string>' | The bot automatically rates '<string>' from 1 to 10.



> !8ball '<string>' | The ball automatically responds to '<string>' with a random 8ball response



> !rps '<string>' | Allows the player to play a match of rock paper scissors against the AI



> !choose '<string>' '<string>' | Makes the bot choose between two random options for the user.



### Profiles

* Have levels?

* Can use real money to customize the appearance of cards - become EA?

* Avatar - grabs avatar of user you mention

* Profiles
  
  - Background - allows you to edit your profile background image
  
  - bio - allows you to change bio
  
  - profile - shows your profile
  
  - rep - gives rep to other members

### Reactions

Reaction:

- Cheer - cheers for something

- cringe - cringes

- cry - sends crying reaction

- dance - dances

- party -parties

- part - pats the user you tag or mention

- poke - pokes username

- smug sends smug reaction

- f - pay respects

- hello - bascially a ping

- kill - alllows you to kill someone

### Google / Web Stuff

* Conduct polls (strawpoll)

* Urban dictionary definition snippet

* Google - sends let me google that for you link

* crypto - returns price of crypto

* stocks - find stock info

* tldr - creates tldr for article

### Counting Bot

- Counting bot - create a channel with name #counting
  
  - One person can't count two numbers in a row
  
  - Will delete message if doesn't start with number
  
  - Top: shows top user

### Ease Of Life

- invite command - type !invite to get an instant invite to the server

- Say - "Repeats back to you what ever comes after say"

- "Whose a good boy" - confirms bot is a good boy

- uwuify - owos a text, lets not add this

- inspire - generates a random terrible inspirational quotue

- Todo - add things to do list

- Remind me - allows you to set a reminder and gives link (will give dm)

- Award members

- Dank memer bot

- Bonfire style discord help menu, can see category ith emojis to scroll through pages of commands with it just editing itself

- Commands - lists all commands

- Donate - helps hosting and unlocks features
* Shards - returns info on shards

* Stats - returns stats about bot



![](C:\Users\shaan\AppData\Roaming\marktext\images\2020-03-31-20-48-52-image.png)

![](C:\Users\shaan\AppData\Roaming\marktext\images\2020-03-31-20-49-00-image.png)

![](C:\Users\shaan\AppData\Roaming\marktext\images\2020-03-31-20-49-09-image.png)
