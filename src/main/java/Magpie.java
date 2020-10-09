/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        String trimsm = statement.trim();
        if (statement.indexOf("I want ") >= 0) {
            return transformIWantStatement(statement);
        }
        else if (statement.indexOf("I ") >= 0 && statement.indexOf(" you") >= 0) {
            return transformIYouStatement(statement);
        }
        else if (statement.indexOf("I want to ") >= 0) {
            return transformIWantToStatement(statement);
        }
        else if (statement.indexOf("you ") >= 0 && statement.indexOf(" me") >= 0) {
            return transformYouMeStatement(statement);
        }
        
        else {

            if (trimsm.length() <= 0)
        {
            response = "Say something, please.";
        }
        else if (findWord(statement, "dog") >= 0
                || findWord(statement, "cat") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findWord(statement, "basketball") >= 0
                || findWord(statement, "soccer") >= 0
                || findWord(statement, "football") >= 0
                || findWord(statement, "baseball") >= 0)
        {
            response = "Tell me more about sports.";
        }
        else if (findWord(statement, "Mr. Finkelstein") >= 0)
        {
            response = "He sounds like a good teacher.";
        }
        else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findWord(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findWord(statement, "sad") >= 0
                || findWord(statement, "boring") >= 0)
        {
            response = "Don't be so negative. Come on!";
        }
        else if (findWord(statement, "interesting") >= 0
                || findWord(statement, "fun") >= 0)
        {
            response = "Sounds cool! Tell me more.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
        }
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Really? Sounds good.";
        }
        else if (whichResponse == 5)
        {
            response = "Wow.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        int len = str.length();
        String lstr = str.toLowerCase();
        String lword = word.toLowerCase();
        String addedwd;
        int finder;
        if (lstr.indexOf(lword) == 0) {
            addedwd = lword + " ";
            finder = lstr.indexOf(addedwd);
        } else if (lstr.indexOf(lword) == (len - lword.length())) {
            addedwd = " " + lword;
            finder = lstr.indexOf(addedwd);
            if (finder != -1) {
                finder++;
            }
        } else if (lword.length() == len) {
            addedwd = lword;
            finder = lstr.indexOf(addedwd);
        } else {
            addedwd = " " + lword + " ";
            finder = lstr.indexOf(addedwd);
            if (finder != -1) {
                finder++;
            }
        }
        return finder;
    }

    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String check = "I want ";
        int startwd = statement.indexOf(check) + 7;
        String sth = "";
        for (int i = startwd; i < statement.length(); i++) {
            sth += statement.charAt(i);
        }
        String sentence = "Would you really be happy if you had " + sth + "?";
        return sentence;
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String checki = "I ";
        String checku = " you";
        int startwd = statement.indexOf(checki) + 2;
        int endwd = statement.indexOf(checku) - 1;
        String sth = "";
        for (int i = startwd; i < endwd + 1; i++) {
            sth += statement.charAt(i);
        }
        String sentence = "Why do you " + sth + " me?";
        return sentence;
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        String check = "I want to ";
        int startwd = statement.indexOf(check) + 10;
        String sth = "";
        for (int i = startwd; i < statement.length(); i++) {
            sth += statement.charAt(i);
        }
        String sentence = "What would it mean to " + sth + "?";
        return sentence;
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        String checku = "you ";
        String checkme = " me";
        int startwd = statement.indexOf(checku) + 4;
        int endwd = statement.indexOf(checkme) - 1;
        String sth = "";
        for (int i = startwd; i < endwd + 1; i++) {
            sth += statement.charAt(i);
        }
        String sentence = "What makes you think that I " + sth + " you?";
        return sentence;
    }
}

