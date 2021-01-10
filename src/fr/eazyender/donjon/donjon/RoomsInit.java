package fr.eazyender.donjon.donjon;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class RoomsInit {
	
	public static List<IRoom> rooms_1 = new ArrayList<IRoom>();
	public static List<IRoom> rooms_2 = new ArrayList<IRoom>();
	public static List<IRoom> rooms_3 = new ArrayList<IRoom>();
	
	public static void initRooms()
	{
		initRoomsLVL1();
		initRoomsLVL2();
		initRoomsLVL3();
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
		
		List<Location> C_6_Loc = new ArrayList<Location>();
		C_6_Loc.add(new Location(null, -44.91, 32.00, -4.87, 180, 0)); //ENTREE
		C_6_Loc.add(new Location(null, -44.96, 34.00, -26.10, 0, 0)); //SORTIE
		IRoom C_6 = new IRoom(C_6_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_6);
		
		List<Location> C_7_Loc = new ArrayList<Location>();
		C_7_Loc.add(new Location(null, -16.50, 34.00, -5.18, 180, 0)); //ENTREE
		C_7_Loc.add(new Location(null, -13.00, 32.00, -26.28, 0, 0)); //SORTIE
		IRoom C_7 = new IRoom(C_7_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_7);
		
		List<Location> C_8_Loc = new ArrayList<Location>();
		C_8_Loc.add(new Location(null, -46.96, 58.00, -4.73, 180, 0)); //ENTREE
		C_8_Loc.add(new Location(null, -46.05, 58.00, -26.08, 0, 0)); //SORTIE
		IRoom C_8 = new IRoom(C_8_Loc, 1, 1, null, null, 0, 10, 0);
		rooms_1.add(C_8);
		
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
		
		List<Location> M_9_Loc = new ArrayList<Location>();
		M_9_Loc.add(new Location(null, -109.53, 65.00, -93.76, 180, 0)); //ENTREE
		M_9_Loc.add(new Location(null, -106.57, 65.00, -125.06, 0, 0)); //SORTIE
		List<Location> M9_entity_loc = new ArrayList<Location>();
		M9_entity_loc.add(new Location(null, -113.67, 67.00, -102.18));
		M9_entity_loc.add(new Location(null, -117.37, 64.00, -115.62));
		M9_entity_loc.add(new Location(null, -101.78, 64.00, -118.29));
		M9_entity_loc.add(new Location(null, -107.33, 63.00, -113.40));
		List<String> M9_entity_type = new ArrayList<String>();
		M9_entity_type.add("BUSH_ZOMBIE");
		M9_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M9_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M9_entity_type.add("BUSH_ZOMBIE");
		IRoom M_9 = new IRoom(M_9_Loc, 3, 1, M9_entity_loc, M9_entity_type, 0, 32, 5);
		rooms_1.add(M_9);
		
		List<Location> M_10_Loc = new ArrayList<Location>();
		M_10_Loc.add(new Location(null, -69.24, 65.00, -93.80, 180, 0)); //ENTREE
		M_10_Loc.add(new Location(null, -64.37, 69.00, -125.34, 0, 0)); //SORTIE
		List<Location> M_10_entity_loc = new ArrayList<Location>();
		M_10_entity_loc.add(new Location(null, -62.36, 69.00, -119.58));
		M_10_entity_loc.add(new Location(null, -63.47, 65.00, -110.78));
		M_10_entity_loc.add(new Location(null, -69.07, 66.00, -104.59));
		M_10_entity_loc.add(new Location(null, -66.64, 64.00, -113.52));
		M_10_entity_loc.add(new Location(null, -58.72, 70.00, -117.96));
		List<String> M_10_entity_type = new ArrayList<String>();
		M_10_entity_type.add("BUSH_SQUELETON");
		M_10_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M_10_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M_10_entity_type.add("BUSH_ZOMBIE");
		M_10_entity_type.add("BUSH_ZOMBIE");
		IRoom M_10 = new IRoom(M_10_Loc, 3, 1, M_10_entity_loc, M_10_entity_type, 0, 38, 6);
		rooms_1.add(M_10);
		
		List<Location> M_11_Loc = new ArrayList<Location>();
		M_11_Loc.add(new Location(null, -154.03, 3.00, -93.59, 180, 0)); //ENTREE
		M_11_Loc.add(new Location(null, -152.45, 3.00, -125.32, 0, 0)); //SORTIE
		List<Location> M_11_entity_loc = new ArrayList<Location>();
		M_11_entity_loc.add(new Location(null, -151.90, 11.00, -111.70));
		M_11_entity_loc.add(new Location(null, -159.14, 3.00, -114.86));
		M_11_entity_loc.add(new Location(null, -162.05, 3.00, -110.49));
		M_11_entity_loc.add(new Location(null, -143.38, 4.00, -117.46));
		List<String> M_11_entity_type = new ArrayList<String>();
		M_11_entity_type.add("BUSH_SQUELETON");
		M_11_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M_11_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		M_11_entity_type.add("BUSH_ZOMBIE");
		IRoom M_11 = new IRoom(M_11_Loc, 3, 1, M_11_entity_loc, M_11_entity_type, 0, 35, 5);
		rooms_1.add(M_11);
		
		List<Location> M_12_Loc = new ArrayList<Location>();
		M_12_Loc.add(new Location(null, -150.27, 64.00, -93.60, 180, 0)); //ENTREE
		M_12_Loc.add(new Location(null, -151.90, 64.00, -125.42, 0, 0)); //SORTIE
		List<Location> M_12_entity_loc = new ArrayList<Location>();
		M_12_entity_loc.add(new Location(null, -148.50, 63.00, -110.92));
		M_12_entity_loc.add(new Location(null, -157.66, 64.00, -104.30));
		M_12_entity_loc.add(new Location(null, -150.65, 63.00, -112.44));
		M_12_entity_loc.add(new Location(null, -152.64, 68.00, -110.26));
		List<String> M_12_entity_type = new ArrayList<String>();
		M_12_entity_type.add("BUSH_ZOMBIE");
		M_12_entity_type.add("BUSH_ZOMBIE");
		M_12_entity_type.add("BUSH_ZOMBIE");
		M_12_entity_type.add("BUSH_SQUELETON");
		IRoom M_12 = new IRoom(M_12_Loc, 3, 1, M_12_entity_loc, M_12_entity_type, 0, 35, 5);
		rooms_1.add(M_12);
		
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
		
		List<Location> B_4_Loc = new ArrayList<Location>();
		B_4_Loc.add(new Location(null, -34.32, 50.00, -37.01, 180, 0)); //ENTREE
		B_4_Loc.add(new Location(null, -35.00, 49.00, -83.02, 0, 0)); //SORTIE
		List<Location> B4_entity_loc = new ArrayList<Location>();
		B4_entity_loc.add(new Location(null, -30.99, 50.00, -66.57));
		B4_entity_loc.add(new Location(null,-41.47, 49.00, -57.11));
		B4_entity_loc.add(new Location(null,-27.44, 49.00, -57.48));
		B4_entity_loc.add(new Location(null, -33.59, 49.00, -55.67));
		B4_entity_loc.add(new Location(null, -34.22, 49.00, -71.37));
		B4_entity_loc.add(new Location(null, -35.77, 50.00, -61.66));
		List<String> B4_entity_type = new ArrayList<String>();
		B4_entity_type.add("BUSH_ZOMBIE");
		B4_entity_type.add("BUSH_ZOMBIE");
		B4_entity_type.add("BUSH_ZOMBIE");
		B4_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		B4_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		B4_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		IRoom B_4 = new IRoom(B_4_Loc, 4, 1, B4_entity_loc, B4_entity_type, 0, 40, 7);
		rooms_1.add(B_4);
		
		List<Location> B_5_Loc = new ArrayList<Location>();
		B_5_Loc.add(new Location(null, 22.71, 50.00, -36.80, 180, 0)); //ENTREE
		B_5_Loc.add(new Location(null, 22.07, 49.00, -83.04, 0, 0)); //SORTIE
		List<Location> B5_entity_loc = new ArrayList<Location>();
		B5_entity_loc.add(new Location(null, 33.40, 40.00, -69.84));
		B5_entity_loc.add(new Location(null,30.29, 41.00, -45.84));
		B5_entity_loc.add(new Location(null, 5.41, 40.00, -53.33));
		B5_entity_loc.add(new Location(null, 15.93, 41.00, -76.07));
		B5_entity_loc.add(new Location(null, 5.26, 43.00, -46.68));
		B5_entity_loc.add(new Location(null, 37.10, 41.00, -60.95));
		List<String> B5_entity_type = new ArrayList<String>();
		B5_entity_type.add("BUSH_ZOMBIE");
		B5_entity_type.add("BUSH_ZOMBIE");
		B5_entity_type.add("BUSH_ZOMBIE");
		B5_entity_type.add("BUSH_SQUELETON");
		B5_entity_type.add("BUSH_SQUELETON");
		B5_entity_type.add("BUSH_SQUELETON");
		IRoom B_5 = new IRoom(B_5_Loc, 4, 1, B5_entity_loc, B5_entity_type, 0, 52, 7);
		rooms_1.add(B_5);
		
		List<Location> B_6_Loc = new ArrayList<Location>();
		B_6_Loc.add(new Location(null, 70.28, 45.00, -36.92, 180, 0)); //ENTREE
		B_6_Loc.add(new Location(null, 94.05, 44.00, -82.83, 0, 0)); //SORTIE
		List<Location> B6_entity_loc = new ArrayList<Location>();
		B6_entity_loc.add(new Location(null, 85.01, 45.00, -59.12));
		B6_entity_loc.add(new Location(null,72.25, 45.00, -60.52));
		B6_entity_loc.add(new Location(null, 89.67, 45.00, -71.41));
		B6_entity_loc.add(new Location(null, 86.12, 44.00, -52.59));
		B6_entity_loc.add(new Location(null, 88.92, 45.00, -60.65));
		B6_entity_loc.add(new Location(null, 79.20, 45.00, -73.04));
		List<String> B6_entity_type = new ArrayList<String>();
		B6_entity_type.add("GRANITE_KNIGHT_SQUELETON");
		B6_entity_type.add("BUSH_ZOMBIE");
		B6_entity_type.add("BUSH_ZOMBIE");
		B6_entity_type.add("BUSH_ZOMBIE");
		B6_entity_type.add("BUSH_SQUELETON");
		B6_entity_type.add("BUSH_SQUELETON");
		IRoom B_6 = new IRoom(B_6_Loc, 4, 1, B6_entity_loc, B6_entity_type, 0, 40, 7);
		rooms_1.add(B_6);
		
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
		M1_entity_type.add("FROZEN_ZOMBIE");
		M1_entity_type.add("FROZEN_ZOMBIE");
		M1_entity_type.add("FROZEN_ZOMBIE");
		M1_entity_type.add("ICE_SQUELETON");
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
		M_2_entity_type.add("FROZEN_ZOMBIE");
		M_2_entity_type.add("FROZEN_ZOMBIE");
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
		M_3_entity_type.add("FROZEN_ZOMBIE");
		M_3_entity_type.add("FROZEN_ZOMBIE");
		M_3_entity_type.add("FROZEN_ZOMBIE");
		M_3_entity_type.add("ICE_SQUELETON");
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
		M_4_entity_type.add("FROZEN_ZOMBIE");
		M_4_entity_type.add("FROZEN_ZOMBIE");
		M_4_entity_type.add("FROZEN_ZOMBIE");
		M_4_entity_type.add("ICE_SQUELETON");
		M_4_entity_type.add("ICE_SQUELETON");
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
		M_5_entity_type.add("ICE_SQUELETON");
		M_5_entity_type.add("SNOW_BEAR");
		M_5_entity_type.add("SNOW_BEAR");
		M_5_entity_type.add("ICE_SLIME");
		M_5_entity_type.add("ICE_SLIME");
		M_5_entity_type.add("ICE_SQUELETON");
		IRoom M_5 = new IRoom(M_5_Loc, 3, 2, M_5_entity_loc, M_5_entity_type, 0, 50, 14);
		rooms_2.add(M_5);
		
		List<Location> B_1_Loc = new ArrayList<Location>();
		B_1_Loc.add(new Location(null, 108.87, 11.00, 34.95, 0, 0)); //ENTREE
		B_1_Loc.add(new Location(null,103.82, 6.00, 81.25, 180, 0)); //SORTIE
		List<Location> B_1_entity_loc = new ArrayList<Location>();
		B_1_entity_loc.add(new Location(null, 101.76, 7.00, 68.25));
		B_1_entity_loc.add(new Location(null, 105.35, 8.00, 56.59));
		B_1_entity_loc.add(new Location(null, 97.83, 13.00, 69.69));
		B_1_entity_loc.add(new Location(null, 100.13, 14.00, 50.36));
		B_1_entity_loc.add(new Location(null, 118.47, 13.00, 51.23));
		B_1_entity_loc.add(new Location(null, 110.43, 16.00, 65.44));
		B_1_entity_loc.add(new Location(null, 119.55, 11.00, 66.31));
		B_1_entity_loc.add(new Location(null, 112.20, 16.00, 52.58));
		B_1_entity_loc.add(new Location(null, 99.74, 8.00, 64.54));
		List<String> B_1_entity_type = new ArrayList<String>();
		B_1_entity_type.add("FROZEN_ZOMBIE");
		B_1_entity_type.add("FROZEN_ZOMBIE");
		B_1_entity_type.add("ICE_SQUELETON");
		B_1_entity_type.add("ICE_SQUELETON");
		B_1_entity_type.add("FROZEN_ZOMBIE");
		B_1_entity_type.add("FROZEN_ZOMBIE");
		B_1_entity_type.add("FROZEN_ZOMBIE");
		B_1_entity_type.add("ICE_BAT");
		B_1_entity_type.add("ICE_BAT");
		IRoom B_1 = new IRoom(B_1_Loc, 4, 2, B_1_entity_loc, B_1_entity_type, 0, 75, 21);
		rooms_2.add(B_1);
		
		List<Location> B_2_Loc = new ArrayList<Location>();
		B_2_Loc.add(new Location(null, 50.88, 8.00, 34.90, 0, 0)); //ENTREE
		B_2_Loc.add(new Location(null, 52.21, 8.00, 81.06, 180, 0)); //SORTIE
		List<Location> B_2_entity_loc = new ArrayList<Location>();
		B_2_entity_loc.add(new Location(null, 44.98, 8.00, 46.29));
		B_2_entity_loc.add(new Location(null, 51.73, 8.00, 54.57));
		B_2_entity_loc.add(new Location(null, 67.81, 8.00, 47.09));
		B_2_entity_loc.add(new Location(null, 61.43, 8.00, 67.52));
		B_2_entity_loc.add(new Location(null, 37.30, 7.00, 65.94));
		B_2_entity_loc.add(new Location(null, 35.89, 7.00, 49.52));
		B_2_entity_loc.add(new Location(null, 52.81, 8.00, 58.24));
		B_2_entity_loc.add(new Location(null, 44.98, 8.00, 46.29));
		B_2_entity_loc.add(new Location(null, 51.73, 8.00, 54.57));
		B_2_entity_loc.add(new Location(null, 67.81, 8.00, 47.09));
		B_2_entity_loc.add(new Location(null, 61.43, 8.00, 67.52));
		B_2_entity_loc.add(new Location(null, 37.30, 7.00, 65.94));
		B_2_entity_loc.add(new Location(null, 35.89, 7.00, 49.52));
		B_2_entity_loc.add(new Location(null, 52.81, 8.00, 58.24));
		List<String> B_2_entity_type = new ArrayList<String>();
		B_2_entity_type.add("ICE_ZOMBIE");
		B_2_entity_type.add("ICE_ZOMBIE");
		B_2_entity_type.add("ICE_ZOMBIE");
		B_2_entity_type.add("ICE_ZOMBIE");
		B_2_entity_type.add("ICE_ZOMBIE");
		B_2_entity_type.add("ICE_ZOMBIE");
		B_2_entity_type.add("ICE_ZOMBIE");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_SLIME");
		IRoom B_2 = new IRoom(B_2_Loc, 4, 2, B_2_entity_loc, B_2_entity_type, 0, 75, 21);
		rooms_2.add(B_2);
		
		List<Location> B_3_Loc = new ArrayList<Location>();
		B_3_Loc.add(new Location(null, 9.95, 7.00, 34.85, 0, 0)); //ENTREE
		B_3_Loc.add(new Location(null, 2.99, 5.00, 81.21, 180, 0)); //SORTIE
		List<Location> B_3_entity_loc = new ArrayList<Location>();
		B_3_entity_loc.add(new Location(null, -6.19, 4.00, 65.93));
		B_3_entity_loc.add(new Location(null, -10.07, 4.00, 45.56));
		B_3_entity_loc.add(new Location(null, -19.96, 9.00, 40.28));
		B_3_entity_loc.add(new Location(null, -20.17, 15.00, 45.61));
		B_3_entity_loc.add(new Location(null, -1.86, 16.00, 48.75));
		B_3_entity_loc.add(new Location(null, 4.68, 10.00, 58.57));
		B_3_entity_loc.add(new Location(null, 0.56, 7.00, 43.25));
		B_3_entity_loc.add(new Location(null, -6.19, 4.00, 65.93));
		B_3_entity_loc.add(new Location(null, -10.07, 4.00, 45.56));
		B_3_entity_loc.add(new Location(null, -1.86, 16.00, 48.75));
		B_3_entity_loc.add(new Location(null, 4.68, 10.00, 58.57));
		B_3_entity_loc.add(new Location(null, 0.56, 7.00, 43.25));
		List<String> B_3_entity_type = new ArrayList<String>();
		B_3_entity_type.add("FROZEN_ZOMBIE");
		B_3_entity_type.add("FROZEN_ZOMBIE");
		B_3_entity_type.add("ICE_ZOMBIE");
		B_3_entity_type.add("ICE_SQUELETON");
		B_3_entity_type.add("FROZEN_ZOMBIE");
		B_3_entity_type.add("FROZEN_ZOMBIE");
		B_3_entity_type.add("FROZEN_ZOMBIE");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_BAT");
		B_2_entity_type.add("ICE_SLIME");
		B_2_entity_type.add("ICE_BAT");
		B_2_entity_type.add("ICE_SLIME");
		IRoom B_3 = new IRoom(B_3_Loc, 4, 2, B_3_entity_loc, B_3_entity_type, 0, 80, 24);
		rooms_2.add(B_3);
		
		List<Location> B_4_Loc = new ArrayList<Location>();
		B_4_Loc.add(new Location(null, -58.89, 13.00, 35.02, 0, 0)); //ENTREE
		B_4_Loc.add(new Location(null, -58.89, 13.00, 35.02, 180, 0)); //SORTIE
		List<Location> B_4_entity_loc = new ArrayList<Location>();
		B_4_entity_loc.add(new Location(null, -69.22, 18.00, 59.68));
		B_4_entity_loc.add(new Location(null, -47.06, 17.00, 59.10));
		B_4_entity_loc.add(new Location(null, -51.37, 18.00, 48.85));
		B_4_entity_loc.add(new Location(null, -60.77, 12.00, 62.33));
		B_4_entity_loc.add(new Location(null, -45.65, 10.00, 57.03));
		B_4_entity_loc.add(new Location(null, -55.26, 12.00, 68.13));
		B_4_entity_loc.add(new Location(null, -61.32, 12.00, 61.97));
		B_4_entity_loc.add(new Location(null, -66.59, 5.00, 59.08));
		List<String> B_4_entity_type = new ArrayList<String>();
		B_4_entity_type.add("ICE_SQUELETON");
		B_4_entity_type.add("ICE_SQUELETON");
		B_4_entity_type.add("FROZEN_ZOMBIE");
		B_4_entity_type.add("FROZEN_ZOMBIE");
		B_4_entity_type.add("FROZEN_ZOMBIE");
		B_4_entity_type.add("FROZEN_ZOMBIE");
		B_4_entity_type.add("SNOW_BEAR");
		B_2_entity_type.add("FROZEN_ZOMBIE");
		IRoom B_4 = new IRoom(B_4_Loc, 4, 2, B_4_entity_loc, B_4_entity_type, 0, 65, 22);
		rooms_2.add(B_4);
		
		List<Location> H_1_Loc = new ArrayList<Location>();
		H_1_Loc.add(new Location(null, 128.22, 8.00, 133.59, 0, 0)); //ENTREE
		H_1_Loc.add(new Location(null, 112.98, 15.00, 204.98, 180, 0)); //SORTIE
		List<Location> H1_entity_loc = new ArrayList<Location>();
		H1_entity_loc.add(new Location(null, 114.08, 18.00, 164.34));
		H1_entity_loc.add(new Location(null, 106.56, 22.00, 172.55));
		H1_entity_loc.add(new Location(null, 116.37, 16.00, 180.62));
		H1_entity_loc.add(new Location(null, 130.33, 22.00, 158.53));
		H1_entity_loc.add(new Location(null, 108.91, 8.00, 153.17));
		H1_entity_loc.add(new Location(null, 117.64, 10.00, 170.63));
		H1_entity_loc.add(new Location(null, 132.74, 10.00, 175.05));
		H1_entity_loc.add(new Location(null, 94.34, 10.00, 172.80));
		H1_entity_loc.add(new Location(null, 109.26, 14.00, 198.54));
		H1_entity_loc.add(new Location(null, 117.53, 16.00, 180.80));
		H1_entity_loc.add(new Location(null, 106.07, 22.00, 178.91));
		H1_entity_loc.add(new Location(null, 89.71, 23.00, 170.79));
		H1_entity_loc.add(new Location(null, 103.97, 26.00, 166.20));
		H1_entity_loc.add(new Location(null, 124.66, 23.00, 157.71));
		H1_entity_loc.add(new Location(null, 137.68, 23.00, 169.18));
		H1_entity_loc.add(new Location(null, 122.54, 18.00, 159.28));
		H1_entity_loc.add(new Location(null, 102.56, 18.00, 164.39));
		List<String> H1_entity_type = new ArrayList<String>();
		H1_entity_type.add("ICE_SQUELETON");
		H1_entity_type.add("ICE_SQUELETON");
		H1_entity_type.add("ICE_SQUELETON");
		H1_entity_type.add("ICE_SQUELETON");
		H1_entity_type.add("ICE_ZOMBIE");
		H1_entity_type.add("ICE_ZOMBIE");
		H1_entity_type.add("ICE_ZOMBIE");
		H1_entity_type.add("ICE_ZOMBIE");
		H1_entity_type.add("SNOW_BEAR");
		H1_entity_type.add("FROZEN_ZOMBIE");
		H1_entity_type.add("FROZEN_ZOMBIE");
		H1_entity_type.add("FROZEN_ZOMBIE");
		H1_entity_type.add("FROZEN_ZOMBIE");
		H1_entity_type.add("FROZEN_ZOMBIE");
		H1_entity_type.add("FROZEN_ZOMBIE");
		H1_entity_type.add("FROZEN_ZOMBIE");
		H1_entity_type.add("FROZEN_ZOMBIE");
		IRoom H_1 = new IRoom(H_1_Loc, 5, 2, H1_entity_loc, H1_entity_type, 0, 200, 40);
		rooms_2.add(H_1);
		
		List<Location> BOOS_1_Loc = new ArrayList<Location>();
		BOOS_1_Loc.add(new Location(null, 45.56, 15.00, 134.38, 0, 0)); //ENTREE
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
		IRoom BOOS_1 = new IRoom(BOOS_1_Loc, 6, 2, BOOS_1_entity_loc, BOOS_1_entity_type, 0, 60, 50);
		rooms_2.add(BOOS_1);
	}

	public static void initRoomsLVL3() {
		
		List<Location> I_1_Loc = new ArrayList<Location>();
		I_1_Loc.add(new Location(null, -139.48, 16.00, 16.52, 0, 0)); //SPAWN
		I_1_Loc.add(new Location(null, -139.21, 13.00, 33.53, 180, 0)); //SORTIE
		IRoom I_1 = new IRoom(I_1_Loc, 0, 3, null, null, 0, 10, 0);
		rooms_3.add(I_1);
		
		List<Location> C_1_Loc = new ArrayList<Location>();
		C_1_Loc.add(new Location(null, -10.27, 13.00, 11.69, 0, 0)); //ENTREE
		C_1_Loc.add(new Location(null, -14.62, 9.00, 33.37, 180, 0)); //SORTIE
		IRoom C_1 = new IRoom(C_1_Loc, 1, 3, null, null, 0, 10, 0);
		rooms_3.add(C_1);
		
		List<Location> C_2_Loc = new ArrayList<Location>();
		C_2_Loc.add(new Location(null, -42.19, 14.00, 11.94, 0, 0)); //ENTREE
		C_2_Loc.add(new Location(null, -38.95, 13.00, 33.40, 180, 0)); //SORTIE
		IRoom C_2 = new IRoom(C_2_Loc, 1, 3, null, null, 0, 10, 0);
		rooms_3.add(C_2);
		
		List<Location> C_3_Loc = new ArrayList<Location>();
		C_3_Loc.add(new Location(null, -80.97, 12.00, 12.00, 0, 0)); //ENTREE
		C_3_Loc.add(new Location(null, -76.99, 12.00, 33.12, 180, 0)); //SORTIE
		IRoom C_3 = new IRoom(C_3_Loc, 1, 3, null, null, 0, 10, 0);
		rooms_3.add(C_3);
		
		List<Location> C_4_Loc = new ArrayList<Location>();
		C_4_Loc.add(new Location(null, -110.98, 11.00, 11.73, 0, 0)); //ENTREE
		C_4_Loc.add(new Location(null, -108.01, 11.00, 33.37, 180, 0)); //SORTIE
		IRoom C_4 = new IRoom(C_4_Loc, 1, 3, null, null, 0, 10, 0);
		rooms_3.add(C_4);
		
		List<Location> C_5_Loc = new ArrayList<Location>();
		C_5_Loc.add(new Location(null, -9.46, 38.00, 11.96, 0, 0)); //ENTREE
		C_5_Loc.add(new Location(null, -12.43, 38.00, 33.30, 180, 0)); //SORTIE
		IRoom C_5 = new IRoom(C_5_Loc, 1, 3, null, null, 0, 10, 0);
		rooms_3.add(C_5);
		
		List<Location> C_6_Loc = new ArrayList<Location>();
		C_6_Loc.add(new Location(null, -43.01, 40.00, 11.70, 0, 0)); //ENTREE
		C_6_Loc.add(new Location(null, -44.52, 41.00, 33.35, 180, 0)); //SORTIE
		IRoom C_6 = new IRoom(C_6_Loc, 1, 3, null, null, 0, 10, 0);
		rooms_3.add(C_6);
		
		List<Location> M_1_Loc = new ArrayList<Location>();
		M_1_Loc.add(new Location(null, -12.89, 11.00, 101.04, 0, 0)); //ENTREE
		M_1_Loc.add(new Location(null, -17.03, 11.00, 132.35, 180, 0)); //SORTIE
		List<Location> M1_entity_loc = new ArrayList<Location>();
		M1_entity_loc.add(new Location(null,-7.88, 10.00, 113.50));
		M1_entity_loc.add(new Location(null, -21.39, 11.00, 125.11));
		M1_entity_loc.add(new Location(null, -16.41, 11.00, 113.08));
		M1_entity_loc.add(new Location(null,-25.39, 19.00, 117.83));
		M1_entity_loc.add(new Location(null,-6.50, 18.00, 124.13));
		M1_entity_loc.add(new Location(null,-18.76, 19.00, 120.16));
		M1_entity_loc.add(new Location(null,-7.67, 18.00, 123.18));
		M1_entity_loc.add(new Location(null,-25.77, 18.00, 127.64));
		List<String> M1_entity_type = new ArrayList<String>();
		M1_entity_type.add("BONE_SILVERFISH");
		M1_entity_type.add("BONE_SILVERFISH");
		M1_entity_type.add("MOMIE_ZOMBIE");
		M1_entity_type.add("MOMIE_ZOMBIE");
		M1_entity_type.add("MOMIE_ZOMBIE");
		M1_entity_type.add("SAND_SQUELETON");
		M1_entity_type.add("SAND_SQUELETON");
		M1_entity_type.add("SAND_SQUELETON");
		IRoom M_1 = new IRoom(M_1_Loc, 3, 3, M1_entity_loc, M1_entity_type, 0, 45, 30);
		rooms_3.add(M_1);
		
		List<Location> M_2_Loc = new ArrayList<Location>();
		M_2_Loc.add(new Location(null, -57.02, 12.00, 100.86, 0, 0)); //ENTREE
		M_2_Loc.add(new Location(null, -56.85, 20.00, 132.43, 180, 0)); //SORTIE
		List<Location> M_2_entity_loc = new ArrayList<Location>();
		M_2_entity_loc.add(new Location(null,-62.66, 15.00, 123.43));
		M_2_entity_loc.add(new Location(null, -65.92, 13.00, 120.29));
		M_2_entity_loc.add(new Location(null, -66.42, 12.00, 106.84));
		M_2_entity_loc.add(new Location(null,-49.19, 21.00, 115.56));
		M_2_entity_loc.add(new Location(null,-57.37, 13.00, 120.77));
		M_2_entity_loc.add(new Location(null,-59.59, 21.00, 127.51));
		M_2_entity_loc.add(new Location(null,-50.12, 13.00, 110.56));
		List<String> M_2_entity_type = new ArrayList<String>();
		M_2_entity_type.add("BONE_SILVERFISH");
		M_2_entity_type.add("BONE_SILVERFISH");
		M_2_entity_type.add("MOMIE_ZOMBIE");
		M_2_entity_type.add("MOMIE_ZOMBIE");
		M_2_entity_type.add("SAND_SQUELETON");
		M_2_entity_type.add("SAND_SQUELETON");
		M_2_entity_type.add("SAND_SQUELETON");
		IRoom M_2 = new IRoom(M_2_Loc, 3, 3, M_2_entity_loc, M_2_entity_type, 0, 40, 25);
		rooms_3.add(M_2);
		
		List<Location> M_3_Loc = new ArrayList<Location>();
		M_3_Loc.add(new Location(null, -98.40, 14.00, 100.85, 0, 0)); //ENTREE
		M_3_Loc.add(new Location(null, -98.03, 12.00, 132.09, 180, 0)); //SORTIE
		List<Location> M_3_entity_loc = new ArrayList<Location>();
		M_3_entity_loc.add(new Location(null,-94.50, 14.00, 117.66));
		M_3_entity_loc.add(new Location(null, -96.17, 14.00, 121.62));
		M_3_entity_loc.add(new Location(null, -90.98, 15.00, 116.87));
		M_3_entity_loc.add(new Location(null,-102.08, 15.00, 115.21));
		M_3_entity_loc.add(new Location(null,-100.52, 14.00, 120.16));
		M_3_entity_loc.add(new Location(null,-110.75, 18.00, 114.28));
		M_3_entity_loc.add(new Location(null,-95.51, 14.00, 121.12));
		List<String> M_3_entity_type = new ArrayList<String>();
		M_3_entity_type.add("BONE_SILVERFISH");
		M_3_entity_type.add("BONE_SILVERFISH");
		M_3_entity_type.add("BONE_SILVERFISH");
		M_3_entity_type.add("BONE_SILVERFISH");
		M_3_entity_type.add("BONE_SILVERFISH");
		M_3_entity_type.add("ANCIENT_SQUELETON");
		M_3_entity_type.add("SAND_SQUELETON");
		IRoom M_3 = new IRoom(M_3_Loc, 3, 3, M_3_entity_loc, M_3_entity_type, 0, 35, 20);
		rooms_3.add(M_3);
		
		List<Location> M_4_Loc = new ArrayList<Location>();
		M_4_Loc.add(new Location(null, -139.87, 17.00, 100.74, 0, 0)); //ENTREE
		M_4_Loc.add(new Location(null, -140.42, 12.00, 132.12, 180, 0)); //SORTIE
		List<Location> M_4_entity_loc = new ArrayList<Location>();
		M_4_entity_loc.add(new Location(null,-146.05, 16.00, 107.89));
		M_4_entity_loc.add(new Location(null, -133.49, 19.00, 120.26));
		M_4_entity_loc.add(new Location(null, -136.95, 20.00, 109.73));
		M_4_entity_loc.add(new Location(null,-146.15, 17.00, 106.28));
		M_4_entity_loc.add(new Location(null,-150.18, 17.00, 122.98));
		M_4_entity_loc.add(new Location(null,-132.67, 19.00, 120.66));
		List<String> M_4_entity_type = new ArrayList<String>();
		M_4_entity_type.add("MOMIE_ZOMBIE");
		M_4_entity_type.add("MOMIE_ZOMBIE");
		M_4_entity_type.add("MOMIE_ZOMBIE");
		M_4_entity_type.add("SAND_SPIDER");
		M_4_entity_type.add("SAND_SPIDER");
		M_4_entity_type.add("SAND_SPIDER");
		IRoom M_4 = new IRoom(M_4_Loc, 3, 3, M_4_entity_loc, M_4_entity_type, 0, 35, 24);
		rooms_3.add(M_4);
		
		List<Location> M_5_Loc = new ArrayList<Location>();
		M_5_Loc.add(new Location(null, -17.37, 43.00, 100.80, 0, 0)); //ENTREE
		M_5_Loc.add(new Location(null, -10.21, 51.00, 132.34, 180, 0)); //SORTIE
		List<Location> M_5_entity_loc = new ArrayList<Location>();
		M_5_entity_loc.add(new Location(null,-11.18, 51.00, 125.78));
		M_5_entity_loc.add(new Location(null, -9.27, 51.00, 120.14));
		M_5_entity_loc.add(new Location(null, -6.60, 47.00, 121.43));
		M_5_entity_loc.add(new Location(null,-6.01, 45.00, 110.62));
		M_5_entity_loc.add(new Location(null,-18.65, 48.00, 121.36));
		M_5_entity_loc.add(new Location(null,-14.28, 50.00, 113.40));
		List<String> M_5_entity_type = new ArrayList<String>();
		M_5_entity_type.add("SAND_SQUELETON");
		M_5_entity_type.add("SAND_SQUELETON");
		M_5_entity_type.add("MOMIE_ZOMBIE");
		M_5_entity_type.add("SAND_SPIDER");
		M_5_entity_type.add("SAND_SPIDER");
		M_5_entity_type.add("SAND_SPIDER");
		IRoom M_5 = new IRoom(M_5_Loc, 3, 3, M_5_entity_loc, M_5_entity_type, 0, 35, 22);
		rooms_3.add(M_5);
		
		List<Location> M_6_Loc = new ArrayList<Location>();
		M_6_Loc.add(new Location(null, -57.98, 42.00, 100.74, 0, 0)); //ENTREE
		M_6_Loc.add(new Location(null, -52.03, 42.00, 132.49, 180, 0)); //SORTIE
		List<Location> M_6_entity_loc = new ArrayList<Location>();
		M_6_entity_loc.add(new Location(null,-62.31, 45.00, 114.61));
		M_6_entity_loc.add(new Location(null, -56.67, 45.00, 113.26));
		M_6_entity_loc.add(new Location(null, -51.76, 43.00, 125.54));
		M_6_entity_loc.add(new Location(null,-55.29, 43.00, 110.39));
		List<String> M_6_entity_type = new ArrayList<String>();
		M_6_entity_type.add("BONE_SILVERFISH");
		M_6_entity_type.add("BONE_SILVERFISH");
		M_6_entity_type.add("BONE_GOLEM");
		M_6_entity_type.add("BONE_SILVERFISH");
		IRoom M_6 = new IRoom(M_6_Loc, 3, 3, M_6_entity_loc, M_6_entity_type, 0, 35, 20);
		rooms_3.add(M_6);
		
		List<Location> M_7_Loc = new ArrayList<Location>();
		M_7_Loc.add(new Location(null, -91.38, 50.00, 100.80, 0, 0)); //ENTREE
		M_7_Loc.add(new Location(null, -106.35, 38.00, 132.22, 180, 0)); //SORTIE
		List<Location> M_7_entity_loc = new ArrayList<Location>();
		M_7_entity_loc.add(new Location(null,-97.52, 47.00, 115.84));
		M_7_entity_loc.add(new Location(null, -107.74, 41.00, 108.79));
		M_7_entity_loc.add(new Location(null, -101.67, 39.00, 111.88));
		M_7_entity_loc.add(new Location(null,-106.18, 38.00, 127.99));
		M_7_entity_loc.add(new Location(null,-107.89, 40.00, 105.39));
		List<String> M_7_entity_type = new ArrayList<String>();
		M_7_entity_type.add("MOMIE_ZOMBIE");
		M_7_entity_type.add("MOMIE_ZOMBIE");
		M_7_entity_type.add("ANCIENT_SQUELETON");
		M_7_entity_type.add("MOMIE_ZOMBIE");
		M_7_entity_type.add("SAND_SPIDER");
		IRoom M_7 = new IRoom(M_7_Loc, 3, 3, M_7_entity_loc, M_7_entity_type, 0, 40, 24);
		rooms_3.add(M_7);
		
		List<Location> M_8_Loc = new ArrayList<Location>();
		M_8_Loc.add(new Location(null, -143.19, 42.00, 100.72, 0, 0)); //ENTREE
		M_8_Loc.add(new Location(null, -145.73, 42.00, 132.12, 180, 0)); //SORTIE
		List<Location> M_8_entity_loc = new ArrayList<Location>();
		M_8_entity_loc.add(new Location(null,-141.59, 42.00, 119.56));
		M_8_entity_loc.add(new Location(null, -144.91, 42.00, 110.94));
		M_8_entity_loc.add(new Location(null, -143.72, 42.00, 116.71));
		M_8_entity_loc.add(new Location(null, -143.72, 42.00, 116.71));
		M_8_entity_loc.add(new Location(null,-130.35, 42.00, 119.94));
		M_8_entity_loc.add(new Location(null,-154.63, 43.00, 116.56));
		List<String> M_8_entity_type = new ArrayList<String>();
		M_8_entity_type.add("MOMIE_ZOMBIE");
		M_8_entity_type.add("MOMIE_ZOMBIE");
		M_8_entity_type.add("MOMIE_ZOMBIE");
		M_8_entity_type.add("SAND_SPIDER");
		M_8_entity_type.add("SAND_SQUELETON");
		M_8_entity_type.add("SAND_SQUELETON");
		IRoom M_8 = new IRoom(M_8_Loc, 3, 3, M_8_entity_loc, M_8_entity_type, 0, 40, 24);
		rooms_3.add(M_8);
		
		List<Location> B_1_Loc = new ArrayList<Location>();
		B_1_Loc.add(new Location(null, -7.57, 11.00, 43.85, 0, 0)); //ENTREE
		B_1_Loc.add(new Location(null,-14.96, 17.00, 90.13, 180, 0)); //SORTIE
		List<Location> B_1_entity_loc = new ArrayList<Location>();
		B_1_entity_loc.add(new Location(null, -17.80, 14.00, 53.53));
		B_1_entity_loc.add(new Location(null, -29.02, 15.00, 67.98));
		B_1_entity_loc.add(new Location(null, -23.58, 16.00, 48.24));
		B_1_entity_loc.add(new Location(null, -31.99, 15.00, 76.96));
		B_1_entity_loc.add(new Location(null, -21.21, 15.00, 70.34));
		B_1_entity_loc.add(new Location(null, -12.21, 18.00, 79.38));
		B_1_entity_loc.add(new Location(null, -14.47, 14.00, 65.31));
		List<String> B_1_entity_type = new ArrayList<String>();
		B_1_entity_type.add("SAND_SQUELETON");
		B_1_entity_type.add("MOMIE_ZOMBIE");
		B_1_entity_type.add("SAND_SQUELETON");
		B_1_entity_type.add("MOMIE_ZOMBIE");
		B_1_entity_type.add("SAND_SQUELETON");
		B_1_entity_type.add("MOMIE_ZOMBIE");
		B_1_entity_type.add("SAND_SPIDER");
		IRoom B_1 = new IRoom(B_1_Loc, 4, 3, B_1_entity_loc, B_1_entity_type, 0, 65, 30);
		rooms_3.add(B_1);
		
		List<Location> B_2_Loc = new ArrayList<Location>();
		B_2_Loc.add(new Location(null, -81.70, 10.00, 43.77, 0, 0)); //ENTREE
		B_2_Loc.add(new Location(null, -81.56, 26.00, 89.96, 180, 0)); //SORTIE
		List<Location> B_2_entity_loc = new ArrayList<Location>();
		B_2_entity_loc.add(new Location(null, -88.90, 12.00, 61.43));
		B_2_entity_loc.add(new Location(null, -92.12, 12.00, 74.23));
		B_2_entity_loc.add(new Location(null, -101.15, 15.00, 59.45));
		B_2_entity_loc.add(new Location(null, -98.49, 14.00, 50.77));
		B_2_entity_loc.add(new Location(null, -86.23, 18.00, 54.27));
		B_2_entity_loc.add(new Location(null, -80.12, 18.00, 60.14));
		B_2_entity_loc.add(new Location(null, -87.12, 24.00, 54.30));
		B_2_entity_loc.add(new Location(null, -78.21, 24.00, 54.23));
		B_2_entity_loc.add(new Location(null, -76.09, 17.00, 69.28));
		B_2_entity_loc.add(new Location(null, -68.27, 23.00, 54.38));
		B_2_entity_loc.add(new Location(null, -90.61, 26.00, 80.08));
		List<String> B_2_entity_type = new ArrayList<String>();
		B_2_entity_type.add("SAND_SPIDER");
		B_2_entity_type.add("MOMIE_ZOMBIE");
		B_2_entity_type.add("MOMIE_ZOMBIE");
		B_2_entity_type.add("SAND_SPIDER");
		B_2_entity_type.add("SAND_SQUELETON");
		B_2_entity_type.add("SAND_SQUELETON");
		B_2_entity_type.add("SAND_SQUELETON");
		B_2_entity_type.add("SAND_SQUELETON");
		B_2_entity_type.add("MOMIE_ZOMBIE");
		B_2_entity_type.add("SAND_SPIDER");
		B_2_entity_type.add("MOMIE_ZOMBIE");
		IRoom B_2 = new IRoom(B_2_Loc, 4, 3, B_2_entity_loc, B_2_entity_type, 0, 110, 60);
		rooms_3.add(B_2);
		
		List<Location> B_3_Loc = new ArrayList<Location>();
		B_3_Loc.add(new Location(null, -134.89, 18.00, 43.93, 0, 0)); //ENTREE
		B_3_Loc.add(new Location(null, -134.06, 17.00, 90.45, 180, 0)); //SORTIE
		List<Location> B_3_entity_loc = new ArrayList<Location>();
		B_3_entity_loc.add(new Location(null, -122.25, 17.00, 57.33));
		B_3_entity_loc.add(new Location(null, -133.58, 18.00, 65.30));
		B_3_entity_loc.add(new Location(null, -143.21, 17.00, 52.56));
		B_3_entity_loc.add(new Location(null, -125.31, 18.00, 52.94));
		B_3_entity_loc.add(new Location(null, -134.51, 17.00, 53.95));
		B_3_entity_loc.add(new Location(null, -126.25, 19.00, 71.06));
		B_3_entity_loc.add(new Location(null, -138.78, 18.00, 72.47));
		B_3_entity_loc.add(new Location(null, -139.01, 13.00, 72.78));
		B_3_entity_loc.add(new Location(null, -153.89, 18.00, 60.77));
		B_3_entity_loc.add(new Location(null, -153.89, 18.00, 60.77));
		B_3_entity_loc.add(new Location(null, -153.89, 18.00, 60.77));
		List<String> B_3_entity_type = new ArrayList<String>();
		B_3_entity_type.add("ANCIENT_SQUELETON");
		B_3_entity_type.add("SAND_SPIDER");
		B_3_entity_type.add("SAND_SPIDER");
		B_3_entity_type.add("SAND_SPIDER");
		B_3_entity_type.add("SAND_SQUELETON");
		B_3_entity_type.add("SAND_SQUELETON");
		B_3_entity_type.add("SAND_SQUELETON");
		B_3_entity_type.add("MOMIE_ZOMBIE");
		B_3_entity_type.add("MOMIE_ZOMBIE");
		B_3_entity_type.add("BONE_SILVERFISH");
		B_3_entity_type.add("BONE_SILVERFISH");
		IRoom B_3 = new IRoom(B_3_Loc, 4, 3, B_3_entity_loc, B_3_entity_type, 0, 100, 55);
		rooms_3.add(B_3);
		
		List<Location> B_4_Loc = new ArrayList<Location>();
		B_4_Loc.add(new Location(null, -23.60, 48.00, 43.69, 0, 0)); //ENTREE
		B_4_Loc.add(new Location(null, -32.60, 48.00, 90.55, 180, 0)); //SORTIE
		List<Location> B_4_entity_loc = new ArrayList<Location>();
		B_4_entity_loc.add(new Location(null, -34.55, 48.00, 73.50));
		B_4_entity_loc.add(new Location(null, -34.54, 48.00, 56.51));
		B_4_entity_loc.add(new Location(null, -34.54, 48.00, 56.51));
		B_4_entity_loc.add(new Location(null, -31.76, 48.00, 57.82));
		B_4_entity_loc.add(new Location(null, -31.76, 48.00, 57.82));
		B_4_entity_loc.add(new Location(null, -26.71, 49.00, 55.25));
		B_4_entity_loc.add(new Location(null, -31.94, 49.00, 65.47));
		B_4_entity_loc.add(new Location(null, -18.45, 49.00, 72.22));
		List<String> B_4_entity_type = new ArrayList<String>();
		B_4_entity_type.add("BONE_GOLEM");
		B_4_entity_type.add("BONE_SILVERFISH");
		B_4_entity_type.add("BONE_SILVERFISH");
		B_4_entity_type.add("BONE_SILVERFISH");
		B_4_entity_type.add("BONE_SILVERFISH");
		B_4_entity_type.add("BONE_SILVERFISH");
		B_4_entity_type.add("MOMIE_ZOMBIE");
		B_4_entity_type.add("MOMIE_ZOMBIE");
		IRoom B_4 = new IRoom(B_4_Loc, 4, 3, B_4_entity_loc, B_4_entity_type, 0, 90, 55);
		rooms_3.add(B_4);
		
		List<Location> B_5_Loc = new ArrayList<Location>();
		B_5_Loc.add(new Location(null, -72.58, 48.00, 43.59, 0, 0)); //ENTREE
		B_5_Loc.add(new Location(null, -82.35, 48.00, 90.53, 180, 0)); //SORTIE
		List<Location> B_5_entity_loc = new ArrayList<Location>();
		B_5_entity_loc.add(new Location(null, -75.59, 54.00, 58.56));
		B_5_entity_loc.add(new Location(null, -77.90, 54.00, 78.37));
		B_5_entity_loc.add(new Location(null, -87.38, 54.00, 77.70));
		B_5_entity_loc.add(new Location(null, -87.51, 54.00, 69.56));
		B_5_entity_loc.add(new Location(null, -71.72, 54.00, 70.93));
		B_5_entity_loc.add(new Location(null, -84.88, 54.00, 70.43));
		B_5_entity_loc.add(new Location(null, -69.91, 48.00, 56.81));
		B_5_entity_loc.add(new Location(null, -86.97, 49.00, 82.21));
		List<String> B_5_entity_type = new ArrayList<String>();
		B_5_entity_type.add("BONE_GOLEM");
		B_5_entity_type.add("SAND_SQUELETON");
		B_5_entity_type.add("SAND_SQUELETON");
		B_5_entity_type.add("SAND_SQUELETON");
		B_5_entity_type.add("MOMIE_ZOMBIE");
		B_5_entity_type.add("MOMIE_ZOMBIE");
		B_5_entity_type.add("SAND_SPIDER");
		B_5_entity_type.add("SAND_SPIDER");
		IRoom B_5 = new IRoom(B_5_Loc, 4, 3, B_5_entity_loc, B_5_entity_type, 0, 60, 50);
		rooms_3.add(B_5);
		
		List<Location> H_1_Loc = new ArrayList<Location>();
		H_1_Loc.add(new Location(null, -37.73, 26.00, 142.75, 0, 0)); //ENTREE
		H_1_Loc.add(new Location(null, -47.84, 21.00, 214.54, 180, 0)); //SORTIE
		List<Location> H_1_entity_loc = new ArrayList<Location>();
		H_1_entity_loc.add(new Location(null, -22.02, 13.00, 179.40));
		H_1_entity_loc.add(new Location(null, -46.60, 13.00, 178.13));
		H_1_entity_loc.add(new Location(null, -36.55, 14.25, 181.60));	
		H_1_entity_loc.add(new Location(null, -48.85, 16.00, 192.99));
		H_1_entity_loc.add(new Location(null, -23.21, 13.00, 192.55));
		H_1_entity_loc.add(new Location(null, -41.34, 14.00, 165.89));
		H_1_entity_loc.add(new Location(null, -64.04, 19.00, 169.46));
		H_1_entity_loc.add(new Location(null, -52.59, 18.00, 152.98));
		H_1_entity_loc.add(new Location(null, -40.62, 14.00, 155.47));
		H_1_entity_loc.add(new Location(null, -33.62, 14.00, 159.02));
		H_1_entity_loc.add(new Location(null, -6.27, 13.00, 190.82));
		H_1_entity_loc.add(new Location(null, -2.50, 12.00, 192.23));
		H_1_entity_loc.add(new Location(null, -22.37, 13.00, 178.62));
		H_1_entity_loc.add(new Location(null, -22.37, 13.00, 178.62));
		H_1_entity_loc.add(new Location(null, -34.38, 14.00, 178.59));
		H_1_entity_loc.add(new Location(null, -34.38, 14.00, 178.59));
		H_1_entity_loc.add(new Location(null, -46.95, 14.00, 181.06));
		List<String> H_1_entity_type = new ArrayList<String>();
		H_1_entity_type.add("ANCIENT_SQUELETON");
		H_1_entity_type.add("ANCIENT_SQUELETON");
		H_1_entity_type.add("BONE_GOLEM");
		H_1_entity_type.add("MOMIE_ZOMBIE");
		H_1_entity_type.add("MOMIE_ZOMBIE");
		H_1_entity_type.add("MOMIE_ZOMBIE");
		H_1_entity_type.add("MOMIE_ZOMBIE");
		H_1_entity_type.add("MOMIE_ZOMBIE");
		H_1_entity_type.add("SAND_SPIDER");
		H_1_entity_type.add("SAND_SPIDER");
		H_1_entity_type.add("SAND_SPIDER");
		H_1_entity_type.add("SAND_SPIDER");
		H_1_entity_type.add("BONE_SILVERFISH");
		H_1_entity_type.add("BONE_SILVERFISH");
		H_1_entity_type.add("BONE_SILVERFISH");
		H_1_entity_type.add("BONE_SILVERFISH");
		H_1_entity_type.add("BONE_SILVERFISH");
		IRoom H_1 = new IRoom(H_1_Loc, 5, 3, H_1_entity_loc, H_1_entity_type, 0, 200, 120);
		rooms_3.add(H_1);
		
		List<Location> H_2_Loc = new ArrayList<Location>();
		H_2_Loc.add(new Location(null, -24.07, 68.00, 142.40, 0, 0)); //ENTREE
		H_2_Loc.add(new Location(null, -35.14, 73.00, 214.22, 180, 0)); //SORTIE
		List<Location> H_2_entity_loc = new ArrayList<Location>();
		H_2_entity_loc.add(new Location(null, -33.34, 71.00, 189.52));
		H_2_entity_loc.add(new Location(null, -33.51, 71.00, 162.32));
		H_2_entity_loc.add(new Location(null, -49.30, 71.00, 184.32));	
		H_2_entity_loc.add(new Location(null, -25.56, 71.00, 176.23));
		H_2_entity_loc.add(new Location(null, -55.26, 71.00, 172.36));
		
		H_2_entity_loc.add(new Location(null, -33.39, 71.00, 180.92));
		H_2_entity_loc.add(new Location(null, -33.52, 71.00, 169.48));
		H_2_entity_loc.add(new Location(null, -33.52, 71.00, 169.48));
		H_2_entity_loc.add(new Location(null, -33.78, 73.00, 200.40));
		H_2_entity_loc.add(new Location(null, -46.83, 71.00, 172.18));
		H_2_entity_loc.add(new Location(null, -49.86, 71.00, 180.59));
		
		H_2_entity_loc.add(new Location(null, -39.64, 60.00, 192.89));
		H_2_entity_loc.add(new Location(null, -18.85, 62.00, 175.04));
		H_2_entity_loc.add(new Location(null, -32.90, 60.00, 156.02));
		H_2_entity_loc.add(new Location(null, -37.19, 61.00, 196.96));
		H_2_entity_loc.add(new Location(null, -35.79, 61.00, 176.65));
		List<String> H_2_entity_type = new ArrayList<String>();
		H_2_entity_type.add("SAND_SQUELETON");
		H_2_entity_type.add("SAND_SQUELETON");
		H_2_entity_type.add("SAND_SQUELETON");
		H_2_entity_type.add("ANCIENT_SQUELETON");
		H_2_entity_type.add("ANCIENT_SQUELETON");
		H_2_entity_type.add("MOMIE_ZOMBIE");
		H_2_entity_type.add("MOMIE_ZOMBIE");
		H_2_entity_type.add("MOMIE_ZOMBIE");
		H_2_entity_type.add("MOMIE_ZOMBIE");
		H_2_entity_type.add("MOMIE_ZOMBIE");
		H_2_entity_type.add("MOMIE_ZOMBIE");
		H_2_entity_type.add("SAND_SPIDER");
		H_2_entity_type.add("SAND_SPIDER");
		H_2_entity_type.add("SAND_SPIDER");
		H_2_entity_type.add("SAND_SPIDER");
		H_2_entity_type.add("MOMIE_ZOMBIE");
		IRoom H_2 = new IRoom(H_2_Loc, 5, 3, H_2_entity_loc, H_2_entity_type, 0, 200, 120);
		rooms_3.add(H_2);
		
		List<Location> BOSS_1_Loc = new ArrayList<Location>();
		BOSS_1_Loc.add(new Location(null, -112.25, 41.00, 143.23, 0, 0)); //ENTREE
		List<Location> BOSS_1_entity_loc = new ArrayList<Location>();
		BOSS_1_entity_loc.add(new Location(null, -109.5, 42.00, 170.5, 0, 0));
		List<String> BOSS_1_entity_type = new ArrayList<String>();
		BOSS_1_entity_type.add("BONE_GOLEM");
		IRoom BOSS_1 = new IRoom(BOSS_1_Loc, 6, 3, BOSS_1_entity_loc, BOSS_1_entity_type, 0, 60, 70);
		rooms_3.add(BOSS_1);
	}
	
}
