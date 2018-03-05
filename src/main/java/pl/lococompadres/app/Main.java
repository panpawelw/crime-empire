//package pl.lococompadres.app;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class Main {
//	
//	public static Point parsePoint (String string) {
//		Point point = new Point();
//		String[] variables = new String[8];
//		variables = string.split(",");
//		point.name = variables[0];
//		point.enemy = Boolean.parseBoolean(variables[1]);
//		point.done = Boolean.parseBoolean(variables[2]);
//		point.distanceToEnemy = Integer.parseInt(variables[3]);
//		point.cash = Long.parseLong(variables[4]);
//		point.thugs = Integer.parseInt(variables[5]);
//		point.whores = Integer.parseInt(variables[6]);
//		point.drugs = Integer.parseInt(variables[7]);
//		System.out.println(point);
//		return point;
//	}
//	
//	public static void main(String[] args) {
//		
//		Point[] points = new Point[10];						//wstępna inicjalizacja stanu gry
//
//		Random random = new Random();
//		
//		for(int i=0; i<points.length; i++) {
//			points[i] = new Point();
//			points[i].name = "Point" + i;
//			points[i].enemy = true;
//			points[i].done = false;
//			points[i].distanceToEnemy = 0;
//			points[i].cash = random.nextLong();
//			points[i].thugs = random.nextInt(10);
//			points[i].whores = random.nextInt(10);
//			points[i].drugs = random.nextInt(100);
//		}
//		points[0].enemy = false;
//		Long id = 1L;
//		Long cash = 1000L;
//		int thugs = random.nextInt(100);
//		int whores = random.nextInt(100);
//		int drugs = random.nextInt(100);
//		
//		GameState gameState = new GameState();
//		Scanner scan = new Scanner(System.in);				// Główna pętla programu
//		String command = "";
//		while(!command.equalsIgnoreCase("quit")) {
//			for(int i=0; i<points.length; i++) {
//				System.out.println(points[i]);
//			}
//			System.out.println("------------------------------------------------------------------------------------------");
//			System.out.println("WOLNE ZASOBY|siano:" + cash + "|karki:" + thugs + "|lachony:" + whores + "|towar:" + drugs);
//			System.out.println("------------------------------------------------------------------------------------------");
//			System.out.println("Co robisz? Możesz wykonać jedną akcję w każdym z punktów i jedną akcję ogólną...");
//			switch (command) {
//			case "end turn":
//				for(int i=0;i<points.length;i++) {          // Koniec tury
//					points[i].done=false;
//					points[i].cash=points[i].cash + 50;
//					                                        // Tu losowanie zdarzenia losowego z listy
//				}
//				break;
//			case "select":
//				break;
//			case "attack":
//				System.out.println("Which point?");
//				int pointNumber = scan.nextInt();
//				System.out.println("How many thugs?");
//				int ekipaSize = scan.nextInt();
//				if(ekipaSize > points[pointNumber].thugs) {
//					points[pointNumber].thugs = ekipaSize/2;
//					thugs = thugs-ekipaSize;
//					points[pointNumber].enemy = false;
//				}
//				break;
//			case "patrol":
//				break;
//			case "gather":
//				break;
//			case "save":
//				gameState.saveGame(1, cash, thugs, whores, drugs, points);
//				System.out.println(gameState);
//				break;
//			case "load":
//				id = gameState.getId();
//				cash = gameState.getCash();
//				thugs = gameState.getThugs();
//				whores = gameState.getWhores();
//				drugs = gameState.getDrugs();
//				points[0]=parsePoint(gameState.getPoint0());
//				points[1]=parsePoint(gameState.getPoint1());
//				points[2]=parsePoint(gameState.getPoint2());
//				points[3]=parsePoint(gameState.getPoint3());
//				points[4]=parsePoint(gameState.getPoint4());
//				points[5]=parsePoint(gameState.getPoint5());
//				points[6]=parsePoint(gameState.getPoint6());
//				points[7]=parsePoint(gameState.getPoint7());
//				points[8]=parsePoint(gameState.getPoint8());
//				points[9]=parsePoint(gameState.getPoint9());
//			}
//			command = scan.nextLine();
//		}
//		System.out.println("Nara mokra szpara!");
//	}
//
//}