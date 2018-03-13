package pl.cgg.offers.utility;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {

    private List<Character> characterList;

    public List<Character> alphabet() {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'ł',
                'm',
                'o',
                'p', 'r', 's', 't', 'u', 'w', 'x', 'y', 'z'};
        List<Character> characters = new ArrayList<>();

        for (char chars : charArray) {
            characters.add(chars);
        }
        this.setCharacterList(characters);
        return characters;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }
}
