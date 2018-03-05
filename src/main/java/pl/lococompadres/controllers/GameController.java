package pl.lococompadres.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.lococompadres.app.Point;
import pl.lococompadres.entities.Gamestate;
import pl.lococompadres.entities.User;
import pl.lococompadres.repositories.GamestateRepository;
import pl.lococompadres.repositories.UserRepository;

@Controller
public class GameController {
	
	int actionPoints;
	Long availableCash;
	Long availableThugs;
	Long availableLadies;
	Long availableDealers;
	Point[] points = new Point[20];
	
	public static Point parsePoint (String string) {
		Point point = new Point();
		String[] variables = new String[8];
		variables = string.split(",");
		point.name = variables[0];
		point.enemy = Boolean.parseBoolean(variables[1]);
		point.pointAP = Integer.parseInt(variables[2]);
		point.distanceToEnemy = Integer.parseInt(variables[3]);
		point.cash = Long.parseLong(variables[4]);
		point.thugs = (long) Integer.parseInt(variables[5]);
		point.ladies = (long) Integer.parseInt(variables[6]);
		point.dealers = (long) Integer.parseInt(variables[7]);
		return point;
	}
	
	public int numberOfPoints (boolean mine) {
		int numberOfMyPoints=0;
		int numberOfEnemyPoints=0;
		int result=0;
		for(int i=0;i<points.length;i++) {
			if(points[i].enemy==false) {
				numberOfMyPoints++;
			}else {
				numberOfEnemyPoints++;
			}
		}
		if(mine==true) {
			result=numberOfMyPoints;
		}else {
			result=numberOfEnemyPoints;
		}
		return result;
	}
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	GamestateRepository gamestateRepository;
	
	@GetMapping("/login")
	public String logIn(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String login, @RequestParam String password, HttpSession session, Model model) {
				
		User user = userRepository.findFirstByUserName(login);
		if(user!=null && BCrypt.checkpw(password, user.getPassword())) {
			model.addAttribute("info", "Logged in");
				session.setAttribute("loggedUser", user);
				Gamestate gamestate = gamestateRepository.findById(user.getGamestate().getId());
				model.addAttribute("stats", gamestate);
				actionPoints = gamestate.getActionPoints();
				availableCash = gamestate.getCash();
				availableThugs = gamestate.getThugs();
				availableLadies = gamestate.getLadies();
				availableDealers = gamestate.getDealers();
				points[0]=parsePoint(gamestate.getPoint01());
				points[1]=parsePoint(gamestate.getPoint02());
				points[2]=parsePoint(gamestate.getPoint03());
				points[3]=parsePoint(gamestate.getPoint04());
				points[4]=parsePoint(gamestate.getPoint05());
				points[5]=parsePoint(gamestate.getPoint06());
				points[6]=parsePoint(gamestate.getPoint07());
				points[7]=parsePoint(gamestate.getPoint08());
				points[8]=parsePoint(gamestate.getPoint09());
				points[9]=parsePoint(gamestate.getPoint10());
				points[10]=parsePoint(gamestate.getPoint11());
				points[11]=parsePoint(gamestate.getPoint12());
				points[12]=parsePoint(gamestate.getPoint13());
				points[13]=parsePoint(gamestate.getPoint14());
				points[14]=parsePoint(gamestate.getPoint15());
				points[15]=parsePoint(gamestate.getPoint16());
				points[16]=parsePoint(gamestate.getPoint17());
				points[17]=parsePoint(gamestate.getPoint18());
				points[18]=parsePoint(gamestate.getPoint19());
				points[19]=parsePoint(gamestate.getPoint20());
				return "game";
		} else {
			session.setAttribute("loggedUser", null);
			model.addAttribute("info", "Wrong login or password");
		}
		return "login";
	}
	
