package cCalculator;

import java.util.*;

/**
 * Created by mathias on 4/29/17.
 */
class GrammarCheck {

    /* Setid ja listid, mida kasutatakse grammatika kontrollmisel */
    private final Set<String> Prohibited = new HashSet<>(Arrays.asList("%", "<", ">", "=", "!", "|",
            "&", "[", "]", "{", "}", "$", "#", "@", "~", "\\", "\"", ":", ";", ",", "'", "?", "_"));
    private final Set<String> Constants = new HashSet<>(Arrays.asList("pi", "e", "i"));
    private final List<String> Functions = new ArrayList<>(Arrays.asList("sin", "cos", "tan", "asin",
            "acos", "atan", "sinh", "cosh", "tanh", "ln", "log", "exp", "pow", "re", "im", "cmod", "arg",
            "conj", " "));

    /**
     * Meetod, mis tagastab true, kui antud string on parsitav. Kui sone ei ole parsitav, siis taastab false
     * @param str kontrollitav sone
     * @return checkParenthesis(str)
     */
    boolean isParsable(String str){
        return checkParenthesis(str);
    }

    /**
     * Meetod, mis kontrollib, kas ekspressioonis on paaris arv sulgesid ning kas nad sulevad uksteist
     * @param str kontrollitav sone
     * @return checkFunctions(str) && balance == 0
     */
    private boolean checkParenthesis(String str){
        str = str.replace(" ", "");
        if(str.length() == 0) return false;
        int balance = 0;

        for(char c : str.toCharArray()){
            if(c == '(') balance++;
            else if(c == ')') balance--;
            if(balance<0) return false; // Tagastab false, kuna sulud ei sule uksteist, e.g ekspressioonis on ) sulg enne ( sulge
        }

        return checkFunctions(str) && balance == 0;
    }

    /**
     * Meetod, mis tuvastab, kas ekspressioonis on funtsioonid voi konstantid oigesti kirjutatud
     * @param str kontrollitav sone
     * @return checkProhibited(str)
     */
    private boolean checkFunctions(String str){
			String temp = str.replaceAll("[^a-zA-Z]", " "); // Vahetab koik mitte-tahed tuhikutega ning seejarel splitib stringi arrayks
			int shift = 0;
			for(char c : temp.toCharArray()){
				if(c == ' ') shift++;
				else break;
			}
			temp = temp.substring(shift);
			if(temp.length() == 0) return checkProhibited(str);
      String[] listOfFun = temp.split(" +");
      for(String s : listOfFun){ // Kui arrays on tundmatu string, siis tagastab false
          if(!(Functions.contains(s) || Constants.contains(s))) return false;
      }

      for(String s : Functions){ // Kui funktsioon on naiteks 'sin' voi 'sin2' voi 'sin()', siis tagastab false
          if(str.matches(".*(" + s + ")$|" +
          		".*(" + s + ")[^(].*|" +
                  ".*(" + s + ").[)].*")) return false;
      }

      return checkProhibited(str);
    }

    /**
     * Kontrollib, kas ekspressioonis on karaktereid, mida ei ole lubatud kasutada
     * @param str kontrollitav sone
     * @return checkOperators(str)
     */
    private boolean checkProhibited(String str){
        String[] charList = str.split("");
        for(String s : charList){
            if(Prohibited.contains(s)) return false;
        }
        return checkOperators(str);
    }

    /**
     * Kontrollib operaatoreid
     * @param str kontrollitav sone
     * @return true/false
     */
    private boolean checkOperators(String str){
        /*
         * Kui on kaks operaatorit jarjest voi ekspressioon algab '^',
         * '*' voi '/' operaatoriga voi ekspressioon ongi operaator voi
         * ekspressioon loppeb operaatoriga, siis tagastab false.
         */
        return !str.matches(".*[\\+\\-\\^\\*\\/]{2,}.*|" +
                "^[\\^\\*\\/].*|" +
                "^[\\-\\+\\^\\*\\/]$|" +
                ".*[\\-\\+\\^\\*\\/]$");
    }
}
