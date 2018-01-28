package com.example.ugre.startandroid.parsers;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.ugre.startandroid.helpers.SettingsManager;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Praksa2 on 14-Jun-17.
 */

public class SettingsParser extends DefaultHandler {

    Context context;
    Boolean elementOn = false;
    String elementValue;

    boolean readingColors = false;

    public SettingsParser(Context context) {
        this.context = context;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        elementOn = true;

        if (localName.equalsIgnoreCase("text_colors"))
            this.readingColors = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        elementOn = false;

        if (localName.equalsIgnoreCase("text_colors"))
            this.readingColors = false;
        else if (readingColors)
            SettingsManager.getInstance().putColor(localName, elementValue);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementOn){
            elementValue = new String(ch, start, length);
            elementOn = false;
        }
    }

    public int parseXML()
    {
        int result;

        try
        {
            ParserAdapter parser = new ParserAdapter(SAXParserFactory.newInstance().newSAXParser().getParser());
            parser.setContentHandler(this);

            parser.parse(new InputSource(context.getAssets().open("settings.xml")));
            result = 1;
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
            result = -1;
        }

        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
            result = -1;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            result = -1;
        }
        catch (StringIndexOutOfBoundsException e)
        {
            e.printStackTrace();
            result = -1;
        }
        catch (SAXException e)
        {
            e.printStackTrace();
            result = -1;
        }

        return result;
    }
}