	@GetMapping("/addUser")
	public String userAdd(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	@PostMapping("/addUser")
	public String userAdd(@Valid User user, BindingResult result, Model model) {
		Gamestate gamestate = new Gamestate();
		if(result.hasErrors())
		{
			return "addUser";
		}
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		Random random = new Random();
		gamestate.setActionPoints(1);
		gamestate.setCash(100 + random.nextInt(100));
		gamestate.setDealers(100 + random.nextInt(100));
		gamestate.setThugs(100 + random.nextInt(100));
		gamestate.setLadies(100 + random.nextInt(100));
		for(int i=0; i<points.length; i++) {
			points[i] = new Point();
			points[i].name = "Point" + (i+1);
			points[i].enemy = true;
			points[i].pointAP = 1;
			points[i].distanceToEnemy = 0;
			points[i].cash = (long) random.nextInt(50);
			points[i].thugs = (long) random.nextInt(50);
			points[i].ladies = (long) random.nextInt(50);
			points[i].dealers = (long) random.nextInt(50);
		}
		points[0].enemy = false;
		gamestate.setPoint01(points[0].toString());
		gamestate.setPoint02(points[1].toString());
		gamestate.setPoint03(points[2].toString());
		gamestate.setPoint04(points[3].toString());
		gamestate.setPoint05(points[4].toString());
		gamestate.setPoint06(points[5].toString());
		gamestate.setPoint07(points[6].toString());
		gamestate.setPoint08(points[7].toString());
		gamestate.setPoint09(points[8].toString());
		gamestate.setPoint10(points[9].toString());
		gamestate.setPoint11(points[10].toString());
		gamestate.setPoint12(points[11].toString());
		gamestate.setPoint13(points[12].toString());
		gamestate.setPoint14(points[13].toString());
		gamestate.setPoint15(points[14].toString());
		gamestate.setPoint16(points[15].toString());
		gamestate.setPoint17(points[16].toString());
		gamestate.setPoint18(points[17].toString());
		gamestate.setPoint19(points[18].toString());
		gamestate.setPoint20(points[19].toString());
		user.setGamestate(gamestate);
		gamestateRepository.save(gamestate);
		userRepository.save(user);
		return "login";
	}
	
	@PostMapping("/getPoints")
	@ResponseBody
	public String getPoints() {
		String pointNumbers = "";
		int size=points.length;
		for(int i=0;i<size;i++) {
			if(points[i].enemy==true) {
				pointNumbers+= ",1";
			}else {
				pointNumbers+= ",0";
			}
		}
		System.out.println(pointNumbers);
		return pointNumbers;
	}
	
	@PostMapping("/save")
	public void save(HttpSession session) {
		User user = (User) session.getAttribute("loggedUser");								//tu musi rozpoznawać jeśli nikt nie jest zaologowany, bo wyjebie exception
		Gamestate gamestate = gamestateRepository.findById(user.getGamestate().getId());
		gamestate.setActionPoints(actionPoints);
		gamestate.setCash(availableCash);
		gamestate.setThugs(availableThugs);
		gamestate.setLadies(availableLadies);
		gamestate.setDealers(availableDealers);
		gamestate.setPoint01(points[0].toString());
		gamestate.setPoint02(points[1].toString());
		gamestate.setPoint03(points[2].toString());
		gamestate.setPoint04(points[3].toString());
		gamestate.setPoint05(points[4].toString());
		gamestate.setPoint06(points[5].toString());
		gamestate.setPoint07(points[6].toString());
		gamestate.setPoint08(points[7].toString());
		gamestate.setPoint09(points[8].toString());
		gamestate.setPoint10(points[9].toString());
		gamestate.setPoint11(points[10].toString());
		gamestate.setPoint12(points[11].toString());
		gamestate.setPoint13(points[12].toString());
		gamestate.setPoint14(points[13].toString());
		gamestate.setPoint15(points[14].toString());
		gamestate.setPoint16(points[15].toString());
		gamestate.setPoint17(points[16].toString());
		gamestate.setPoint18(points[17].toString());
		gamestate.setPoint19(points[18].toString());
		gamestate.setPoint20(points[19].toString());
		gamestateRepository.save(gamestate);
	}
	
	@PostMapping("/point")
	@ResponseBody
	public String Point(@RequestParam String pointId) {
		int select = (Integer.parseInt(pointId.replaceAll("[^0-9]", ""))-1);
		String response = points[select].toString() + "," + actionPoints + "," + availableCash + "," + availableThugs+ "," + availableLadies + "," + availableDealers;
		return response;
	}
	
	@PostMapping("/stats")
	@ResponseBody
	public String Stats(HttpSession session) {
		User user = (User) session.getAttribute("loggedUser");
		String response = user.getUserName() + "," + actionPoints + "," + availableCash + "," + availableThugs+ "," + availableLadies + "," + availableDealers;
		return response;
	}
	
	@PostMapping("/attack")
	public String attack(@RequestParam long howMany, @RequestParam int pointNumber, Model model) {
		actionPoints=actionPoints-1;
		if(points[pointNumber-1].thugs<howMany) {
			availableThugs = availableThugs - howMany;
			long losses = points[pointNumber-1].thugs;
			points[pointNumber-1].thugs = howMany-points[pointNumber-1].thugs;
			points[pointNumber-1].enemy = false;
			points[pointNumber-1].pointAP=points[pointNumber-1].pointAP-1;
			if(numberOfPoints(true)==20) {
				model.addAttribute("victoryOrDefeat", "FINAL VICTORY!!!");						//Is the victory final?
			}else {
			model.addAttribute("victoryOrDefeat", "VICTORY!");
			}
			model.addAttribute("losses", losses);
			return "attackResult";
		} else {
			availableThugs = availableThugs - howMany;
			long losses = howMany;
			model.addAttribute("victoryOrDefeat", "DEFEAT!");
			model.addAttribute("losses", losses);
			return "attackResult";
		}
	}
	
	@PostMapping("/transfer")
	public void transfer(@RequestParam int pointNumber, @RequestParam long transferCash, @RequestParam long transferThugs, @RequestParam long transferLadies, @RequestParam long transferDealers) {
		points[pointNumber-1].pointAP = points[pointNumber-1].pointAP-1;
		points[pointNumber-1].cash = points[pointNumber-1].cash + transferCash;
		points[pointNumber-1].thugs = points[pointNumber-1].thugs + transferThugs;
		points[pointNumber-1].ladies = points[pointNumber-1].ladies + transferLadies;
		points[pointNumber-1].dealers = points[pointNumber-1].dealers + transferDealers;
		availableCash = availableCash - transferCash;
		availableThugs = availableThugs - transferThugs;
		availableLadies = availableLadies - transferLadies;
		availableDealers = availableDealers - transferDealers;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("loggedUser",  null);
		return "logout";	
	}
	
	@PostMapping("/checkAP")
	@ResponseBody
	public String checkAP() {
		String response = Integer.toString(actionPoints);
		return response;
	}
	
	@PostMapping("/recruit")
	public void recruit(@RequestParam long recruitThugs, @RequestParam long recruitLadies, @RequestParam long recruitDealers) {
		availableThugs = availableThugs + recruitThugs;
		availableLadies = availableLadies + recruitLadies;
		availableDealers = availableDealers + recruitDealers;
		availableCash = availableCash - (recruitThugs * 5) - (recruitLadies * 5) - (recruitLadies * 5);
	}
	
	@PostMapping("/endturn")
	public String turnFinished(@RequestParam boolean gather, Model model) {
		String randomEvent = "";
		Random random = new Random();
		actionPoints++;
		if(gather==true) {
			actionPoints--;
		}
		for(int i=0;i<points.length;i++) {											// Set points statistics
			points[i].pointAP=1;
			points[i].cash=points[i].cash+points[i].ladies+points[i].dealers;
			if(gather==true) {
				points[i].cash=points[i].cash+points[i].ladies+points[i].dealers;
			}
		}
		int probability = random.nextInt(20)+1;										// Generate random event
		switch (probability) {
		case 1:
			randomEvent = "Astrologers proclaim week of the Lady." +
					"\n" + "Population of Ladies increases.";
			availableLadies = availableLadies + random.nextInt(100);
			break;
		case 2:
			randomEvent = "Astrologers proclaim week of the Thug." +
					"\n" + "Population of Thugs increases.";
			availableThugs = availableThugs + random.nextInt(100);
			break;
		case 3:
			randomEvent = "Astrologers proclaim week of the Dealer." +
					"\n" + "Population of Dealers increases.";
			availableDealers = availableDealers + random.nextInt(100);
			break;
		case 4:
			randomEvent = "There was an explosion in one of your labs." +
					"\n" + "You lose a bunch of dealers.";
//			points[0].enemy=true;
			break;
		case 5:
			randomEvent = "A group of dealers ran away staling a fresh shipment of merchandise." +
					"\n" + "It did hurt. You've lost a lot.";
			break;
		case 6:
			randomEvent = "Your lads have robbed some rich guy." +
					"\n" + "You scored yourself a nice sum of money.";
			availableCash = availableCash + random.nextInt(100);
			break;
// dodać kasę
		case 7:
			randomEvent = "One of your lads carrying cash got himself robbed while visiting a brothel." +
					"\n" + "You've lost quite a lot...";
			int cashLost = random.nextInt(100);
			if (availableCash > cashLost) {
				availableCash = availableCash - cashLost;
			}else {
				availableCash = 0L;
			}
			break;
// odjąć kasę
		case 8:
			randomEvent = "There was a deadly STD epidemic among your ladies." +
					"\n" + "You lose some of them and some money for medicines as well.";
			break;
// odjąć dziwki i kasę
		case 9:
			randomEvent = "There was a clash with a strong group of enemy thugs downtown." +
					"\n" + "You've lost some of your lads and some money to get the rest of them patched up.";
			break;
// odjąć karków i kasę
		case 10:
			randomEvent = "Betrayal!!! A group of your thugs leave your ranks and join the enemy." +
					"\n" + "I guess you can't trust anyone these days...";
			break;
// odjąć karków
		case 11:
			randomEvent = "A group of enemy thugs joins your ranks." +
					"\n" + "Better keep an eye on them, disloyalty is only difficult the first time...";
			break;
// odjąć karków i kasę
		case 12:
			randomEvent = "Many of your people got themselves hooked on speed." +
					"\n" + "You get to perform one additional action this turn.";
			actionPoints ++;
			break;
		case 13:
			randomEvent = "Lots of your people got themselves hooked on opiates." +
					"\n" + "You lose an action point this turn.";
			actionPoints --;
			break;
		default:
			randomEvent = "Nothing out of ordinary happened this turn.";
		}
		model.addAttribute("event", randomEvent);
		int pointAttacked = random.nextInt(points.length-1);							// Enemy attack
		if(points[pointAttacked].enemy == false) {
			String enemyAttack = points[pointAttacked].name + " has been attacked by enemy forces!";
			int enemyForces = random.nextInt(100);
			if(points[pointAttacked].thugs >= enemyForces) {
				points[pointAttacked].thugs = points[pointAttacked].thugs - enemyForces;
				String enemyAttackResult = "Your defense was successful, you've lost " + enemyForces + " thugs.";
				model.addAttribute("enemyAttackResult", enemyAttackResult);
			}else {
				points[pointAttacked].thugs = enemyForces - points[pointAttacked].thugs;
				String enemyAttackResult = "";
				points[pointAttacked].enemy = true;
				if(numberOfPoints(false)==20) {
					enemyAttackResult = "FINAL DEFEAT!!!";								// Is defeat final?
				}else {
					enemyAttackResult = "Defeat!. You've lost the point!";
				}
				model.addAttribute("enemyAttackResult", enemyAttackResult);
			}
			model.addAttribute("enemyAttack", enemyAttack);
		}
		return "endTurn";
	}
}