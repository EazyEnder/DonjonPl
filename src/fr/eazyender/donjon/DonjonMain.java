package fr.eazyender.donjon;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eazyender.donjon.utils.IEvent;
import fr.eazyender.donjon.utils.IMessage;
import fr.eazyender.donjon.utils.PlayerGroup;
import fr.eazyender.donjon.utils.TchatRestrictEvent;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.eazyender.donjon.arena.ArenaEvents;
import fr.eazyender.donjon.commands.CommandAccept;
import fr.eazyender.donjon.commands.CommandChromatiques;
import fr.eazyender.donjon.commands.CommandGivePotion;
import fr.eazyender.donjon.commands.CommandGiveSpell;
import fr.eazyender.donjon.commands.CommandGiveWeapon;
import fr.eazyender.donjon.commands.CommandGroup;
import fr.eazyender.donjon.commands.CommandHologrammes;
import fr.eazyender.donjon.commands.CommandMoney;
import fr.eazyender.donjon.commands.CommandNPC;
import fr.eazyender.donjon.commands.CommandReset;
import fr.eazyender.donjon.donjon.DonjonEvents;
import fr.eazyender.donjon.donjon.DonjonGenerator;
import fr.eazyender.donjon.donjon.LevelUtils;
import fr.eazyender.donjon.donjon.RoomsInit;
import fr.eazyender.donjon.donjon.events.EventSpeedRunDonjon;
import fr.eazyender.donjon.donjon.events.SpeedRunDonjonEvents;
import fr.eazyender.donjon.events.PlayerInteract;
import fr.eazyender.donjon.events.PlayerJoin;
import fr.eazyender.donjon.events.PlayerQuit;
import fr.eazyender.donjon.events.PortalInteract;
import fr.eazyender.donjon.files.PlayerArena;
import fr.eazyender.donjon.files.PlayerChromatiques;
import fr.eazyender.donjon.files.PlayerEconomy;
import fr.eazyender.donjon.files.PlayerEquipment;
import fr.eazyender.donjon.files.PlayerGroupSave;
import fr.eazyender.donjon.files.PlayerLevelStats;
import fr.eazyender.donjon.files.PlayerShop;
import fr.eazyender.donjon.gui.ArenaGui;
import fr.eazyender.donjon.gui.CraftPotionsGui;
import fr.eazyender.donjon.gui.DonjonGui;
import fr.eazyender.donjon.gui.ForgeGui;
import fr.eazyender.donjon.gui.InventoryGui;
import fr.eazyender.donjon.gui.PlayerSkillGui;
import fr.eazyender.donjon.gui.PotionGui;
import fr.eazyender.donjon.gui.RessourcesGui;
import fr.eazyender.donjon.gui.ShopGui;
import fr.eazyender.donjon.gui.ShopSpellChromaGui;
import fr.eazyender.donjon.gui.SpellGui;
import fr.eazyender.donjon.gui.WeaponGui;
import fr.eazyender.donjon.potion.ItemPotionEvent;
import fr.eazyender.donjon.potion.RecipePotions;
import fr.eazyender.donjon.spells.ColorUtils;
import fr.eazyender.donjon.spells.ItemSpellEvent;
import fr.eazyender.donjon.spells.ManaEvents;
import fr.eazyender.donjon.utils.NPCManager;
import net.minecraft.server.v1_14_R1.ChatComponentText;
import net.minecraft.server.v1_14_R1.PacketPlayOutPlayerListHeaderFooter;

public class DonjonMain extends JavaPlugin{
	
	public static DonjonMain instance;

	public static List<IEvent> events = new ArrayList<IEvent>();
	private List<IMessage> messages = new ArrayList<IMessage>();
	 private boolean tc = false;
	 
	 public static List<World> donjons = new ArrayList<World>();
	 
	 public NPCManager npcManager;
	
