package edu.byui.theawesomes.kathairo2;

import android.util.Xml;
import android.widget.TextView;

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
public class CrosswordXmlParser {
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

    //Starts the heavy lifting
    private List readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        List<edu.byui.theawesomes.kathairo2.Word> crossword = new ArrayList<edu.byui.theawesomes.kathairo2.Word>();

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

    // Parses the contents of an entry. If it encounters a title, summary, or link tag, hands them off
    // to their respective "read" methods for processing. Otherwise, skips the tag.
    private Word readWord(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "Word");

        Word word = new Word();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            String name = parser.getName();

            if (name.equals("answer")) {
                word.setAnswer(readText(parser));
            } else if (name.equals("clue")) {
                word.setClue(readText(parser));
            } else if (name.equals("clueNumber")) {
                word.setClueNumber(readNumber(parser));
            } else if (name.equals("row")) {
                word.setRow(readNumber(parser));
                assert (word.getRow() != -1);
            } else if(name.equals("column")) {
                word.setCol(readNumber(parser));
                assert (word.getCol() != -1);
            } else if(name.equals("direction")) {
                word.setIsDown(readBoolean(parser));
            }
            else {
                skip(parser);
            }
        }
        return word;
    }

    // For the tags title and summary, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    //
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
            default:
                result = false;
                break;
        }
        return result;
    }

        //for the numbers convert string into number
    private int readNumber(XmlPullParser parser) throws IOException, XmlPullParserException {
        String text = "";
        int result = 0;
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
 /*This will house are Word class
    public class Word {
        public final String answer;
        /*
        public final int answerNumberOfLetters;
        public final String clue;
        public final int clueNumber;

        private Word(String answer) {
            this.answer = answer;
        }
        //The constructor that sets everything
        /*private Word(String answer, int answerNumberOfLetters, String clue, int clueNumber) {
            this.answer = answer;
            this.answerNumberOfLetters = answerNumberOfLetters;
            this.clue = clue;
            this.clueNumber = clueNumber;
        }
    }
     // Processes title tags in the feed.
    private String readAnswer(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "answer");
        String answer = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "answer");
        return answer;
    }

    // Processes link tags in the feed.
    private String readClue(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "clue");
        String clue = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "clue");
        return clue;
    }
*/