package fr.eazyender.donjon.spells;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.eazyender.donjon.spells.earth.SpellEarthChocWave;
import fr.eazyender.donjon.spells.earth.SpellEarthGraplin;
import fr.eazyender.donjon.spells.earth.SpellShield;
import fr.eazyender.donjon.spells.fire.SpellEmbrasement;
import fr.eazyender.donjon.spells.fire.SpellFireProjectiles;
import fr.eazyender.donjon.spells.fire.SpellFirebolt;
import fr.eazyender.donjon.spells.fire.SpellSpatialFire;
import fr.eazyender.donjon.spells.physic.SpellDash;
import fr.eazyender.donjon.spells.physic.SpellOneTarget;
import fr.eazyender.donjon.spells.physic.SpellSpeedBoost;
import fr.eazyender.donjon.spells.poison.SpellPoisonousSacrifice;
import fr.eazyender.donjon.spells.shadow.SpellShadowSwitch;
import fr.eazyender.donjon.spells.water.SpellHealProjectile;
import fr.eazyender.donjon.spells.water.SpellIceJail;
import fr.eazyender.donjon.spells.water.SpellIceSlowDown;
import fr.eazyender.donjon.spells.water.SpellIceSlowDownAOE;
import fr.eazyender.donjon.spells.water.SpellWaterWave;
import fr.eazyender.donjon.spells.wind.SpellWindSlash;
import fr.eazyender.donjon.spells.wind.SpellWindSpear;

public class SpellUtils {
	
	/** SPELL ENTITY FRIENDLY : 
	 * -POISONOUS SACRIFICE
	 * - EARTH CHOC WAVE
	 * - SHIELD
	 * - ICE SLOWDOWN
	 * - ICE JAIL
	 * - ICE SLOWDOWN AOE
	 * - SPEEDBOOST
	 * - SHADOW SWITCH
	 * - EARTH GRAPLIN*/
	public static int spellNumber = 19;
	
