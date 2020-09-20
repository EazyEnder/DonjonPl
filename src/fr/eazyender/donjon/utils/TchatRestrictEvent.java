package fr.eazyender.donjon.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class TchatRestrictEvent implements Listener{
	
	private static List<String> banwords = new ArrayList<String>();
	
	public static void initBanWords() {
		
		banwords.add("fuck");
		banwords.add("putain");
		banwords.add("shit");
		banwords.add("fdp");
		banwords.add("connard");
		banwords.add("con");
		banwords.add("merde");
		banwords.add("sale chien");
		banwords.add("salope");
		banwords.add("bitch");
		banwords.add("ftg");
		banwords.add("tg");
		banwords.add("ferme ta gueule");
		banwords.add("ta gueule");
		
	}
	
	@EventHandler()
	public void onPlayerSendMessage(PlayerChatEvent event)  {
		
		String message = event.getMessage();
		
		for (String word : banwords) {
			if(message.contains(word)) {
				int length = word.length();
				String replacement = "";
				for (int i = 0; i < length; i++) {
					replacement = replacement + "*";
				}
				message.replaceAll(word, replacement);
			}
		}
		
		event.setMessage(message);
		
	}
	
	

}
