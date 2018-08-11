/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BindingOfIsaacPackage;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author user
 */
public final class item {
    
    private String itemURL;
    private String itemName;
    private String itemEffects;
    private String itemNotes;
    private String itemInteractions;
    private String itemImageURL;
    Document document;
    
    
    //Constructor
    public item(String itemName){
        this.itemName = itemName.replace(" ", "_");
        
        getItemURL();
        
        try{
            document = Jsoup.connect(itemURL).get();
            System.out.println(itemURL);
        } catch(IOException e){
            e.printStackTrace();
        }
        getItemTitle();
        getItemEffects();
        getImageURL();
        
        System.out.println("done");
        System.out.println(itemName);
    }
    
    public String getItemURL(){
        itemURL = "https://bindingofisaacrebirth.gamepedia.com/" + itemName; ;
        System.out.println(itemURL);
        return itemURL;
    }
    
    public String getItemTitle(){
        String title;
        title = document.title(); //get title
        System.out.println(title.replace("- Binding of Isaac: Rebirth Wiki", ""));
        return itemEffects;
    }
    
    public String getImageURL(){
       //image url isnt found correctly - NOTE 
        itemImageURL = ("https://d1u5p3l4wpay3k.cloudfront.net/bindingofisaacre_gamepedia/4/41/" + itemName + "_Icon.png?");
        System.out.println(itemImageURL);
        return itemImageURL;
    }
    
    public String getItemEffects(){
        Element body = document.getElementById("bodyContent");
        Elements ul = body.getElementsByTag("ul");
        System.out.println(ul.size());
     
        Elements lis = body.getElementsByTag("li");
        for(int n = 0; n < lis.size(); n++);{
        System.out.println("list size =" + lis.size());
    }
        System.out.println("End item effects");
        return itemEffects;
    }
    
    public String getItemNotes(){
        return itemNotes;
    }
    
}
