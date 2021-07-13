package com.SapientAssignmentMavenProject;
import java.util.*;
public class Dictionary {
	
	private static DictionaryService dictValidword;

	public void setDictionaryService(DictionaryService dictValidword){
	       this.dictValidword = dictValidword;
	   }

	   public static Set<String> getDictionary() {
		   
		   Set<String> dictionary = new HashSet<String>();
		   dictionary.add("chrome");
		   dictionary.add("cast");
		   dictionary.add("rome");
		   dictionary.add("east");
		   dictionary.add("me");
		   dictionary.add("ant");
		   dictionary.add("Sample");
		   
	       return dictionary;
	   }

	   public boolean isEnglishWord(String word) {
	       return dictValidword.isEnglishWord(word);
	   }
	   
      // Identify the possible combinations 
	   public static List<String> findPossibleWords(String input) {
	       ArrayList <String> matches = new ArrayList<String>();
	       Set<String> dictionary = getDictionary();
	       input = input.toLowerCase();

	       // for each word in dictionary
	       for (String word : dictionary) {
	           
	           // match flag
	           Boolean nonMatch = true;

	           for (char words : word.toCharArray()) {
	               String str = Character.toString(words);

	             
	               
	               if (word.length() - word.replace(str, "").length() != input.length() - input.replace(str, "").length()) 
	               {
	                   nonMatch = false;
	                   break;
	               }
	           }
	           if (nonMatch) {
	               matches.add(word);
	           }
	       }
	       System.out.println("English Words in a given String are: " +matches);
	       return matches;
	   }


	public static void main(String[] args) {
		
		String input="Chromecast";

		findPossibleWords(input);
	
	}

}
