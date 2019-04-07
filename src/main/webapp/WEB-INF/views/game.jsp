<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="PL">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Crime Empire">
    <meta name="keywords" content="keywords here">
    <meta name="author" content="P&A">
    <link
            href="https://fonts.googleapis.com/css?family=Press+Start+2P&amp;subset=latin-ext"
            rel="stylesheet">
    <link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"
          rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/main.css" rel="stylesheet">
    <title>Crime Empire 1.0.0</title>
</head>
<body>
<!-- MAIN_CONTAINER -->
<div class="main_container">
    <!-- MAIN_BAR & NAV-->
    <div class="main_bar">
        <ul class="functions">
            <p>GAME</p>
            <li class="functions_in hidden geos_info"><span>info</span></li>
            <li class="functions_in hidden calculator"><span>calculator</span></li>
            <li class="functions_in hidden log out"><span><a
                    href="logout">log out</a></span></li>
        </ul>
        <ul class="functions">
            <p>RESOURCES</p>
            <li class="functions_in hidden show_stats"><span>STATS</span></li>
            <li class="functions_in hidden recruit"><span>RECRUIT</span></li>
        </ul>
        <ul class="functions">
            <p>TURN</p>
            <li class="functions_in hidden save_game"><span>SAVE</span></li>
            <li class="functions_in hidden gather"><span>GATHER</span></li>
            <li class="functions_in hidden end_turn"><span>END TURN</span></li>

        </ul>
        <div class='calendar'></div>
        <div class="clear"></div>
    </div>
    <!-- WORKSPACE & WINDOWS -->
    <div id="workspace">

        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e1">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f1">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e2">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f2">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e3">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f3">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e4">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f4">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e5">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f5">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e6">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f6">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e7">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f7">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e8">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f8">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e9">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f9">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e10">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f10">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e11">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f11">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e12">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f12">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e13">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f13">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e14">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f14">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e15">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f15">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e16">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f16">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e17">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f17">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e18">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f18">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e19">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f19">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_e.png" class="ico ico_e20">
        <img src="<%=request.getContextPath()%>/resources/images/ico/ICO_f.png" class="ico ico_f20">

        <div class='game_welcome_container draggable'>
            <div class="bar"></div>
            <div class="text_area">
                <p>Welcome to Crime Empire</p>
                <p>VERSION: 1.0.0</p>
                <br>
                <p>TUTORIAL</p>
                <br>
                <p>You are an aspiring career criminal trying to gain control over Whateverville city.</p>
                <p>Things you need to focus on are:</p>
                <p>- your global pool of resources: cash to buy stuff, thugs attack enemy and protect your premises,
                    ladies and dealers that earn you profits.</p>
                <p>- points on the city map that you control - they represent your businesses, hideouts, street corners
                    etc, they earn you money and you need to defend them.</p>
                <p>- points controlled by enemy forces - you need to attack these.</p>
                <br>
                <p>Each turn you can either attack the enemy or choose to gather resources (doubles your income this
                    turn). You can also transfer resources between your points on city map and global pool of resources
                    (once per point per turn). You can recruit/sell your underlings unlimited times per turn.</p>
                <br>
                <p>GOOD LUCK!</p>
                <br>
                <button class="button1 geos_welcome_container_button">OK</button>
            </div>
        </div>

        <div class='geos_info_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <p>CRIME EMPIRE</p>
                <br>
                <p>P &amp; A SOFTWARE</p>
                <p>Copyright 2018</p>
                <br>
                <p>GUI based on GEOS v2.0 Project</p>
                <p>by Szymon Mikolajczak - Copyright 2017
                    <button class="button1 geos_info_container_button">OK</button>
            </div>
        </div>

        <div class='save_game_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <br>
                <p>ARE YOU SURE YOU WANT TO SAVE THE GAME?</p>
                <br>
                <button class="button1 save_game_container_button">OK</button>
            </div>
        </div>

        <div class='gather_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <br>
                <p>ARE YOU SURE YOU WANT TO SACRIFICE THE ACTION POINT FOR 2X RESOURCES?</p>
                <br>
                <button class="button1 gather_container_button">OK</button>
            </div>
        </div>

        <div class='end_turn_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <br>
                <p>ARE YOU SURE YOU WANT TO END YOUR TURN?</p>
                <br>
                <button class="button1 end_turn_container_button">END TURN</button>
            </div>
        </div>

        <div class='turn_finished_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <span>TURN FINISHED!!!</span>
                <div id="result1"></div>
                <button class="button1 turn_finished_container_button">OK</button>
            </div>
        </div>

        <div class='attack_result_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <div id="result2"></div>
                <button class="button1 attack_result_container_button">OK</button>
            </div>
        </div>

        <div class='transfer_alert_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <br> <span>You have already transfered resources
						from/to this point this turn!</span> <br> <br>
                <button class="button1 alert_container_button">OK</button>
            </div>
        </div>

        <div class='ap_alert_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <br> <span>Not enough action points left!</span> <br> <br>
                <button class="button1 alert_container_button">OK</button>
            </div>
        </div>

        <div class='friendly_point_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <p class="fpname">placeholder</p>
                <br>
                <p id="point_done">placeholder</p>
                <br>
                <div>
                    <p class="fpcash">placeholder</p>
                    <input class="transfer" id="transferCash" type="number" name="tCash" min="" max="" placeholder="0"/>
                    <p class="fpmaxcash">placeholder</p>
                </div>
                <div>
                    <p class="fpthugs">placeholder</p>
                    <input class="transfer" id="transferThugs" type="number" name="tThugs" min="" max=""
                           placeholder="0"/>
                    <p class="fpmaxthugs">placeholder</p>
                </div>
                <div>
                    <p class="fpladies">placeholder</p>
                    <input class="transfer" id="transferLadies" type="number" name="tLadies" min="" max=""
                           placeholder="0"/>
                    <p class="fpmaxladies">placeholder</p>
                </div>
                <div>
                    <p class="fpdealers">placeholder</p>
                    <input class="transfer" id="transferDealers" type="number" name="tDealers" min="" max=""
                           placeholder="0"/>
                    <p class="fpmaxdealers">placeholder</p>
                </div>
                <br>
                <button class="button1 transfer_container_button">TRANSFER</button>
                <button class="button1 point_container_button">OK</button>
            </div>
        </div>

        <div class='enemy_point_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <p class="epname">placeholder</p>
                <br>
                <p class="epcash">placeholder</p>
                <p class="epthugs">placeholder</p>
                <p class="epladies">placeholder</p>
                <p class="epdealers">placeholder</p>
                <br>
                <p>attack force</p>
                <input class="transfer" id="attackparty" type="number" name="howMany" min="0" placeholder="0"/>
                <p style="display: inline-block;">of</p>
                <p class="epmaxthugs">${maxThugs}</p>
                <p>available</p>
                <br>
                <button class="button1 attack_container_button">ATTACK</button>
                <button class="button1 point_container_button">OK</button>
            </div>
        </div>

        <div class='show_stats_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <h1>STATS</h1>
                <p class="user">placeholder</p>
                <p class="actions">placeholder</p>
                <p class="cash">placeholder</p>
                <p class="thugs">placeholder</p>
                <p class="ladies">placeholder</p>
                <p class="dealers">placeholder</p>
                <button class="button1 show_stats_container_button">OK</button>
            </div>
        </div>

        <div class='recruit_container draggable hidden'>
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="text_area">
                <h1>RECRUIT</h1>
                Cash:
                <p class="recruitCash">placeholder</p>
                <br>
                Thugs:
                <p class="recruitThugs">placeholder</p>
                <input class="recruitInput" id="recruitThugs" type="number" name="rThugs" min="" max=""
                       placeholder="0"/><br>
                Ladies:
                <p class="recruitLadies">placeholder</p>
                <input class="recruitInput" id="recruitLadies" type="number" name="rLadies" min="" max=""
                       placeholder="0"/><br>
                Dealers:
                <p class="recruitDealers">placeholder</p>
                <input class="recruitInput" id="recruitDealers" type="number" name="rDealers" min="" max=""
                       placeholder="0"/><br>
                <br>
                <button class="button1 recruit_container_button">BUY/SELL</button>
            </div>
        </div>

        <div class="calculator_container draggable hidden">
            <div class="bar">
                <div class='bar_close'></div>
            </div>
            <div class="calc_main">
                <h5>Calculator</h5>
                <input id="result" class="input"></input>
                <div id="keys">
                    <div id="first_row">
                        <button id="clearAll" type="reset" value="CE"
                                class="clean calc_button">CE
                        </button>
                        <button id="clear" type="reset" value="C"
                                class="clean calc_button">C
                        </button>
                        <button id="add" type="button" value="+"
                                class="operators operand calc_button">+
                        </button>
                    </div>
                    <div id="second_row">
                        <button id="seven" type="button" value="7"
                                class="show calc_button">7
                        </button>
                        <button id="eight" type="button" value="8"
                                class="show calc_button">8
                        </button>
                        <button id="nine" type="button" value="9"
                                class="show calc_button">9
                        </button>
                        <button id="sub" type="button" value="-"
                                class="operators operand calc_button">-
                        </button>
                    </div>
                    <div id="third_row">
                        <button id="four" type="button" value="4"
                                class="show calc_button">4
                        </button>
                        <button id="five" type="button" value="5"
                                class="show calc_button">5
                        </button>
                        <button id="six" type="button" value="6" class="show calc_button">6</button>
                        <button id="mul" type="button" value="*"
                                class="operators operand calc_button">*
                        </button>
                    </div>
                    <div id="fourth_row">
                        <button id="one" type="button" value="1" class="show calc_button">1</button>
                        <button id="two" type="button" value="2" class="show calc_button">2</button>
                        <button id="three" type="button" value="3"
                                class="show calc_button">3
                        </button>
                        <button id="divide" type="button" value="/"
                                class="operators operand calc_button">/
                        </button>
                    </div>
                    <div id="fifth_row">
                        <button id="zero" type="button" value="0"
                                class="show calc_button">0
                        </button>
                        <button id="dot" type="button" value="." class="show calc_button">.</button>
                        <button id="calculate" type="button" value="="
                                class="operand calc_button">=
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
        src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/app.js"
        type="text/javascript"></script>
</body>
</html>
