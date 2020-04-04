# Discord Bot - Tekhs

## Preface

This program is a discord bot designed for the UTS FEIT discord server for students of UTS. The aim of this discord bot is to provide administrative tasks as well as provide a better quality of life of people using the UTS FEIT discord server by enhancing their experience through a list of commands either; automating or simplifying pre-existing discord lobbies or conversations.

## Features List

- Add the possibility of automatically recording discord share screens in lobbies for remote lectures

- Some music bot features such as listening to voice when the 'Hey Tekhs' command is given allowing people to remotely queue songs or adjust volume whilst in game without the requirement of typing

- Additional administrative features such as purge

- Other general bot commands

- Plugins as Alex suggested?

- Anonymous Rants - Let members pm the bot directly and the bot will relay that msg in the `#rant` channel

## Stack List/specification

- Oracle JDK 11
- SQL Lite
- FFMPEG (For Music Bot?)
- Google Cloud - Text to speech API
- [Discord Java Wrapper](https://github.com/DV8FromTheWorld/JDA)

## Discord Bots Basic Feature List

### General Idea

- Make this as a web-app menu for configuration (maybe and contain the majority of these functions as "plugins" allowing people to enable or disable features as they wish)

### Administrative Functions

> Embed builder - create a discord embedded message with custom text and colour, we have thought of a way of doing this but not too sure.
> 
> - Embeded builder will have to be reviewed
> 
> - How will input be structured maybe some sort of markup / markdown?

> `<JOIN MESSAGE>` This function automatically sends a message to the main lobby of the discord server upon joining. It says `<Tekh>` has joined with a custom joining message in addition with some information regarding the bot.

> Also auto-moderation to - mute, kick and ban after violation of rules.
> 
> **This needs to be worked on!**

> !readRules `<bool>` | This command locks the chat until rules are accepted. There is an emoji with a checkbox sent required to be clicked in order to allow the user to access all the "default channels" of the server".

> !welcomeMessage `<bool>` `<string>` | If enabled this command sets out a custom welcome message in a custom generated image which is uploaded to the "joined messages chat". This will upload a custom image welcoming the user to the server with their profile picture, name and the custom welcome message.

> !rules `<int>` | displays the specified quotued rule number rule.

> !mute `<string>` `<time>` `<seconds || minutes || hours || days>` | This command temporarily mutes the user for a set amount of time preventing them from writing messages in any chat until they have time to "cool off".

> !kick `<string>` | This kicks the user from the discord server whilst also privately messaging them from the bot with the reason of why they've been kicked. It also writes in chat that they've been kicked.

> !ban | This bans the user from the discord server whilst also privately messaging them from the bot with the reason of why they've been kicked. It also writes in chat that they've been banned.
> 
> * This is done in order to prevent rogue admins from mass pruning servers with a one day activity limit, by preventing users from having admin rules and only the bot it prevents people from getting mass pruned without adequate permission

> !imageLock `<boolean>` | This locks a channel to images only.

> !textLock `<boolean>` | This locks a channel to text only.

> !purge  (`<all>`|`<number>`) || (`<user>` (`<string>` || `<all>` || `<number>`)) | This purges X amount of messages from a user or the entire chat.

> !botNick `<string>` | This changes the bots nickname, if you wanted this for some reason.

> !prefix `<string>` | This changes the bots prefix, from default "!" to a user specified string

> !autorole `<string>` | This automatically sets the role of users who join the discord server to `<string>`.

>  !recolorRole | Automatically recolors a role from one color to another.

> !goodbye `<boolean>` [`<string>`] | This enables or disables goodbye messages in addition to setting the message to `<string>`.

> !reactAssign `<add|post>` [`<string>` `<string>` [`<string>`]]| This creates a react based role assignment post, where users can react with specific reactions to get a rank. This takes in the emoji string, the rank string and then an optional rank description string.
> 
> * Perhaps have a way to split this across multiple channels such as #compsci-subjects #engineering-subjects with a quick link to the hidden lobby?

> !blackList `<string>` | Has the ability to blackList members from the bot, preventing spam, abuse or just annoying people from using the bot.

> !botChannel `<add|remove>` `<String>` | Adds or removes the ability for the bot to accept commands from that specific discord channel.

> !starBoard `<bool>` [`<string>`] | Adds the ability to enable or disable a starboard channel where when people who react with stars to a post, if the post exceeds 5 stars the post will be added to the starboard.

> !autoPrune `<boolean>` | Adds the ability to automatically prune discord the discord server periodically every 24 hours removing inactive users from the server.

> !disable `<string>` | Disables a class of the bot for the server.

> !enable `<string>` | Enables a class of the bot for the server.

### Voice Features

#### Examples

- [Alfred the butcher](https://www.alfredthebutler.net/)
- [SlimMirai](https://github.com/amirzaidi/SlimMirai)
- [snowball](https://github.com/Olical/snowball)

#### Voice Commands

May need a prefix **keyword** to prevent misfires ( e.g "hey google -", "alexa -" )

> "Ignore me" - sends bot back to sleep.

> "Move" - any sentence will trigger movement, such as username or "me", "myself", "everyone" or "lobby" and channel name such as "this channel", "my channel", "our channel" or "here" or "Channel name".

> Play "" - either through !play or through text-to-speech api making a call itself.

> Volume
> 
> - "Increase" "up" "raise" will increase volume by a default value
> 
> - "Decrease" "down" "lower" will lower volume by a default value
> 
> - Including a number to volume will set volume of bot specifically
>   
>   - "turn the volume up"
>   - "lower volume by 30"
>   - "turn volume to 20"
>   - Pause / stop
>   - Resume / unpause
>   - Skip
>   - Summon

#### Music Bot

> Music from; *Youtube*, *Soundcloud*, Twitch and possibly *Spotify*?

> !summon | Summons the bot to your lobby.

> !move `<string>` {`<string>`} | Moves everyone in voice chat to another channel OR moves yourself to another channel. Specify the channel you wish everyone to move to and/or the group you wish to target the move to.

> !tts `<string>` | Makes the bot say text-to-speech words in voice chat, using googles WazeNet.

### Programming Documentation & Functions

> !code-docs `<string>` `<string>` | Search manual pages of; python doc, java doc etc for specific entry, in addition can also search stackoverflow for questions. The format of this is `<document type i.e javadocs, stackoverflow etc>` then `<query>`

> !code-beautify `<string>` | Detects and turns code into a nice readable format, it should allow plain text code to be input with beautifier and then will format it with indents and display it as a discord block with the specified language.
> 
> * It should in additional automatically delete the users message BUT include the name of the user who submitted it.

> !code-snippet `<string>` | Makes a database of snippets, when a snippet is requested paste it to chat, there is some intrested menu capabilities here allowing for displaying and navigating all snippets.

### Maths Tookit

> !latex `<string>` | Gives the ability to write LaTeX equations in discord with the bot formatting and uploading it.

### Image Generator Commands

> !showMeme | Displays a random meme.
> 
> * I've done webscraping quite a few times and have a /r/ProgrammingHumor meme scraping and reuploading to instagram bot - perhaps we can use that if needed (not finished though).

> !deepfry | Deepfries the users profile image.

### RPG Games & Gambling

#### Gambling

> !gameFarmCoin | Allows the user to farm coin to gain a virtual currency (it just generates a random int).

> !gameBetCoin `<int>` | Allows the user to bet coin with a 50-50 chance to double it or lose everything.

> !gameSetCoin [`<string>`] `<int>` | Allows administrators to set a coin amount to a user or themselves.

> !gamePayCoin `<string>` `<int>` | Allows users to give other people coins from their own wallet.

> !gameWalletCoin | Allows the user to see how much coin they currently own.

> !gameHideCoin `<bool>` | Allows admins to set so that messages involving coin are automatically deleted (excluding the bots message).

> !dice `<int>` `<int>` | Allows the player to bet on the roll of a dice, input numbers between 1-6 in the first one and the bet in the second.

> !slots `<int>`  | Allows the players to play a round of slots.

#### RPG Games

> !rate `<string>` | The bot automatically rates `<string>` from 1 to 10.

> !8ball `<string>` | The ball automatically responds to `<string>` with a random 8ball response

> !rps `<string>` | Allows the player to play a match of rock paper scissors against the AI

> !choose `<string>` `<string>` | Makes the bot choose between two random options for the user.

### Profiles

> !accountInfo [`<string>`] | Be able to view account info of a given user including:
> 
> * Fullname
> 
> * Nickname
> 
> * Account created date
> 
> * ID
> 
> * Date joined this server
> 
> * IsBot
> 
> * Roles
> 
> * Nitrobooster

> Have levels | The users recieves a level based on their level of activity in chat from this they earn bragging rights as well as being able to "rank" themselves against their peers for who uses the discord the most.
> 
> !rank [`<string>`] | This command allows users to see what rank they are OR if the optional `<string>` is added this allows users to view other users ranks
> 
> !rankTop | This command shows the leaderboards for ranks, showing the top 5 ranks of the server

>  Can use real money to customize the appearance of cards - become EA?

>  !profilePhoto [`<string>`] | Grabs the users profile photo OR grabs another users profile photo if another user is tagged

>  User Bios:
> 
> - Background - allows you to edit your profile background image
> 
> - bio - allows you to change bio
> 
> - profile - shows your profile
> 
> - rep - gives rep to other members

> !afk | Lets people know that you are afk if they tag you

### Reactions

> !cheer [`<string>`] | Cheers for something or someone - **DONE**

> !cringe [`<string>`] | Cringes for something or someone - **DONE**

> !cry [`<string>`] | Cries for something or someone - **DONE**

> !dance [`<string>`] | Dances with somebody or someone **DONE**

> !party [`<string>`] | Parties with somebody or someone - **DONE**

> !pat [`<string>`] | Pats somebody or someone - **DONE**

> !poke [`<string>`] | Pokes somebody or someone - **NOT DONE** 

> !smug [`<string>`] | Sends smug reaction to somebody or someone - **DONE**

> !f [`<string>`] | Pays respect to somebody or someone - **DONE**
> 
> !hello [`<string>`] | Says hello to somebody or someone

> !say `<string>` | Repeats back to you whatever you say, bascially a ping to check if the bots online

> !whoIsAGoodBoy | Confirms the bot is a good boy

### Google / Web Stuff

> !strawpoll `{<string>}` {`<string>`} | To create a multi-reaction poll type {title}   [option 1] [option 2] [option 3] ...

> !urbanDictionary `<string>` | Searches on urban dictionary for `<Word Name>` and displays a formatted post by the bot

> !lmgtfy `<string>` | Provides a let me google that for you link for the proposed string

> !google `<int>` `<string>` | Returns the n number of top results in googles format

> !crypto `<string>` | Returns the current cryptocurrency price and history of a cryptocurrency

> !stock `<string>` | Returns the current stock price and history of a stock

> !tldr `<string>` | Gives a TL;DR (summary) for a specified webpage

### Counting Bot

> !counting `<bool>` [`<string>`] | Enables or disables the counting bot function, if enabled on a specified channel it will monitor chat to ensure the next message is a number incrementing from the previous message by one. Anything deviating from this will be deleted.
> 
> * One person can't count two numbers in a row
> 
> * Will delete a message if it doesn't start with a number
> 
> !countingTop | Shows the top 10 people with the most numbers written in chat.

### Misc

> !invite | Provides the discord instant invite link in the chat (instead of creating a new invite link)

> !uwuify | oWos a text

> !inspire | Generates a random terrible inspirational quotue
> 
> !remindMe `<string>` `<string>` | Allows you to set a reminder for an event and will ping you with the event when the time expires (Sends a dm with a link to the referenced command link in question)

> !commands | Lists all the commands

> !donate | Sends contact information of how and where to donate to keep the bot running

> !stats | Shows the stats of the discord bot including:
> 
> * Uptime
> 
> * Ping
