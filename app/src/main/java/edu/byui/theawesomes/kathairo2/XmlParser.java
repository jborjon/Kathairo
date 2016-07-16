package edu.byui.theawesomes.kathairo2;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jordan on 7/4/16. code obtained and modified from
 * https://developer.android.com/training/basics/network-ops/xml.html
 */
public class XmlParser {
    // We don't use namespaces
    private static final String ns = null;

    public List parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            in.close();
        }
    }

    /*****************************
     * Read the feed
     *  @param parser XMLPullParser
     * @return List
     ***************************/
    private List readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        List<edu.byui.theawesomes.kathairo2.Word> crossword = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "Crossword");
        while (parser.next() != XmlPullParser.END_TAG) {

            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("Word")) {
                crossword.add(readWord(parser));
            } else {
                skip(parser);
            }
        }

        return crossword;
    }
    /**************************************************************
     * Parses the contents of an entry. If it encounters a title, summary, or link tag, hands them off
     * to their respective "read" methods for processing. Otherwise, skips the tag.
     * @param parser XMLPullParser
     * @return Word
     ************************************************************* */
    private Word readWord(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "Word");

        Word word = new Word();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            String name = parser.getName();

            //set the part of word with whatever the parser is on
            if (name.equals("answer")) {
                word.setAnswer(readText(parser));
            } else if (name.equals("clue")) {
                word.setClue(readText(parser));
            } else if (name.equals("clueNumber")) {
                word.setClueNumber(readNumber(parser));
            } else if (name.equals("row")) {
                word.setRow(readNumber(parser));
            } else if(name.equals("column")) {
                word.setCol(readNumber(parser));
            } else if(name.equals("direction")) {
                word.setIsDown(readBoolean(parser));
            }
            else {
                skip(parser);
            }
        }
        return word;
    }
    /***************************************************************
     * Reads the text and returns it as a String
     * @param  parser XMLPullParser
     * @return String
     * ***************************************************************/
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    /***************************************************************
     * Reads the text and returns it as a Boolean
     * @param  parser the XMLPullParser
     * @return Boolean
     * ***************************************************************/
    private Boolean readBoolean(XmlPullParser parser) throws IOException, XmlPullParserException {
        String text = "";
        Boolean result = false;
        if (parser.next() == XmlPullParser.TEXT) {
            text = parser.getText();
            parser.nextTag();
        }
        switch (text) {
            case "across":
                result = false;
                break;
            case "down":
                result = true;
                break;
        }
        return result;
    }

    /***************************************************************
     * Reads the text and returns it as a number (up to 23)
     * @param  parser the XMLPullParser
     * @return int
     * ***************************************************************/
    private int readNumber(XmlPullParser parser) throws IOException, XmlPullParserException {
        String text = "";
        int result;
        if (parser.next() == XmlPullParser.TEXT) {
            text = parser.getText();
            parser.nextTag();
        }

        switch (text){
            case "0":
                result = 0;
                break;
            case "1":
                result = 1;
                break;
            case "2":
                result = 2;
                break;
            case "3":
                result = 3;
                break;
            case "4":
                result = 4;
                break;
            case "5":
                result = 5;
                break;
            case "6":
                result = 6;
                break;
            case "7":
                result = 7;
                break;
            case "8":
                result = 8;
                break;
            case "9":
                result = 9;
                break;
            case "10":
                result = 10;
                break;
            case "11":
                result = 11;
                break;
            case "12":
                result = 12;
                break;
            case "13":
                result = 13;
                break;
            case "14":
                result = 14;
                break;
            case "15":
                result = 15;
                break;
            case "16":
                result = 16;
                break;
            case "17":
                result = 17;
                break;
            case "18":
                result = 18;
                break;
            case "19":
                result = 19;
                break;
            case "20":
                result = 20;
                break;
            case "21":
                result = 21;
                break;
            case "22":
                result = 22;
                break;
            case "23":
                result = 23;
                break;
            default:
                result = -1;
                break;
        }
        return result;
    }


    /***************************************************************
     * skips unneeded tags
     * @param  parser the XMLPullParser
     * ***************************************************************/
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }

}