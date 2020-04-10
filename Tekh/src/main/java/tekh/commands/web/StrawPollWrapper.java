package tekh.commands.web;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Samuel-Maddock on 09/08/2017.
 */

public class StrawPollWrapper
{
    private static transient final String API_URL = "https://www.strawpoll.me/api/v2/polls";
    private static transient final String SITE_URL = "https://www.strawpoll.me/";
    private String id = "";
    private String title;
    private List<String> options = new ArrayList<>();

    @SerializedName("multi")
    private boolean isMulti = false;

    @SerializedName("dupcheck")
    private String dupCheck = "normal";

    @SerializedName("captcha")
    private boolean hasCaptcha = false;

    private List<Integer> votes = new ArrayList<>();
    private transient String pollURL = "";

    /**
     * Default constructor, sets the title of the poll to "Default Poll Title"
     * NOTE: You will have to call create() to send a POST request to create a StrawPoll on the website.
     */
    public StrawPollWrapper() {
        this.title = "Default Poll Title";
    }

    /**
     *  This is a copy constructor
     *  NOTE: You will have to call create() to send a POST request to create a StrawPoll on the website.
     * @param poll - creates a new poll object identical to the poll passed
     */
    public StrawPollWrapper(StrawPollWrapper poll){ //Copy Constructor
        updatePoll(poll);
    }

    /**
     * This creates a StrawPoll object by retrieving the data from the poll url provided
     * @param url - The URL of the poll to create the object from
     */
    public StrawPollWrapper(String url){
        updatePoll(retrieve(url));
    }

    /**
     * This creates a StrawPoll object by retrieving the data from the poll with the int id provided
     * @param id
     */
    public StrawPollWrapper(int id){
        updatePoll(retrieve(id));
    }

    /**
     * This creates a StrawPoll object with the title and options passed to it.
     * NOTE: You will have to call create() to send a POST request to create a StrawPoll on the website.
     * @param title - The title of the StrawPoll
     * @param options - The options of the StrawPoll
     */
    public StrawPollWrapper(String title, String... options){
        this.title = title;
        this.options = Arrays.asList(options);
    }

    /**
     * This creates a StrawPoll object with the title and the options in the List<String> passed.
     * NOTE: You will have to call create() to send a POST request to create a StrawPoll on the website.
     * @param title - The title of the StrawPoll
     * @param options - The options of the StrawPoll
     */
    public StrawPollWrapper(String title, List<String> options){
        this.title = title;
        this.options = options;
    }

    /**
     * This creates a StrawPoll object with the title, options, isMulti, hasCaptcha and dupCheck.
     * NOTE: You will have to call create() to send a POST request to create a StrawPoll on the website.
     * @param title - The title of the StrawPoll
     * @param options - The options of the poll as List<String>
     * @param isMulti - True if users can vote multiple times, false otherwise
     * @param hasCaptcha - True if the poll has captcha, false if not.
     */
    public StrawPollWrapper(String title, List<String> options, boolean isMulti, boolean hasCaptcha){
        this(title, options);
        this.isMulti = isMulti;
        this.hasCaptcha = hasCaptcha;
    }

    private HttpURLConnection createConnection(String apiUrl, String request) throws IOException{
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(request);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("User-Agent", "StrawPoll Java API Wrapper 1.0.0");
        connection.setDoInput(true);

        if(request.equals("POST")){
            connection.setDoOutput(true);
        }

        return connection;
    }

