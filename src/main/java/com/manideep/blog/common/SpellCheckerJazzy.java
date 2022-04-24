package com.manideep.blog.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellCheckEvent;
import com.swabunga.spell.event.SpellCheckListener;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;
import com.swabunga.spell.event.TeXWordFinder;

public class SpellCheckerJazzy implements SpellCheckListener {

    private SpellChecker spellChecker;
    private List<String> misspelledWords;

    public List<String> getMisspelledWords(String text) {
        StringWordTokenizer texTok = new StringWordTokenizer(text, new TeXWordFinder());
        spellChecker.checkSpelling(texTok);
        return misspelledWords;
    }

    private static SpellDictionaryHashMap dictionaryHashMap;

    static {

        File dict = new File("Dictionary/dictionary.txt");
        try {
            dictionaryHashMap = new SpellDictionaryHashMap(dict);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        spellChecker = new SpellChecker(dictionaryHashMap);
        spellChecker.addSpellCheckListener(this);
    }

    public SpellCheckerJazzy() {

        misspelledWords = new ArrayList<String>();
        initialize();
    }

    @Override
    public void spellingError(SpellCheckEvent event) {
        event.ignoreWord(true);
        misspelledWords.add(event.getInvalidWord());
    }
}