	@Override
	public void onEnable() 
	{
		instance = this;
		this.npcManager = new NPCManager();
		ColorUtils.initColorSkin();
		
		RoomsInit.initRooms();
		PluginManager pm = getServer().getPluginManager();
		
		getCommand("group").setExecutor(new CommandGroup());
		getCommand("accept").setExecutor(new CommandAccept());
		getCommand("money").setExecutor(new CommandMoney());
		getCommand("gspell").setExecutor(new CommandGiveSpell());
		getCommand("gpotion").setExecutor(new CommandGivePotion());
		getCommand("gweapon").setExecutor(new CommandGiveWeapon());
		getCommand("npc").setExecutor(new CommandNPC());
		getCommand("holo").setExecutor(new CommandHologrammes());
		getCommand("reset").setExecutor(new CommandReset());
		getCommand("chromatique").setExecutor(new CommandChromatiques());
		
		initMessages();
		RecipePotions.initRecipes();
		
		ManaEvents.ManaMain();
		
		/** File reading and saving */
		PlayerLevelStats file_pls = new PlayerLevelStats();
		PlayerEquipment file_eq = new PlayerEquipment();
		PlayerArena file_arena = new PlayerArena();
		PlayerEconomy file_economy = new PlayerEconomy();
		PlayerGroupSave file_groups = new PlayerGroupSave();
		PlayerChromatiques file_chromas = new PlayerChromatiques();
		PlayerShop file_shopprofil = new PlayerShop();

		/**UI*/
		pm.registerEvents(new DonjonGui()	, this);
		pm.registerEvents(new InventoryGui()	, this);
		pm.registerEvents(new PlayerSkillGui()	, this);
		pm.registerEvents(new RessourcesGui()	, this);
		pm.registerEvents(new SpellGui()	, this);
		pm.registerEvents(new WeaponGui()	, this);
		pm.registerEvents(new PotionGui()	, this);
		pm.registerEvents(new ArenaGui()	, this);
		pm.registerEvents(new CraftPotionsGui()   , this);
		pm.registerEvents(new ShopSpellChromaGui()  , this);
		pm.registerEvents(new ShopGui()  , this);
		pm.registerEvents(new ForgeGui()  , this);
		
		pm.registerEvents(new DonjonEvents(), this);
		pm.registerEvents(new ArenaEvents(), this);
		pm.registerEvents(new PortalInteract(), this);
		pm.registerEvents(new ItemSpellEvent(), this);
		pm.registerEvents(new ItemPotionEvent(), this);
		
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerQuit(), this);
		pm.registerEvents(new PlayerInteract(), this);
		
		TchatRestrictEvent.initBanWords();
		pm.registerEvents(new TchatRestrictEvent(), this);
		
		donjons.add(new WorldCreator("donjon_1").createWorld());
		donjons.add(new WorldCreator("donjon_2").createWorld());
		donjons.add(new WorldCreator("donjon_3").createWorld());
		
		for(Player p : Bukkit.getOnlinePlayers()) {LevelUtils.updateName(p); 	ColorUtils.loadPlayer(p);}
		
		loopTabList();
		launchEventLoop();
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				long time = System.currentTimeMillis() / 1000;
				int mois = 60*60*24*31;
				for(Player p : Bukkit.getOnlinePlayers()) { p.setFoodLevel(20);
				
				if(PlayerShop.getPlayerShopProfil().getGrade(p) > 0) {
					long timebuy = PlayerShop.getPlayerShopProfil().getTimeBuy(p) / 1000;
					
					if(timebuy > 0 && time - timebuy >= mois) {
						PlayerShop.getPlayerShopProfil().setTimeBuy(p, 0);
					 	PlayerShop.getPlayerShopProfil().setGrade(p, 0);
					 	p.sendMessage("§fVotre grade a expiré !");
					}
					
				}
				
				}
				
				for(OfflinePlayer p : Bukkit.getOfflinePlayers()) { 
				
				if(PlayerShop.getPlayerShopProfil().getGrade(p) > 0) {
					long timebuy = PlayerShop.getPlayerShopProfil().getTimeBuy(p) / 1000;
					
					if(timebuy > 0 && time - timebuy >= mois) {
						PlayerShop.getPlayerShopProfil().setTimeBuy(p, 0);
					 	PlayerShop.getPlayerShopProfil().setGrade(p, 0);
					}
					
				}
				
				}

