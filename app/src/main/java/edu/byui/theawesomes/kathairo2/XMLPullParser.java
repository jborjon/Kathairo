package edu.byui.theawesomes.kathairo2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;


/**
 * Created by fmcho on 7/1/2016.
 */
public class XMLPullParser {

    static final String KEY_Resources = "resources";
    static final String KEY_Kathairo2 = "Kathairo2";
    static final String KEY_CroossWord = "Crosword";
    static final String KEY_Words = "Words";
    static final String KEY_Word = "Word";
    static final String KEY_Number = "Number";
    static final String KEY_Clue = "Clue";


    public CrossWord getCrossWordFromFile(Context ctx, String fileName) {

        // List of StackSites that we will return
        CrossWord crossword;
        crossword = new CrossWord();

        // temp holder for current StackSite while parsing
        Word wordToset = null;
        // temp holder for current text value while parsing
        String curText = "";

        try {
            // Get our factory and PullParser
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();

            // Open up InputStream and Reader of our file.
            FileInputStream fis = ctx.openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            // point the parser to our file.
            xpp.setInput(reader);

            // get initial eventType
            int eventType = xpp.getEventType();

            // Loop through pull events until we reach END_DOCUMENT
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // Get the current tag
                String tagname = xpp.getName();

                // React to different event types appropriately
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase(KEY_Words)) {
                            // If we are starting a new <site> block we need
                            //a new StackSite object to represent it
                            wordToset = new Word();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        //grab the current text so we can use it in END_TAG event
                        curText = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase(KEY_Words)) {
                            // if </site> then we are done with current Site
                            // add it to the list.
                            crossword.addWordObject(wordToset);
                        } else if (tagname.equalsIgnoreCase(KEY_Word)) {
                            // if </name> use setName() on curSite
                            wordToset.setWord(curText);
                        } else if (tagname.equalsIgnoreCase(KEY_Clue)) {
                            // if </link> use setLink() on curSite
                            wordToset.setClue(curText);
                        }
                        break;

                    default:
                        break;
                }
                //move on to next iteration
                eventType = xpp.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return the populated list.
        return crossword;
    }
}