	public static int getIdSpellByItem(ItemStack item) {
		
		int id = 0;
		List<ItemStack> all = new ArrayList<ItemStack>();
		
		List<String> str = new ArrayList<String>();
		str.add("�fLance une boule de feu infligeant de lourds d�g�ts");
		str.add("�4�lType�r�7 : " + "�4�lFeu" + " / " + "�7MANA");
		str.add("�4�lCo�t�r�7 : " + SpellFirebolt.basicCost);
		str.add("�4�lTemps de recharge�r�7 : " +( SpellFirebolt.basicCooldown/1000));
		ItemStack item1 = getCustomItemWithLore(Material.FEATHER, "�4�lBOULE DE FEU", false, 1, str);
		all.add(item1);
		List<String> str1 = new ArrayList<String>();
		str1.add("�fVous entoure d'un bouclier pemettant d'encaisser quelques chocs,");
		str1.add("�fN�anmoins vous �tes immobiliser pendant la dur�e du sort.");
		str1.add("�6�lType�r�7 : " + "�6�lTerre" + " / " + "�7MANA");
		str1.add("�6�lCo�t�r�7 : " + SpellShield.basicCost);
		str1.add("�6�lTemps de recharge�r�7 : " +( SpellShield.basicCooldown/1000));
		ItemStack item2 = getCustomItemWithLore(Material.FEATHER, "�6�lBOUCLIER", false, 1, str1);
		all.add(item2);
		List<String> str2 = new ArrayList<String>();
		str2.add("�fVous propulse dans la direction de votre regard.");
		str2.add("�fFaites attention, le sort ne vous prot�ge pas des d�g�ts de chute..;");
		str2.add("�6�lType�r�7 : " + "�6�lPhysique" + " / " + "�7MANA");
		str2.add("�6�lCo�t�r�7 : " + SpellDash.basicCost);
		str2.add("�6�lTemps de recharge�r�7 : " +( SpellDash.basicCooldown/1000));
		ItemStack item3 = getCustomItemWithLore(Material.FEATHER, "�6�lDASH", false, 1, str2);
		all.add(item3);
		List<String> str3 = new ArrayList<String>();
		str3.add("�fPropulse les ennemis vers le haut et les immobilise");
		str3.add("�6�lType�r�7 : " + "�6�lTERRE" + " / " + "�7MANA");
		str3.add("�6�lCo�t�r�7 : " + SpellEarthChocWave.basicCost);
		str3.add("�6�lTemps de recharge�r�7 : " +( SpellEarthChocWave.basicCooldown/1000));
		ItemStack item4 = getCustomItemWithLore(Material.FEATHER, "�6�lONDE DE CHOC", false, 1, str3);
		all.add(item4);
		List<String> str4 = new ArrayList<String>();
		str4.add("�fEnvoie une bourrasque de vent");
		str4.add("�finfligeant des dommages aux ennemis en face");
		str4.add("�7�lType�r�7 : " + "�7�lVENT" + " / " + "�7MANA");
		str4.add("�7�lCo�t�r�7 : " + SpellWindSlash.basicCost);
		str4.add("�7�lTemps de recharge�r�7 : " +( SpellWindSlash.basicCooldown/1000));
		ItemStack item5 = getCustomItemWithLore(Material.FEATHER, "�2�lCOUPURE DE VENT", false, 1, str4);
		all.add(item5);
		List<String> str5 = new ArrayList<String>();
		str5.add("�fUn rayon enflamm� frappe la cible");
		str5.add("�4�lType�r�7 : " + "�4�lFEU" + " / " + "�7MANA");
		str5.add("�4�lCo�t�r�7 : " + SpellSpatialFire.basicCost);
		str5.add("�4�lTemps de recharge�r�7 : " +( SpellSpatialFire.basicCooldown/1000));
		ItemStack item6 = getCustomItemWithLore(Material.FEATHER, "�4�lRAYON ENFLAMME", false, 1, str5);
		all.add(item6);
		List<String> str6 = new ArrayList<String>();
		str6.add("�fCapture l'ennemi dans un gla�on");
		str6.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
		str6.add("�3�lCo�t�r�7 : " + SpellIceJail.basicCost);
		str6.add("�3�lTemps de recharge�r�7 : " +( SpellIceJail.basicCooldown/1000));
		ItemStack item7 = getCustomItemWithLore(Material.FEATHER, "�3�lPRISON DE GLACE", false, 1, str6);
		all.add(item7);
		List<String> str7 = new ArrayList<String>();
		str7.add("�fLance un projectile de gu�rison");
		str7.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
		str7.add("�3�lCo�t�r�7 : " + SpellHealProjectile.basicCost);
		str7.add("�3�lTemps de recharge�r�7 : " +( SpellHealProjectile.basicCooldown/1000));
		ItemStack item8 = getCustomItemWithLore(Material.FEATHER, "�3�lGUERISON", false, 1, str7);
		all.add(item8);
		List<String> str8 = new ArrayList<String>();
		str8.add("�fD�ploie un groupe de projectile vers la cible");
		str8.add("�4�lType�r�7 : " + "�4�lFEU" + " / " + "�7MANA");
		str8.add("�4�lCo�t�r�7 : " + SpellFireProjectiles.basicCost);
		str8.add("�4�lTemps de recharge�r�7 : " +( SpellFireProjectiles.basicCooldown/1000));
		ItemStack item9 = getCustomItemWithLore(Material.FEATHER, "�4�lPROJECTILES ENFLAMMES", false, 1, str8);
		all.add(item9);
		List<String> str9 = new ArrayList<String>();
		str9.add("�fCr�er une petite explosion enflammant et");
		str9.add("�frepoussant les ennemis proche de vous.");
		str9.add("�4�lType�r�7 : " + "�4�lFEU" + " / " + "�7MANA");
		str9.add("�4�lCo�t�r�7 : " + SpellEmbrasement.basicCost);
		str9.add("�4�lTemps de recharge�r�7 : " +( SpellEmbrasement.basicCooldown/1000));
		ItemStack item10 = getCustomItemWithLore(Material.FEATHER, "�4�lEMBRASEMENT", false, 1, str9);
		all.add(item10);
		List<String> str10 = new ArrayList<String>();
		str10.add("�fForme une vague d'eau repoussant tr�s");
		str10.add("�floin les ennemis");
		str10.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
		str10.add("�3�lCo�t�r�7 : " + SpellWaterWave.basicCost);
		str10.add("�3�lTemps de recharge�r�7 : " +( SpellWaterWave.basicCooldown/1000));
		ItemStack item11 = getCustomItemWithLore(Material.FEATHER, "�3�lVAGUE", false, 1, str10);
		all.add(item11);
		List<String> str11 = new ArrayList<String>();
		str11.add("�fSacrifiez une partie de votre vie");
		str11.add("�f� la place du mana afin de vous venger");
		str11.add("�fde votre adversaire");
		str11.add("�a�lType�r�7 : " + "�a�lPOISON" + " / " + "�cVIE");
		str11.add("�a�lCo�t�r�7 : " + SpellPoisonousSacrifice.basicCost);
		str11.add("�a�lTemps de recharge�r�7 : " +( SpellPoisonousSacrifice.basicCooldown/1000));
		str11.add("�c!Peux vous tuer!");
		ItemStack item12 = getCustomItemWithLore(Material.FEATHER, "�a�lVENGEANCE EMPOISONNE", false, 1, str11);
		all.add(item12);
		List<String> str12 = new ArrayList<String>();
		str12.add("�fTirez une lance faite de vent");
		str12.add("�ftransper�ant les ennemis � votre");
		str12.add("�fplace");
		str12.add("�7�lType�r�7 : " + "�7�lVENT" + " / " + "�7MANA");
		str12.add("�7�lCo�t�r�7 : " + SpellWindSpear.basicCost);
		str12.add("�7�lTemps de recharge�r�7 : " +( SpellWindSpear.basicCooldown/1000));
		ItemStack item13 = getCustomItemWithLore(Material.FEATHER, "�7�lLANCE DE VENT", false, 1, str12);
		all.add(item13);
		List<String> str13 = new ArrayList<String>();
		str13.add("�fLance un projectile");
		str13.add("�fralentissant l'ennemi au contact");
		str13.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
		str13.add("�3�lCo�t�r�7 : " + SpellIceSlowDown.basicCost);
		str13.add("�3�lTemps de recharge�r�7 : " +( SpellIceSlowDown.basicCooldown/1000));
		ItemStack item14 = getCustomItemWithLore(Material.FEATHER, "�3�lLENTEUR DE GLACE", false, 1, str13);
		all.add(item14);
		List<String> str14 = new ArrayList<String>();
		str14.add("�fAttire tous les monstres sur vous");
		str14.add("�fdans un p�rim�tre de 10 blocs");
		str14.add("�6�lType�r�7 : " + "�6�l" + " / " + "�7MANA");
		str14.add("�6�lCo�t�r�7 : " + SpellOneTarget.basicCost);
		str14.add("�6�lTemps de recharge�r�7 : " +( SpellOneTarget.basicCooldown/1000));
		ItemStack item15 = getCustomItemWithLore(Material.FEATHER, "�6�lUNE SEUL CIBLE", false, 1, str14);
		all.add(item15);
		List<String> str15 = new ArrayList<String>();
		str15.add("�fAugmente votre vitesse pendant 1.5 secondes");
		str15.add("�6�lType�r�7 : " + "�6�lPhysique" + " / " + "�7MANA");
		str15.add("�6�lCo�t�r�7 : " + SpellSpeedBoost.basicCost);
		str15.add("�6�lTemps de recharge�r�7 : " +( SpellSpeedBoost.basicCooldown/1000));
		ItemStack item16 = getCustomItemWithLore(Material.FEATHER, "�6�lACCELERATION", false, 1, str15);
		all.add(item16);
		List<String> str16 = new ArrayList<String>();
		str16.add("�fCr�er une zone autour de vous");
		str16.add("�fralentissant les ennemis qui s'y trouve");
		str16.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
		str16.add("�3�lCo�t�r�7 : " + SpellIceSlowDownAOE.basicCost);
		str16.add("�3�lTemps de recharge�r�7 : " +( SpellIceSlowDownAOE.basicCooldown/1000));
		ItemStack item17 = getCustomItemWithLore(Material.FEATHER, "�3�lZONE LENTEUR DE GLACE", false, 1, str16);
		all.add(item17);
		List<String> str17 = new ArrayList<String>();
		str17.add("�fEnvoie un projectile qui si il touche");
		str17.add("�fchange votre position avec celle de la cible");
		str17.add("�5�lType�r�7 : " + "�5�lTENEBRE" + " / " + "�7MANA");
		str17.add("�5�lCo�t�r�7 : " + SpellShadowSwitch.basicCost);
		str17.add("�5�lTemps de recharge�r�7 : " +( SpellShadowSwitch.basicCooldown/1000));
		ItemStack item18 = getCustomItemWithLore(Material.FEATHER, "�5�lCHANGEMENT DES OMBRES", false, 1, str17);
		all.add(item18);
		List<String> str18 = new ArrayList<String>();
		str18.add("�fEnvoie un projectile qui si il touche");
		str18.add("�fram�ne la cible vers vous");
		str18.add("�6�lType�r�7 : " + "�6�lTERRE" + " / " + "�7MANA");
		str18.add("�6�lCo�t�r�7 : " + SpellEarthGraplin.basicCost);
		str18.add("�6�lTemps de recharge�r�7 : " +( SpellEarthGraplin.basicCooldown/1000));
		ItemStack item19 = getCustomItemWithLore(Material.FEATHER, "�6�lGRAPIN DES SABLES", false, 1, str18);
		all.add(item19);
		
		for (int i = 0; i < all.size(); i++) {
			if(item.equals(all.get(i))) {
				id = i+1;
			}
		}
		
		return id;
	}
	