				for (IMessage message: messages) {
					if(message.getTimer() >= message.getCooldown()){
						for (Player player: Bukkit.getOnlinePlayers()) {
							PlayerGroup group = PlayerGroupSave.getPlayerGroup().getGroup(player);
							if(PlayerGroup.aGroupContainPlayer(player.getUniqueId()))
							{
								group = PlayerGroup.getGroupOfAPlayer(player);
							}
							if(!DonjonGenerator.donjons.containsKey(group)){
								player.sendMessage(message.getMessage());
							}
						}
						message.setTimer(0);
					}else{
						message.setTimer(message.getTimer()+1);
					}
				}
				
			}
		}.runTaskTimer(this, 0, 20);
		
	}

	@Override
	public void onDisable() 
	{
		PlayerEquipment.getPlayerEquipment().onDisable();
		PlayerLevelStats.getPlayerLevelStats().onDisable();
		PlayerEconomy.getEconomy().onDisable();
		PlayerChromatiques.getPlayerChromatiques().onDisable();
		PlayerShop.getPlayerShopProfil().onDisable();
	}

	private void initMessages(){

		String prefix = "§f[§4Serveur§f] : ";
		messages.add(new IMessage(prefix + "Si vous rencontrez des §cbugs§r lors de l'alpha, merci de les §csignaler§r sur le discord.",60*40));
		messages.add(new IMessage(prefix + "Envie d'un §cboost xp§r, d'être bien §caccompagné§r, d'être §céclatant§r en ville? Allez voir le §c/boutique§r (permet de supporter le serveur)", 60*40, 60*10));
		messages.add(new IMessage(prefix + "Vous avez besoin d'aide ? Venez sur le discord : §chttps://discord.gg/kU4djME", 60*40, 60*20));
		messages.add(new IMessage(prefix + "Vous ne voyez que des batons, des plumes ? Téléchargez Optifine !(Le serveur nécessite optifine)", 60*40, 60*30));

	}
	
	private void launchEventLoop() {
		
		events.add(new IEvent("Boost XP Arena","L'xp que vous gagnez en arène est boosté x1.5(Durée : 15 minutes)!",20*60*15));
		events.add(new IEvent("SpeedRun Donjon","Complétez un donjon commun avec les autres joueurs le plus rapidement possible !(Durée : 20 minutes)",20*60*20));
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
				boolean oneIsActived = false;
				for (int i = 0; i < events.size(); i++) {
					if(events.get(i).isEnable()) {oneIsActived = true;}
					
				}
				if(!oneIsActived) {
					launchEvent();
				}
				
			}
		}.runTaskTimer(this, 20*60*60*2, 20*60*60*2);
		
	}
	
	private void launchEvent() {
		int chance = RandomNumber(1,events.size());
		if(chance-1 < events.size() && chance-1 >= 0) {
			IEvent event = events.get(chance-1);
			if(event != null) {
			Bukkit.broadcastMessage("§7[§bEvenement§7] §b" + event.getName() + "§r§f : " + event.getDescription());
			event.setEnable(true);
			if(event.getName().equals("SpeedRun Donjon")) {EventSpeedRunDonjon.genDonjonsEvent(15, (short)2);}
			
			new BukkitRunnable() {

				@Override
				public void run() {
					
					//END
					if(event.getName().equals("SpeedRun Donjon")) {EventSpeedRunDonjon.donjons.clear();
					String seconde = "" + EventSpeedRunDonjon.bestTime % 60;
					String minute = "" + (long) (EventSpeedRunDonjon.bestTime / 60);
					Bukkit.broadcastMessage("§7[§bEvenement§7] §b" + "Le meilleur joueur est : " + EventSpeedRunDonjon.bestPlayer + " avec un temps de : " + minute + "min et " + seconde + "s.");
					
					if(Bukkit.getPlayer(EventSpeedRunDonjon.bestPlayer) != null && EventSpeedRunDonjon.bestPlayer != "" && EventSpeedRunDonjon.bestPlayer != " ") {
						Bukkit.getPlayer(EventSpeedRunDonjon.bestPlayer).sendMessage("§7[§bEvenement§7] §b" + "Vous avez gagné " + 100 + " essences");
						PlayerEconomy.getEconomy().setEssences(Bukkit.getPlayer(EventSpeedRunDonjon.bestPlayer), PlayerEconomy.getEconomy().getEssences(Bukkit.getPlayer(EventSpeedRunDonjon.bestPlayer)) + 100);
					}
					
					EventSpeedRunDonjon.bestPlayer = "";
					EventSpeedRunDonjon.bestTime = 999999;
					//Sortir les joueurs du donjon : 
					
					}
					
					event.setEnable(false);
					Bukkit.broadcastMessage("§7[§bEvenement§7] §b" + event.getName() + "§r§f est fini !");
					
				}
				
			}.runTaskLater(this, event.getDuration());}
		}
	}
	
	private void loopTabList()
	{
		
		PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();
		new BukkitRunnable() {

			@Override
			public void run() {
				try {
					Field a = packet.getClass().getDeclaredField("header");
					a.setAccessible(true);
					Field b = packet.getClass().getDeclaredField("footer");
					b.setAccessible(true);
					
					
					if(Bukkit.getOnlinePlayers().size() == 0) return;
					for(Player ps : Bukkit.getOnlinePlayers()) {
					Object header1 = new ChatComponentText("§4§lDonjon \n§7Dawn Network\n§7-------------------"); 
					Object header2 = new ChatComponentText("§4§lDonjon \n§7By Eazy_Ender\n§7-------------------");
					Object footer = new ChatComponentText("§r§7-------------------\n"
							+ "§r§4§lInformations\n"
							+ "§7Votre Argent : §c" + PlayerEconomy.getEconomy().getMoney(ps) + "\n"
							+ "§7Vos Essences : §c" + PlayerEconomy.getEconomy().getEssences(ps) + "\n"
							+ "§7Donjons §flancés : §c" + DonjonGenerator.donjons.size() + "\n"
							+ "§r§7-------------------\n"
							+ "§r§7Joueurs§f en ligne : §c " + Bukkit.getServer().getOnlinePlayers().size()
							+ "\n§r§fVersion : §cAlpha 1.0");
					if(tc) {
						a.set(packet, header1);
						tc = false;
					}else {
						a.set(packet, header2);
						tc = true;
					}
					b.set(packet, footer);
					
						((CraftPlayer) ps).getHandle().playerConnection.sendPacket(packet);
						
						InventoryGui.updateInventory(ps);
					}
					
				}catch(NoSuchFieldException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
					
			
		}.runTaskTimer(this, 0, 20);
		
	}
	
	private static int RandomNumber(int Min , int Max)
    {
		if(Min == Max) {return Max;}
		Min = Min-1;
    	Random rand = new Random();
    	int randomNbr = rand.nextInt(Max - Min) + Min;
    	
    	if(randomNbr > Max){randomNbr = Max;}
    	if(randomNbr <= Min){randomNbr = Max;}
    return randomNbr;}
}
