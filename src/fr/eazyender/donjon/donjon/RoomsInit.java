package fr.eazyender.donjon.donjon;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class RoomsInit {
	
	public static List<IRoom> rooms_1 = new ArrayList<IRoom>();
	public static List<IRoom> rooms_2 = new ArrayList<IRoom>();
	
	public static void initRooms()
	{
		initRoomsLVL1();
		initRoomsLVL2();
	}
	
	public static void initRoomsLVL1() {
		
		List<Location> I_1_Loc = new ArrayList<Location>();
		I_1_Loc.add(new Location(null, -80, 5, -12, 180, 0)); //SPAWN
		I_1_Loc.add(new Location(null, -79, 6, -27, 0, 0)); //SORTIE
		IRoom I_1 = new IRoom(I_1_Loc, 0, 1, null, null, 0, 5, 0);
		rooms_1.add(I_1);
		
		List<Location> I_2_Loc = new ArrayList<Location>();
		I_2_Loc.add(new Location(null, -114, 7, -19, 180, 0)); //SPAWN
		I_2_Loc.add(new Location(null, -112, 7, -27, 0, 0)); //SORTIE
		IRoom I_2 = new IRoom(I_2_Loc, 0, 1, null, null, 0, 5, 0);
		rooms_1.add(I_2);
		
		List<Location> C_1_Loc = new ArrayList<Location>();
		C_1_Loc.add(new Location(null, -47, 3, -5, 180, 0)); //ENTREE
		C_1_Loc.add(new Location(null, -45, 2, -27, 0, 0)); //SORTIE
		IRoom C_1 = new IRoom(C_1_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_1);
		
		List<Location> C_2_Loc = new ArrayList<Location>();
		C_2_Loc.add(new Location(null, -15, 5, -5, 180, 0)); //ENTREE
		C_2_Loc.add(new Location(null, -15, 7, -27, 0, 0)); //SORTIE
		IRoom C_2 = new IRoom(C_2_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_2);
		
		List<Location> C_3_Loc = new ArrayList<Location>();
		C_3_Loc.add(new Location(null, 17, 3, -5, 180, 0)); //ENTREE
		C_3_Loc.add(new Location(null, 15, 6, -27, 0, 0)); //SORTIE
		IRoom C_3 = new IRoom(C_3_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_3);
		
		List<Location> C_4_Loc = new ArrayList<Location>();
		C_4_Loc.add(new Location(null, 48, 5, -5, 180, 0)); //ENTREE
		C_4_Loc.add(new Location(null, 51, 5, -27, 0, 0)); //SORTIE
		IRoom C_4 = new IRoom(C_4_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_4);
		
		List<Location> C_5_Loc = new ArrayList<Location>();
		C_5_Loc.add(new Location(null, 78, 7, -5, 180, 0)); //ENTREE
		C_5_Loc.add(new Location(null, 80, 7, -27, 0, 0)); //SORTIE
		IRoom C_5 = new IRoom(C_5_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_5);
		
		List<Location> M_1_Loc = new ArrayList<Location>();
		M_1_Loc.add(new Location(null, -66, 7, -94, 180, 0)); //ENTREE
		M_1_Loc.add(new Location(null, -66, 6, -126, 0, 0)); //SORTIE
		List<Location> M1_entity_loc = new ArrayList<Location>();
		M1_entity_loc.add(new Location(null, -57.29, 7.00, -106.74));
		M1_entity_loc.add(new Location(null, -69.69, 3.00, -115.22));
		M1_entity_loc.add(new Location(null, -64.40, 4.00, -109.50));
		M1_entity_loc.add(new Location(null, -57.51, 6.00, -113.70));
		List<String> M1_entity_type = new ArrayList<String>();
		M1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M1_entity_type.add("BUSH_ZOMBIE");
		M1_entity_type.add("BUSH_ZOMBIE");
		IRoom M_1 = new IRoom(M_1_Loc, 3, 1, M1_entity_loc, M1_entity_type, 0, 30, 3);
		rooms_1.add(M_1);
		
		List<Location> M_2_Loc = new ArrayList<Location>();
		M_2_Loc.add(new Location(null, -110.33, 3.00, -93.62, 180, 0)); //ENTREE
		M_2_Loc.add(new Location(null, -109.32, 13.00, -125.24, 0, 0)); //SORTIE
		List<Location> M2_entity_loc = new ArrayList<Location>();
		M2_entity_loc.add(new Location(null, -103.51, 13.00, -115.32));
		M2_entity_loc.add(new Location(null, -118.73, 13.00, -112.88));
		M2_entity_loc.add(new Location(null, -116.58, 12.00, -100.64));
		M2_entity_loc.add(new Location(null, -111.55, 4.00, -113.09));
		M2_entity_loc.add(new Location(null, -107.48, 15.00, -109.58));
		List<String> M2_entity_type = new ArrayList<String>();
		M2_entity_type.add("BUSH_SQUELETON");
		M2_entity_type.add("BUSH_SQUELETON");
		M2_entity_type.add("BUSH_ZOMBIE");
		M2_entity_type.add("BUSH_ZOMBIE");
		M2_entity_type.add("BUSH_PHANTOM");
		IRoom M_2 = new IRoom(M_2_Loc, 3, 1, M2_entity_loc, M2_entity_type, 0, 30, 4);
		rooms_1.add(M_2);
		
		List<Location> M_3_Loc = new ArrayList<Location>();
		M_3_Loc.add(new Location(null, -65.92, 6.00, -135.44, 180, 0)); //ENTREE
		M_3_Loc.add(new Location(null, -68.64, 6.00, -167.34, 0, 0)); //SORTIE
		List<Location> M3_entity_loc = new ArrayList<Location>();
		M3_entity_loc.add(new Location(null, -54.33, 7.00, -151.43));
		M3_entity_loc.add(new Location(null, -66.47, 6.00, -154.76));
		M3_entity_loc.add(new Location(null, -74.83, 6.00, -149.35));
		List<String> M3_entity_type = new ArrayList<String>();
		M3_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M3_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M3_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		IRoom M_3 = new IRoom(M_3_Loc, 3, 1, M3_entity_loc, M3_entity_type, 0, 25, 3);
		rooms_1.add(M_3);
		
		List<Location> M_4_Loc = new ArrayList<Location>();
		M_4_Loc.add(new Location(null, -107.78, 9.00, -135.63, 180, 0)); //ENTREE
		M_4_Loc.add(new Location(null, -106.45, 10.00, -167.25, 0, 0)); //SORTIE
		List<Location> M4_entity_loc = new ArrayList<Location>();
		M4_entity_loc.add(new Location(null, -111.41, 10.00, -155.48));
		M4_entity_loc.add(new Location(null, -96.81, 12.00, -156.26));
		M4_entity_loc.add(new Location(null, -105.03, 10.00, -146.43));
		List<String> M4_entity_type = new ArrayList<String>();
		M4_entity_type.add("BUSH_ZOMBIE");
		M4_entity_type.add("BUSH_SQUELETON");
		M4_entity_type.add("BUSH_ZOMBIE");
		IRoom M_4 = new IRoom(M_4_Loc, 3, 1, M4_entity_loc, M4_entity_type, 0, 25, 4);
		rooms_1.add(M_4);
		
		List<Location> M_5_Loc = new ArrayList<Location>();
		M_5_Loc.add(new Location(null, -66.66, 37.00, -93.65, 180, 0)); //ENTREE
		M_5_Loc.add(new Location(null, -63.34, 38.00, -125.22, 0, 0)); //SORTIE
		List<Location> M5_entity_loc = new ArrayList<Location>();
		M5_entity_loc.add(new Location(null, -60.16, 40.00, -110.40));
		M5_entity_loc.add(new Location(null, -68.40, 41.00, -114.56));
		M5_entity_loc.add(new Location(null, -63.48, 39.00, -119.47));
		M5_entity_loc.add(new Location(null, -61.64, 39.00, -103.15));
		List<String> M5_entity_type = new ArrayList<String>();
		M5_entity_type.add("BUSH_ZOMBIE");
		M5_entity_type.add("BUSH_ZOMBIE");
		M5_entity_type.add("BUSH_ZOMBIE");
		M5_entity_type.add("BUSH_ZOMBIE");
		IRoom M_5 = new IRoom(M_5_Loc, 3, 1, M5_entity_loc, M5_entity_type, 0, 30, 4);
		rooms_1.add(M_5);
		
		List<Location> M_6_Loc = new ArrayList<Location>();
		M_6_Loc.add(new Location(null, -108.63, 37.00, -93.77, 180, 0)); //ENTREE
		M_6_Loc.add(new Location(null, -106.55, 31.00, -125.40, 0, 0)); //SORTIE
		List<Location> M6_entity_loc = new ArrayList<Location>();
		M6_entity_loc.add(new Location(null, -105.46, 34.00, -103.50));
		M6_entity_loc.add(new Location(null, -108.42, 38.00, -109.55));
		M6_entity_loc.add(new Location(null, -103.51, 32.00, -120.59));
		List<String> M6_entity_type = new ArrayList<String>();
		M6_entity_type.add("BUSH_ZOMBIE");
		M6_entity_type.add("BUSH_SQUELETON");
		M6_entity_type.add("BUSH_ZOMBIE");
		IRoom M_6 = new IRoom(M_6_Loc, 3, 1, M6_entity_loc, M6_entity_type, 0, 25, 4);
		rooms_1.add(M_6);
		
		List<Location> M_7_Loc = new ArrayList<Location>();
		M_7_Loc.add(new Location(null, -62.69, 37.00, -135.64, 180, 0)); //ENTREE
		M_7_Loc.add(new Location(null, -67.20, 41.00, -167.18, 0, 0)); //SORTIE
		List<Location> M7_entity_loc = new ArrayList<Location>();
		M7_entity_loc.add(new Location(null, -56.44, 36.00, -159.75));
		M7_entity_loc.add(new Location(null, -60.51, 40.00, -163.67));
		M7_entity_loc.add(new Location(null, -73.22, 35.00, -142.24));
		M7_entity_loc.add(new Location(null, -68.43, 36.00, -150.73));
		M7_entity_loc.add(new Location(null, -59.83, 35.00, -145.00));
		List<String> M7_entity_type = new ArrayList<String>();
		M7_entity_type.add("BUSH_ZOMBIE");
		M7_entity_type.add("BUSH_SQUELETON");
		M7_entity_type.add("BUSH_ZOMBIE");
		M7_entity_type.add("BUSH_ZOMBIE");
		M7_entity_type.add("BUSH_ZOMBIE");
		IRoom M_7 = new IRoom(M_7_Loc, 3, 1, M7_entity_loc, M7_entity_type, 0, 35, 6);
		rooms_1.add(M_7);
		
		List<Location> M_8_Loc = new ArrayList<Location>();
		M_8_Loc.add(new Location(null, -110.42, 32.00, -135.83, 180, 0)); //ENTREE
		M_8_Loc.add(new Location(null, -105.08, 38.00, -167.15, 0, 0)); //SORTIE
		List<Location> M8_entity_loc = new ArrayList<Location>();
		M8_entity_loc.add(new Location(null, -103.42, 39.00, -148.53));
		M8_entity_loc.add(new Location(null, -116.59, 38.00, -151.36));
		M8_entity_loc.add(new Location(null, -116.32, 36.00, -142.47));
		M8_entity_loc.add(new Location(null, -105.58, 39.00, -160.37));
		M8_entity_loc.add(new Location(null, -109.49, 41.00, -142.44));
		List<String> M8_entity_type = new ArrayList<String>();
		M8_entity_type.add("BUSH_PHANTOM");
		M8_entity_type.add("BUSH_ZOMBIE");
		M8_entity_type.add("BUSH_ZOMBIE");
		M8_entity_type.add("BUSH_ZOMBIE");
		M8_entity_type.add("BUSH_ZOMBIE");
		IRoom M_8 = new IRoom(M_8_Loc, 3, 1, M8_entity_loc, M8_entity_type, 0, 38, 5);
		rooms_1.add(M_8);
		
		List<Location> B_1_Loc = new ArrayList<Location>();
		B_1_Loc.add(new Location(null, -33, 9, -37, 180, 0)); //ENTREE
		B_1_Loc.add(new Location(null, -33, 9, -84, 0, 0)); //SORTIE
		List<Location> B1_entity_loc = new ArrayList<Location>();
		B1_entity_loc.add(new Location(null, -38.93, 16.00, -74.51, -57.5f, 20.3f));
		B1_entity_loc.add(new Location(null, -23.59, 12.00, -46.76, 75.6f, 17.2f));
		B1_entity_loc.add(new Location(null, -47.55, 13.00, -65.42, -36.7f, 21.9f));
		B1_entity_loc.add(new Location(null, -23.54, 10.00, -54.43, 71.2f, 14.8f));
		List<String> B1_entity_type = new ArrayList<String>();
		B1_entity_type.add("BUSH_SQUELETON");
		B1_entity_type.add("BUSH_SQUELETON");
		B1_entity_type.add("BUSH_ZOMBIE");
		B1_entity_type.add("BUSH_ZOMBIE");
		IRoom B_1 = new IRoom(B_1_Loc, 4, 1, B1_entity_loc, B1_entity_type, 0, 30, 5);
		rooms_1.add(B_1);
		
		List<Location> B_2_Loc = new ArrayList<Location>();
		B_2_Loc.add(new Location(null, 26, 8, -37, 180, 0)); //ENTREE
		B_2_Loc.add(new Location(null, 15, 7, -84, 0, 0)); //SORTIE
		List<Location> B2_entity_loc = new ArrayList<Location>();
		B2_entity_loc.add(new Location(null, 25.30, 13.00, -68.38));
		B2_entity_loc.add(new Location(null, 14.51, 12.00, -60.11));
		B2_entity_loc.add(new Location(null, 35.52, 5.00, -48.76));
		B2_entity_loc.add(new Location(null, 11.26, 4.00, -63.04));
		List<String> B2_entity_type = new ArrayList<String>();
		B2_entity_type.add("BUSH_SQUELETON");
		B2_entity_type.add("BUSH_SQUELETON");
		B2_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		B2_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		IRoom B_2 = new IRoom(B_2_Loc, 4, 1, B2_entity_loc, B2_entity_type, 0, 30, 5);
		rooms_1.add(B_2);
		
		List<Location> B_3_Loc = new ArrayList<Location>();
		B_3_Loc.add(new Location(null, 76, 11, -37, 180, 0)); //ENTREE
		B_3_Loc.add(new Location(null, 76, 13, -84, 0, 0)); //SORTIE
		List<Location> B3_entity_loc = new ArrayList<Location>();
		B3_entity_loc.add(new Location(null, 84.86, 16.00, -62.64));
		B3_entity_loc.add(new Location(null,67.87, 11.00, -69.27));
		B3_entity_loc.add(new Location(null,67.87, 11.00, -69.27));
		B3_entity_loc.add(new Location(null, 80.53, 10.00, -56.74));
		B3_entity_loc.add(new Location(null, 62.79, 11.00, -55.40));
		List<String> B3_entity_type = new ArrayList<String>();
		B3_entity_type.add("BUSH_SQUELETON");
		B3_entity_type.add("BUSH_ZOMBIE");
		B3_entity_type.add("BUSH_ZOMBIE");
		B3_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		B3_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		IRoom B_3 = new IRoom(B_3_Loc, 4, 1, B3_entity_loc, B3_entity_type, 0, 30, 6);
		rooms_1.add(B_3);
		
		List<Location> H_1_Loc = new ArrayList<Location>();
		H_1_Loc.add(new Location(null, -5, 13, -94, 180, 0)); //ENTREE
		H_1_Loc.add(new Location(null, 10, 5, -166, 0, 0)); //SORTIE
		List<Location> H1_entity_loc = new ArrayList<Location>();
		H1_entity_loc.add(new Location(null, -3.69, 23.00, -126.66));
		H1_entity_loc.add(new Location(null, -13.75, 17.00, -137.77));
		H1_entity_loc.add(new Location(null, -4.51, 17.00, -137.90));
		H1_entity_loc.add(new Location(null, 5.85, 13.00, -128.39));
		H1_entity_loc.add(new Location(null, 8.77, 19.00, -122.59));
		H1_entity_loc.add(new Location(null, 7.17, 9.00, -121.61));
		H1_entity_loc.add(new Location(null, -4.57, 8.00, -127.33));
		H1_entity_loc.add(new Location(null, -13.31, 7.00, -138.37));
		H1_entity_loc.add(new Location(null, -3.62, 13.00, -128.19));
		List<String> H1_entity_type = new ArrayList<String>();
		H1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H1_entity_type.add("GRANITE_ARCHER_SQUELETON");
		H1_entity_type.add("GRANITE_ARCHER_SQUELETON");
		H1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		IRoom H_1 = new IRoom(H_1_Loc, 5, 1, H1_entity_loc, H1_entity_type, 0, 150, 11);
		rooms_1.add(H_1);
		
		List<Location> H_2_Loc = new ArrayList<Location>();
		H_2_Loc.add(new Location(null, 51.50, 25.00, -93.83, 180, 0)); //ENTREE
		H_2_Loc.add(new Location(null, 74.26, 11.00, -165.49, 0, 0)); //SORTIE
		List<Location> H2_entity_loc = new ArrayList<Location>();
		H2_entity_loc.add(new Location(null, 93.54, 11.00, -132.29));
		H2_entity_loc.add(new Location(null, 62.72, 10.00, -137.48));
		H2_entity_loc.add(new Location(null, 71.04, 10.00, -137.56));
		H2_entity_loc.add(new Location(null, 97.38, 13.00, -144.04));
		H2_entity_loc.add(new Location(null, 101.02, 13.00, -121.61));
		H2_entity_loc.add(new Location(null, 95.55, 23.33, -120.00));
		H2_entity_loc.add(new Location(null, 56.62, 19.00, -136.46));
		H2_entity_loc.add(new Location(null, 74.70, 18.00, -158.66));
		List<String> H2_entity_type = new ArrayList<String>();
		H2_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H2_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		H2_entity_type.add("BUSH_ZOMBIE");
		H2_entity_type.add("BUSH_ZOMBIE");
		H2_entity_type.add("BUSH_ZOMBIE");
		H2_entity_type.add("BUSH_PHANTOM");
		H2_entity_type.add("BUSH_PHANTOM");
		H2_entity_type.add("BUSH_PHANTOM");
		IRoom H_2 = new IRoom(H_2_Loc, 5, 1, H2_entity_loc, H2_entity_type, 0, 150, 12);
		rooms_1.add(H_2);
		
		List<Location> BOSS_1_Loc = new ArrayList<Location>();
		BOSS_1_Loc.add(new Location(null, -94, 11, -37, 180, 0)); //ENTREE
		List<Location> BOSS_1_entity_loc = new ArrayList<Location>();
		BOSS_1_entity_loc.add(new Location(null, -94.50, 11.00, -58.50, 0, 0));
		BOSS_1_entity_loc.add(new Location(null, -93.50, 11.00, -58.50, 0, 0));
		BOSS_1_entity_loc.add(new Location(null, -95.50, 11.00, -58.50, 0, 0));
		List<String> BOSS_1_entity_type = new ArrayList<String>();
		BOSS_1_entity_type.add("GRANITE_KING_SQUELETON");
		BOSS_1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		BOSS_1_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		IRoom BOSS_1 = new IRoom(BOSS_1_Loc, 6, 1, BOSS_1_entity_loc, BOSS_1_entity_type, 0, 40, 5);
		rooms_1.add(BOSS_1);
		
		List<Location> BOSS_2_Loc = new ArrayList<Location>();
		BOSS_2_Loc.add(new Location(null, -94, 11, -37, 180, 0)); //ENTREE
		List<Location> BOSS_2_entity_loc = new ArrayList<Location>();
		BOSS_2_entity_loc.add(new Location(null, -94.50, 11.00, -58.50, 0, 0));
		List<String> BOSS_2_entity_type = new ArrayList<String>();
		BOSS_2_entity_type.add("BUSH_GOLEM");
		IRoom BOSS_2 = new IRoom(BOSS_2_Loc, 6, 1, BOSS_2_entity_loc, BOSS_2_entity_type, 0, 40, 5);
		rooms_1.add(BOSS_2);
		
	}

	public static void initRoomsLVL2() {
		
		List<Location> I_1_Loc = new ArrayList<Location>();
		I_1_Loc.add(new Location(null, 96.5, 12.00, 7.5, 0, 0)); //SPAWN
		I_1_Loc.add(new Location(null, 97.5, 9.00, 24.5, 180, 0)); //SORTIE
		IRoom I_1 = new IRoom(I_1_Loc, 0, 2, null, null, 0, 5, 0);
		rooms_2.add(I_1);
		
		List<Location> I_2_Loc = new ArrayList<Location>();
		I_2_Loc.add(new Location(null, 64.5, 8.00, 9.5, 0, 0)); //SPAWN
		I_2_Loc.add(new Location(null, 62.50, 5.00, 24.79, 180, 0)); //SORTIE
		IRoom I_2 = new IRoom(I_2_Loc, 0, 2, null, null, 0, 5, 0);
		rooms_2.add(I_2);
		
		List<Location> C_1_Loc = new ArrayList<Location>();
		C_1_Loc.add(new Location(null, 32.34, 12.00, 2.76, 0, 0)); //ENTREE
		C_1_Loc.add(new Location(null, 29.53, 4.00, 24.32, 180, 0)); //SORTIE
		IRoom C_1 = new IRoom(C_1_Loc, 1, 2, null, null, 0, 10, 0);
		rooms_2.add(C_1);
		
		List<Location> C_2_Loc = new ArrayList<Location>();
		C_2_Loc.add(new Location(null, 0.36, 7.00, 2.49, 0, 0)); //ENTREE
		C_2_Loc.add(new Location(null, 1.59, 7.00, 24.65, 180, 0)); //SORTIE
		IRoom C_2 = new IRoom(C_2_Loc, 1, 2, null, null, 0, 10, 0);
		rooms_2.add(C_2);
		
		List<Location> C_3_Loc = new ArrayList<Location>();
		C_3_Loc.add(new Location(null, -30.09, 13.00, 2.43, 0, 0)); //ENTREE
		C_3_Loc.add(new Location(null, -31.27, 12.00, 24.46, 180, 0)); //SORTIE
		IRoom C_3 = new IRoom(C_3_Loc, 1, 2, null, null, 0, 10, 0);
		rooms_2.add(C_3);
		
		List<Location> C_4_Loc = new ArrayList<Location>();
		C_4_Loc.add(new Location(null, -62.87, 9.00, 2.44, 0, 0)); //ENTREE
		C_4_Loc.add(new Location(null, -65.19, 8.00, 24.24, 180, 0)); //SORTIE
		IRoom C_4 = new IRoom(C_4_Loc, 1, 2, null, null, 0, 10, 0);
		rooms_2.add(C_4);
		
		List<Location> C_5_Loc = new ArrayList<Location>();
		C_5_Loc.add(new Location(null, 32.71, 36.00, 2.67, 0, 0)); //ENTREE
		C_5_Loc.add(new Location(null, 33.26, 36.00, 24.33, 180, 0)); //SORTIE
		IRoom C_5 = new IRoom(C_5_Loc, 1, 2, null, null, 0, 10, 0);
		rooms_2.add(C_5);
		
		List<Location> M_1_Loc = new ArrayList<Location>();
		M_1_Loc.add(new Location(null, 125.72, 11.00, 91.67, 0, 0)); //ENTREE
		M_1_Loc.add(new Location(null, 114.46, 4.00, 123.34, 180, 0)); //SORTIE
		List<Location> M1_entity_loc = new ArrayList<Location>();
		M1_entity_loc.add(new Location(null, 130.48, 11.00, 107.47));
		M1_entity_loc.add(new Location(null, 117.39, 11.00, 106.47));
		M1_entity_loc.add(new Location(null, 126.50, 12.00, 114.34));
		M1_entity_loc.add(new Location(null, 125.20, 12.00, 109.44));
		M1_entity_loc.add(new Location(null, 130.48, 11.00, 107.47));
		M1_entity_loc.add(new Location(null, 117.39, 11.00, 106.47));
		M1_entity_loc.add(new Location(null, 126.50, 12.00, 114.34));
		M1_entity_loc.add(new Location(null, 125.20, 12.00, 109.44));
		List<String> M1_entity_type = new ArrayList<String>();
		M1_entity_type.add("ICE_PILLAGER");
		M1_entity_type.add("ICE_PILLAGER");
		M1_entity_type.add("ICE_PILLAGER");
		M1_entity_type.add("ICE_SKELETON");
		M1_entity_type.add("ICE_SLIME");
		M1_entity_type.add("ICE_SLIME");
		M1_entity_type.add("ICE_SLIME");
		M1_entity_type.add("ICE_SLIME");
		IRoom M_1 = new IRoom(M_1_Loc, 3, 2, M1_entity_loc, M1_entity_type, 0, 45, 13);
		rooms_2.add(M_1);
		
		List<Location> M_2_Loc = new ArrayList<Location>();
		M_2_Loc.add(new Location(null, 85.55, 10.00, 91.71, 0, 0)); //ENTREE
		M_2_Loc.add(new Location(null, 85.81, 9.00, 123.45, 180, 0)); //SORTIE
		List<Location> M_2_entity_loc = new ArrayList<Location>();
		M_2_entity_loc.add(new Location(null, 86.77, 12.00, 103.67));
		M_2_entity_loc.add(new Location(null, 94.88, 11.00, 108.42));
		M_2_entity_loc.add(new Location(null, 86.56, 12.00, 105.37));
		M_2_entity_loc.add(new Location(null, 86.77, 12.00, 103.67));
		M_2_entity_loc.add(new Location(null, 94.88, 11.00, 108.42));
		M_2_entity_loc.add(new Location(null, 86.56, 12.00, 105.37));
		List<String> M_2_entity_type = new ArrayList<String>();
		M_2_entity_type.add("ICE_PILLAGER");
		M_2_entity_type.add("ICE_PILLAGER");
		M_2_entity_type.add("SNOW_BEAR");
		M_2_entity_type.add("ICE_SLIME");
		M_2_entity_type.add("ICE_SLIME");
		M_2_entity_type.add("ICE_SLIME");
		IRoom M_2 = new IRoom(M_2_Loc, 3, 2, M_2_entity_loc, M_2_entity_type, 0, 45, 10);
		rooms_2.add(M_2);
		
		List<Location> M_3_Loc = new ArrayList<Location>();
		M_3_Loc.add(new Location(null, 55.24, 14.00, 91.83, 0, 0)); //ENTREE
		M_3_Loc.add(new Location(null, 44.08, 4.00, 123.29, 180, 0)); //SORTIE
		List<Location> M_3_entity_loc = new ArrayList<Location>();
		M_3_entity_loc.add(new Location(null, 48.63, 14.00, 107.71));
		M_3_entity_loc.add(new Location(null, 39.77, 7.00, 101.17));
		M_3_entity_loc.add(new Location(null, 50.72, 5.00, 115.08));
		M_3_entity_loc.add(new Location(null, 40.73, 7.00, 100.33));
		M_3_entity_loc.add(new Location(null, 44.42, 16.00, 108.72));
		M_3_entity_loc.add(new Location(null, 40.81, 8.00, 102.39));
		List<String> M_3_entity_type = new ArrayList<String>();
		M_3_entity_type.add("ICE_PILLAGER");
		M_3_entity_type.add("ICE_PILLAGER");
		M_3_entity_type.add("ICE_PILLAGER");
		M_3_entity_type.add("ICE_SKELETON");
		M_3_entity_type.add("ICE_BAT");
		M_3_entity_type.add("ICE_BAT");
		IRoom M_3 = new IRoom(M_3_Loc, 3, 2, M_3_entity_loc, M_3_entity_type, 0, 50, 12);
		rooms_2.add(M_3);
		
		List<Location> M_4_Loc = new ArrayList<Location>();
		M_4_Loc.add(new Location(null, -1.11, 6.00, 91.89, 0, 0)); //ENTREE
		M_4_Loc.add(new Location(null, 0.01, 11.00, 123.53, 180, 0)); //SORTIE
		List<Location> M_4_entity_loc = new ArrayList<Location>();
		M_4_entity_loc.add(new Location(null, -4.83, 12.00, 110.01));
		M_4_entity_loc.add(new Location(null, 2.96, 12.00, 107.04));
		M_4_entity_loc.add(new Location(null, -1.57, 12.00, 115.65));
		M_4_entity_loc.add(new Location(null, 1.50, 12.00, 104.96));
		M_4_entity_loc.add(new Location(null, -3.54, 13.00, 104.91));
		M_4_entity_loc.add(new Location(null, -1.34, 6.00, 96.77));
		List<String> M_4_entity_type = new ArrayList<String>();
		M_4_entity_type.add("ICE_PILLAGER");
		M_4_entity_type.add("ICE_PILLAGER");
		M_4_entity_type.add("ICE_PILLAGER");
		M_4_entity_type.add("ICE_SKELETON");
		M_4_entity_type.add("ICE_SKELETON");
		M_4_entity_type.add("ICE_SLIME");
		IRoom M_4 = new IRoom(M_4_Loc, 3, 2, M_4_entity_loc, M_4_entity_type, 0, 50, 13);
		rooms_2.add(M_4);
		
		List<Location> M_5_Loc = new ArrayList<Location>();
		M_5_Loc.add(new Location(null, -38.04, 7.00, 91.96, 0, 0)); //ENTREE
		M_5_Loc.add(new Location(null, -41.97, 7.00, 122.99, 180, 0)); //SORTIE
		List<Location> M_5_entity_loc = new ArrayList<Location>();
		M_5_entity_loc.add(new Location(null, -46.57, 16.00, 114.22));
		M_5_entity_loc.add(new Location(null, -40.20, 7.00, 103.31));
		M_5_entity_loc.add(new Location(null, -42.28, 7.00, 116.16));
		M_5_entity_loc.add(new Location(null, -40.20, 7.00, 103.31));
		M_5_entity_loc.add(new Location(null, -42.28, 7.00, 116.16));
		M_5_entity_loc.add(new Location(null, -48.59, 10.00, 109.53));
		List<String> M_5_entity_type = new ArrayList<String>();
		M_5_entity_type.add("ICE_SKELETON");
		M_5_entity_type.add("SNOW_BEAR");
		M_5_entity_type.add("SNOW_BEAR");
		M_5_entity_type.add("ICE_SLIME");
		M_5_entity_type.add("ICE_SLIME");
		M_5_entity_type.add("ICE_SKELETON");
		IRoom M_5 = new IRoom(M_5_Loc, 3, 2, M_5_entity_loc, M_5_entity_type, 0, 50, 14);
		rooms_2.add(M_5);
		
		List<Location> BOOS_1_Loc = new ArrayList<Location>();
		BOOS_1_Loc.add(new Location(null, 45.56, 15.00, 134.38, 180, 0)); //ENTREE
		List<Location> BOOS_1_entity_loc = new ArrayList<Location>();
		BOOS_1_entity_loc.add(new Location(null, 40.49, 15.00, 159.54, 0, 0));
		BOOS_1_entity_loc.add(new Location(null, 40.49+1, 15.00, 159.54, 0, 0));
		BOOS_1_entity_loc.add(new Location(null, 40.49-1, 15.00, 159.54, 0, 0));
		BOOS_1_entity_loc.add(new Location(null, 40.49, 15.00, 159.54+1, 0, 0));
		BOOS_1_entity_loc.add(new Location(null, 40.49, 15.00, 159.54-1, 0, 0));
		List<String> BOOS_1_entity_type = new ArrayList<String>();
		BOOS_1_entity_type.add("ICE_BEAR");
		BOOS_1_entity_type.add("ICE_SLIME");
		BOOS_1_entity_type.add("ICE_SLIME");
		BOOS_1_entity_type.add("ICE_SLIME");
		BOOS_1_entity_type.add("ICE_SLIME");
		IRoom BOOS_1 = new IRoom(BOOS_1_Loc, 6, 2, BOOS_1_entity_loc, BOOS_1_entity_type, 0, 40, 7);
		rooms_2.add(BOOS_1);
	}
}
