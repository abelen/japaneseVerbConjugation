package conjugation;

/**
 * A data dictionary that keeps track of all the different characters in the Japanese
 * written language. 
 */

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;

@Named
@Singleton
public class JapanCharacters {

    /* map that is used to map each Japanese ending letter to its conjugation patterns */
	private HashMap<String, ArrayList<String>> dict;

    /**
     * Default constructor.
     */
	public JapanCharacters() {
		dict = new HashMap<String, ArrayList<String>>();
		populateDict(dict);
	}

    /**
     * Checks to see if the dictionary have been initialized.
     */
    @PostConstruct
    public void init() {
        if (dict == null) {
            throw new IllegalStateException("The dictionary should be not null.");
        }
    }

    /**
     * Returns the dictionary of all the conjugation patterns.
     *
     * @return The dictionary of all the conjugation patterns.
     */
	public HashMap<String, ArrayList<String>> getDict() {
		return dict;
	}
	
	/* Populates the written characters in accordance to letters that start with the 
	 * same constant. All the letters that start with the same constant is placed into
	 * an ArrayList and then those ArrayLists are added into the dictionary.
	 */
	private HashMap<String, ArrayList<String>> populateDict(HashMap<String, ArrayList<String>> dict) {
		
		ArrayList<String> au = new ArrayList<String>();
		au = addToList(au,"あ","い","う","え","お");
		dict.put("う",au);
		ArrayList<String> kaku = new ArrayList<String>();
		kaku = addToList(kaku,"か", "き", "く", "け", "こ");
		dict.put("く",kaku);
		ArrayList<String> mamu = new ArrayList<String>();
		mamu = addToList(mamu, "ま", "み", "む", "め", "も");
		dict.put("む",mamu);
		ArrayList<String> sasu = new ArrayList<String>();
		sasu = addToList(sasu, "さ", "し", "す", "せ", "そ");
		dict.put("す",sasu);
		ArrayList<String> tatu = new ArrayList<String>();
		tatu = addToList(tatu, "た", "ち", "つ", "て", "と");
		dict.put("つ",tatu);
		ArrayList<String> hahu = new ArrayList<String>();
		hahu = addToList(hahu, "は", "ひ", "ふ", "へ", "ほ");
		dict.put("ふ",hahu);
		ArrayList<String> babu = new ArrayList<String>();
		babu = addToList(babu, "ば", "び", "ぶ", "べ", "ぼ");
		dict.put("ぶ",babu);
		ArrayList<String> papu = new ArrayList<String>();
		papu = addToList(papu, "ぱ", "ぴ", "ぷ", "ぺ", "ぽ");
		dict.put("ぷ",papu);
		ArrayList<String> dadu = new ArrayList<String>();
		dadu = addToList(dadu, "だ", "ぢ", "づ", "で", "ど");
		dict.put("づ",dadu);
		ArrayList<String> zazu = new ArrayList<String>();
		zazu = addToList(zazu, "ざ", "じ", "ず", "ぜ", "ぞ");
		dict.put("ず",zazu);
		ArrayList<String> gagu = new ArrayList<String>();
		gagu = addToList(gagu, "が", "ぎ", "ぐ", "げ", "ご");
		dict.put("ぐ",gagu);
		ArrayList<String> raru = new ArrayList<String>();
		addToList(raru, "ら", "り", "る", "れ", "ろ");
		dict.put("る",raru);
			
		return dict;	
	}

	private ArrayList<String> addToList(ArrayList<String> list, String l1, String l2, String l3,
			String l4, String l5) {
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		list.add(l5);
		return list;
	}
}