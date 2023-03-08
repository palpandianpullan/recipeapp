package com.anb.recipeapp.util;

public class QuerySentimentUtil {

    public static String tokens =  "Maida,yogurt,oil,sugar,Gram,ghee,Carrots,milk,cashews,raisins,kewra,clarified butter,chicken,yogurt,masala";
    public static String subtokens =  "with,has,diet,as,without,vegetarian,non-vegetarian";


    public static String keywordFinder(String query){

        String[] spilitQuery = query.split(" ");
        for(int i=0;i< spilitQuery.length;i++){
            if(subtokens.contains(spilitQuery[i]) && tokens.contains(spilitQuery[i+1])){
                return spilitQuery[i+1];
            }
        }
        return null;
    }

}