	public static ItemStack getItemSpellById(int id) {
		
		ItemStack item = null;
		
		switch(id) {
		case 1: 
			List<String> str = new ArrayList<String>();
			str.add("�fLance une boule de feu infligeant de lourds d�g�ts");
			str.add("�4�lType�r�7 : " + "�4�lFeu" + " / " + "�7MANA");
			str.add("�4�lCo�t�r�7 : " + SpellFirebolt.basicCost);
			str.add("�4�lTemps de recharge�r�7 : " +( SpellFirebolt.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�4�lBOULE DE FEU", false, 1, str);
			break;
		case 2:
			List<String> str1 = new ArrayList<String>();
			str1.add("�fVous entoure d'un bouclier pemettant d'encaisser quelques chocs,");
			str1.add("�fN�anmoins vous �tes immobiliser pendant la dur�e du sort.");
			str1.add("�6�lType�r�7 : " + "�6�lTerre" + " / " + "�7MANA");
			str1.add("�6�lCo�t�r�7 : " + SpellShield.basicCost);
			str1.add("�6�lTemps de recharge�r�7 : " +( SpellShield.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�6�lBOUCLIER", false, 1, str1);
			break;
		case 3:
			List<String> str2 = new ArrayList<String>();
			str2.add("�fVous propulse dans la direction de votre regard.");
			str2.add("�fFaites attention, le sort ne vous prot�ge pas des d�g�ts de chute..;");
			str2.add("�6�lType�r�7 : " + "�6�lPhysique" + " / " + "�7MANA");
			str2.add("�6�lCo�t�r�7 : " + SpellDash.basicCost);
			str2.add("�6�lTemps de recharge�r�7 : " +( SpellDash.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�6�lDASH", false, 1, str2);
			break;
		case 4:
			List<String> str3 = new ArrayList<String>();
			str3.add("�fPropulse les ennemis vers le haut et les immobilise");
			str3.add("�6�lType�r�7 : " + "�6�lTERRE" + " / " + "�7MANA");
			str3.add("�6�lCo�t�r�7 : " + SpellEarthChocWave.basicCost);
			str3.add("�6�lTemps de recharge�r�7 : " +( SpellEarthChocWave.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�6�lONDE DE CHOC", false, 1, str3);
			break;
		case 5:
			List<String> str4 = new ArrayList<String>();
			str4.add("�fEnvoie une bourrasque de vent");
			str4.add("�finfligeant des dommages aux ennemis en face");
			str4.add("�7�lType�r�7 : " + "�7�lVENT" + " / " + "�7MANA");
			str4.add("�7�lCo�t�r�7 : " + SpellWindSlash.basicCost);
			str4.add("�7�lTemps de recharge�r�7 : " +( SpellWindSlash.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�2�lCOUPURE DE VENT", false, 1, str4);
			break;
		case 6:
			List<String> str5 = new ArrayList<String>();
			str5.add("�fUn rayon enflamm� frappe la cible");
			str5.add("�4�lType�r�7 : " + "�4�lFEU" + " / " + "�7MANA");
			str5.add("�4�lCo�t�r�7 : " + SpellSpatialFire.basicCost);
			str5.add("�4�lTemps de recharge�r�7 : " +( SpellSpatialFire.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�4�lRAYON ENFLAMME", false, 1, str5);
			break;
		case 7:
			List<String> str6 = new ArrayList<String>();
			str6.add("�fCapture l'ennemi dans un gla�on");
			str6.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
			str6.add("�3�lCo�t�r�7 : " + SpellIceJail.basicCost);
			str6.add("�3�lTemps de recharge�r�7 : " +( SpellIceJail.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�3�lPRISON DE GLACE", false, 1, str6);
			break;
		case 8:
			List<String> str7 = new ArrayList<String>();
			str7.add("�fLance un projectile de gu�rison");
			str7.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
			str7.add("�3�lCo�t�r�7 : " + SpellHealProjectile.basicCost);
			str7.add("�3�lTemps de recharge�r�7 : " +( SpellHealProjectile.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�3�lGUERISON", false, 1, str7);
			break;
		case 9:
			List<String> str8 = new ArrayList<String>();
			str8.add("�fD�ploie un groupe de projectile vers la cible");
			str8.add("�4�lType�r�7 : " + "�4�lFEU" + " / " + "�7MANA");
			str8.add("�4�lCo�t�r�7 : " + SpellFireProjectiles.basicCost);
			str8.add("�4�lTemps de recharge�r�7 : " +( SpellFireProjectiles.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�4�lPROJECTILES ENFLAMMES", false, 1, str8);
			break;
		case 10:
			List<String> str9 = new ArrayList<String>();
			str9.add("�fCr�er une petite explosion enflammant et");
			str9.add("�frepoussant les ennemis proche de vous.");
			str9.add("�4�lType�r�7 : " + "�4�lFEU" + " / " + "�7MANA");
			str9.add("�4�lCo�t�r�7 : " + SpellEmbrasement.basicCost);
			str9.add("�4�lTemps de recharge�r�7 : " +( SpellEmbrasement.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�4�lEMBRASEMENT", false, 1, str9);
			break;
		case 11:
			List<String> str10 = new ArrayList<String>();
			str10.add("�fForme une vague d'eau repoussant tr�s");
			str10.add("�floin les ennemis");
			str10.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
			str10.add("�3�lCo�t�r�7 : " + SpellWaterWave.basicCost);
			str10.add("�3�lTemps de recharge�r�7 : " +( SpellWaterWave.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�3�lVAGUE", false, 1, str10);
			break;
		case 12:
			List<String> str11 = new ArrayList<String>();
			str11.add("�fSacrifiez une partie de votre vie");
			str11.add("�f� la place du mana afin de vous venger");
			str11.add("�fde votre adversaire");
			str11.add("�a�lType�r�7 : " + "�a�lPOISON" + " / " + "�cVIE");
			str11.add("�a�lCo�t�r�7 : " + SpellPoisonousSacrifice.basicCost);
			str11.add("�a�lTemps de recharge�r�7 : " +( SpellPoisonousSacrifice.basicCooldown/1000));
			str11.add("�c!Peux vous tuer!");
			item = getCustomItemWithLore(Material.FEATHER, "�a�lVENGEANCE EMPOISONNE", false, 1, str11);
			break;
		case 13:
			List<String> str12 = new ArrayList<String>();
			str12.add("�fTirez une lance faite de vent");
			str12.add("�ftransper�ant les ennemis � votre");
			str12.add("�fplace");
			str12.add("�7�lType�r�7 : " + "�7�lVENT" + " / " + "�7MANA");
			str12.add("�7�lCo�t�r�7 : " + SpellWindSpear.basicCost);
			str12.add("�7�lTemps de recharge�r�7 : " +( SpellWindSpear.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�7�lLANCE DE VENT", false, 1, str12);
			break;
		case 14:
			List<String> str13 = new ArrayList<String>();
			str13.add("�fLance un projectile");
			str13.add("�fralentissant l'ennemi au contact");
			str13.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
			str13.add("�3�lCo�t�r�7 : " + SpellIceSlowDown.basicCost);
			str13.add("�3�lTemps de recharge�r�7 : " +( SpellIceSlowDown.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�3�lLENTEUR DE GLACE", false, 1, str13);
			break;
		case 15:
			List<String> str14 = new ArrayList<String>();
			str14.add("�fAttire tous les monstres sur vous");
			str14.add("�fdans un p�rim�tre de 10 blocs");
			str14.add("�6�lType�r�7 : " + "�6�l" + " / " + "�7MANA");
			str14.add("�6�lCo�t�r�7 : " + SpellOneTarget.basicCost);
			str14.add("�6�lTemps de recharge�r�7 : " +( SpellOneTarget.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�6�lUNE SEUL CIBLE", false, 1, str14);
			break;
		case 16:
			List<String> str15 = new ArrayList<String>();
			str15.add("�fAugmente votre vitesse pendant 1.5 secondes");
			str15.add("�6�lType�r�7 : " + "�6�lPhysique" + " / " + "�7MANA");
			str15.add("�6�lCo�t�r�7 : " + SpellSpeedBoost.basicCost);
			str15.add("�6�lTemps de recharge�r�7 : " +( SpellSpeedBoost.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�6�lACCELERATION", false, 1, str15);
			break;
		case 17:
			List<String> str16 = new ArrayList<String>();
			str16.add("�fCr�er une zone autour de vous");
			str16.add("�fralentissant les ennemis qui s'y trouve");
			str16.add("�3�lType�r�7 : " + "�3�lEAU" + " / " + "�7MANA");
			str16.add("�3�lCo�t�r�7 : " + SpellIceSlowDownAOE.basicCost);
			str16.add("�3�lTemps de recharge�r�7 : " +( SpellIceSlowDownAOE.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�3�lZONE LENTEUR DE GLACE", false, 1, str16);
			break;
		case 18:
			List<String> str17 = new ArrayList<String>();
			str17.add("�fEnvoie un projectile qui si il touche");
			str17.add("�fchange votre position avec celle de la cible");
			str17.add("�5�lType�r�7 : " + "�5�lTENEBRE" + " / " + "�7MANA");
			str17.add("�5�lCo�t�r�7 : " + SpellShadowSwitch.basicCost);
			str17.add("�5�lTemps de recharge�r�7 : " +( SpellShadowSwitch.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�5�lCHANGEMENT DES OMBRES", false, 1, str17);
			break;
		case 19:
			List<String> str18 = new ArrayList<String>();
			str18.add("�fEnvoie un projectile qui si il touche");
			str18.add("�fram�ne la cible vers vous");
			str18.add("�6�lType�r�7 : " + "�6�lTERRE" + " / " + "�7MANA");
			str18.add("�6�lCo�t�r�7 : " + SpellEarthGraplin.basicCost);
			str18.add("�6�lTemps de recharge�r�7 : " +( SpellEarthGraplin.basicCooldown/1000));
			item = getCustomItemWithLore(Material.FEATHER, "�6�lGRAPIN DES SABLES", false, 1, str18);
			break;
		}
		
		return item;
		
	}
	
	public static ItemStack getCustomItemWithLore(Material material, String customName, boolean EnchantEffect, int nbr, List<String> lore) {
		
		ItemStack item = new ItemStack(material, nbr);
		ItemMeta itemMeta = item.getItemMeta();
		if(lore != null) {
		itemMeta.setLore(lore);
		}
		if(customName != null) {itemMeta.setDisplayName(customName);}
		if(EnchantEffect) {itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 200, true);itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);}
		item.setItemMeta(itemMeta);
		
		
		return item;
		
	}

}