    /**
     * This creates a strawpoll by sending a POST request to the strawpoll API.
     * The poll will be created with the current title, options and boolean settings.
     * <p>After calling this, the {@code pollURL} will be updated to the url of the created poll.</p>
     */
    public void create() {
        if (this.options.size() == 0){
            throw new RuntimeException("Cannot create a poll with no options.");
        }

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(this);

        try{
            HttpURLConnection connection = createConnection(API_URL, "POST");
            connection.setRequestProperty("Content-Length", Integer.toString(jsonMessage.length()));

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(jsonMessage);
            wr.flush();
            wr.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String returnedJSON = br.readLine();
            StrawPollWrapper returnedPoll = gson.fromJson(returnedJSON, StrawPollWrapper.class);
            updatePoll(returnedPoll);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This retrieves the strawpolls information (using the current id) from the API via a GET request.
     * It then updates the current StrawPoll object to reflect any changes in the poll.
     */
    public void update() {

        if (this.id.equals("")){
            return;
        }

        try{
            HttpURLConnection connection = createConnection(API_URL + "/" + this.id, "GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonMessage = br.readLine();
            br.close();
            Gson gson = new Gson();
            StrawPollWrapper returnedPoll = gson.fromJson(jsonMessage, StrawPollWrapper.class);
            updatePoll(returnedPoll);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void updatePoll(StrawPollWrapper poll){
        this.id = poll.getId();
        this.title = poll.getTitle();
        this.options = poll.getOptions();
        this.isMulti = poll.isMulti();
        this.hasCaptcha = poll.hasCaptcha();
        this.votes = poll.getVotes();
        this.pollURL = SITE_URL + poll.getId();
    }

    /**
     * This retrieves the strawpolls information from the url given.
     * It then returns a StrawPoll object with the data retrieved.
     * @param url - The url of the strawpoll
     * @return - The strawpoll object, null if the link is invalid.
     */
    public StrawPollWrapper retrieve(String url){
        if (!url.startsWith(SITE_URL)){
            return null;
        }

        url = url.replace(SITE_URL, "");
        url = url.replace("/r", "");

        try{
            HttpURLConnection connection = createConnection(API_URL + "/" + url, "GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String jsonMessage = br.readLine();
            br.close();
            Gson gson = new Gson();
            StrawPollWrapper returnedPoll = gson.fromJson(jsonMessage, StrawPollWrapper.class);
            return returnedPoll;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This retrieves the strawpolls information from the integer id given.
     * It then returns a StrawPoll object with the data retrieved.
     * @param id - The integer id of the StrawPoll
     * @return - The strawpoll object, null if the link is invalid.
     */
    public StrawPollWrapper retrieve(int id){
        return retrieve(SITE_URL + id);
    }

    /**
     * This gets the id of the created strawpoll object.
     * If the strawpoll has not yet been created via {@code create()} then the id will be empty by default.
     * @return - The string id of the strawpoll
     */
    public String getId() {
        return id;
    }

    /**
     * This gets the title of the strawpoll object.
     * If the title has not yet been set, then by default the title is "Default Poll Title"
     * @return - The string title of the poll.
     */
    public String getTitle() {
        return title;
    }

    /**
     * This will set the value of the strawpoll object title.
     * @param title - The title of the strawpoll.
     * @return - The instance of this class (for method-chaining)
     */
    public StrawPollWrapper setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * This will set the options of strawpoll object.
     * Note that this will clear any previously stored options.
     * If you want to add options us {@code addOptions()} instead.
     * @param options - The {@code List<String>} collection of options
     * @return - The updated strawpoll object for method chaining
     */
    public StrawPollWrapper setOptions(List<String> options){
        this.options = options;
        return this;
    }

    /**
     * This adds options to the strawpoll object.
     * @param options - A list of string options to be added (can be one or multiple)
     * @return - The updated strawpoll object for method chaining
     */
    public StrawPollWrapper addOptions(String... options){
        this.options.addAll(Arrays.asList(options));
        return this;
    }

    /**
     *This gets the list of options stored in the strawpoll object
     * @return - {@code List<String>} of options
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * This gets a list of votes
     * @return - {@code List<Integer>} of votes
     */
    public List<Integer> getVotes() {
        return votes;
    }

    /**
     * This gets the boolean of isMulti()
     * If this is true, then the poll will allow multiple votes from a single user
     * If this is false, then the poll will not allow multiple votes from the same user.
     * @return
     */
    public boolean isMulti() {
        return isMulti;
    }

    /**
     * This sets the boolean of isMulti()
     * <p>If this is true, then the poll will allow multiple votes from a single </p>
     * <p>If this is false, then the poll will not allow multiple votes from the same user.</p>
     * @param multi - The boolean to set
     * @return - The instance of this class (for method-chaining)
     */
    public StrawPollWrapper setIsMulti(boolean multi) {
        isMulti = multi;
        return this;
    }

    /**
     * This checks to see if the poll has a captcha.
     * <p>If this is true then the poll will have a captcha to verify they are not a bot</p>
     * <p> If this is false, the poll will not have a captcha</p>
     * @return - The boolean that determines if the poll has a captcha
     */
    public boolean hasCaptcha() {
        return hasCaptcha;
    }

    /**
     *
     * @param hasCaptcha - The boolean to determine if the poll has a captcha
     * @return - The instance of this class (for method-chaining)
     */
    public StrawPollWrapper setHasCaptcha(boolean hasCaptcha) {
        this.hasCaptcha = hasCaptcha;
        return this;
    }

    /**
     * This gets the full url of a created strawpoll.
     * @return - The full url of the created strawpoll.
     */
    public String getPollURL(){
        return this.pollURL;
    }

    /**
     * This converts the current strawpoll object into JSON
     * @return - The raw JSON of the strawpoll object
     */
    public String toRawJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public String toString(){
        return toRawJSON();
    }
}

