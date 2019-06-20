$(document).ready(function () {

    let point = '';
    refreshIcons();

//ICONS--------------------------------------------------------------------
    function refreshIcons() {
        $.post('getPoints', function (data) {
            let splitEnemyPoints = data.split(",");
            let arrayLength = splitEnemyPoints.length;
            let iconNameE = 'ico_f';
            let iconNameF = 'ico_e';
            for (let i = 1; i <= 20; i++) {
                if (splitEnemyPoints[i] == 1) {
                    $('.' + iconNameE + i).addClass('hidden');
                    $('.' + iconNameF + i).removeClass('hidden');
                    console.log(iconNameE + splitEnemyPoints[i] + " enemy refreshed");
                } else {
                    $('.' + iconNameF + i).addClass('hidden');
                    $('.' + iconNameE + i).removeClass('hidden');
                    console.log(iconNameE + i + " friendly refreshed");
                }
            }
        });
    }

    function reload() {
        let container = document.getElementById("workspace");
        let content = container.innerHTML;
        container.innerHTML = content;

        //this line is to watch the result in console , you can remove it later
        console.log("Refreshed" + container);
    }

//DRAGGABLE WINDOWS & ICONS--------------------------------------------------------

    $('.draggable').draggable({
        grid: [20, 20], stack: 'div', containment: $(this).parent()
    });

    $('.draggable').on('click', function (event) {
        $(this).addClass('top').removeClass('bottom');
        $(this).siblings().removeClass('top').addClass('bottom');
    });

    //DRAGGABLE POSITION
    $('.draggable').position({
        my: 'center',
        at: 'center',
        of: '#workspace',
        collision: 'flipfit'
    });

//CLOCK--------------------------------------------------------------------
    function renderTime() {

        //DATE
        let myDate = new Date();
        let year = myDate.getYear();
        if (year < 1000) {
            year += 1900;
        }
        let month = myDate.getMonth();
        let day = myDate.getDay();
        let dayOfMonth = myDate.getUTCDate();
        const daysArray = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
        const monthsArray = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec');

        //TIME
        let currentTime = new Date();
        let hours = currentTime.getHours();
        let minutes = currentTime.getMinutes();
        let seconds = currentTime.getSeconds();
        if (hours == 24) {
            hours = 0;
        } else if (hours > 12) {
            hours = hours - 0;
        }

        if (hours < 10) {
            hours = '0' + hours;
        }

        if (minutes < 10) {
            minutes = '0' + minutes;
        }

        if (seconds < 10) {
            seconds = '0' + seconds;
        }

        let myClock = $('.calendar').text(daysArray[day] + ' ' + dayOfMonth + '/' + monthsArray[month] + '/' + year + ' | ' + hours + ':' + minutes);

        setTimeout(function () {
            renderTime()
        }, 1000);
    }

//DROPDOWN MENU------------------------------------------------------------

    function dropdownMenu() {
        const geosMenuElements = $('.functions');

        geosMenuElements.on('mouseover', function (event) {
            $(this).children('ul li').removeClass('hidden').addClass('highest_top');
        })
        geosMenuElements.on('mouseleave', function (event) {
            $(this).children('ul li').addClass('hidden').removeClass('highest_top');
        })
    }

//SHOWING WINDOWS----------------------------------------------------------

    const buttonGeosInfo = $('.geos_info');
    const butonDesktopInfo = $('.desktop_info');
    const buttonStats = $('.show_stats');
    const buttonRecruit = $('.recruit');
    const buttonCalculator = $('.calculator');
    const buttonSnake = $('.end_turn');
    const buttonPoint = $('.ico');
    const buttonSave = $('.save_game');
    const buttonGather = $('.gather');

    function showWindowA() {
        buttonGeosInfo.on('click', function (event) {
            $('.geos_info_container').removeClass('hidden');
        });
    }

    function showWindowB() {
        butonDesktopInfo.on('click', function (event) {
            $('.desktop_info_container').removeClass('hidden');
        })
    }

    function showWindowC() {
        buttonCalculator.on('click', function (event) {
            $('.calculator_container').removeClass('hidden');
        })
    }

    function showWindowD() {
        buttonPoint.on('click', function (event) {
            let pointId = this.className;
            $.post('point', {pointId: pointId}, function (data) {
                point = data.split(",");
                if (point[1] == "true") {
                    document.querySelector('.epname').innerHTML = 'enemy ' + point[0];
                    document.querySelector('.epcash').innerHTML = 'cash ' + point[4];
                    document.querySelector('.epthugs').innerHTML = 'thugs ' + point[5];
                    document.querySelector('.epladies').innerHTML = 'ladies ' + point[6];
                    document.querySelector('.epdealers').innerHTML = 'dealers ' + point[7];
                    document.querySelector('.epmaxthugs').innerHTML = point[10];
                    document.getElementById('attackparty').max = point[10];
                    document.getElementById('attackparty').value = 0;
                    $('.enemy_point_container').removeClass('hidden');
                } else {
                    if (point[2] > 0) {
                        document.querySelector('#point_done').innerHTML = 'Action available';
                    } else {
                        document.querySelector('#point_done').innerHTML = 'Action not available';
                    }
                    document.querySelector('.fpname').innerHTML = 'friendly ' + point[0];
                    document.querySelector('.fpcash').innerHTML = 'cash ' + point[4];
                    document.querySelector('.fpmaxcash').innerHTML = 'of ' + point[9];
                    document.querySelector('.fpthugs').innerHTML = 'thugs ' + point[5];
                    document.querySelector('.fpmaxthugs').innerHTML = 'of ' + point[10];
                    document.querySelector('.fpladies').innerHTML = 'ladies ' + point[6];
                    document.querySelector('.fpmaxladies').innerHTML = 'of ' + point[11];
                    document.querySelector('.fpdealers').innerHTML = 'dealers ' + point[7];
                    document.querySelector('.fpmaxdealers').innerHTML = 'of ' + point[12];
                    document.getElementById('transferCash').min = -point[4];
                    document.getElementById('transferCash').value = 0;
                    document.getElementById('transferCash').max = point[9];
                    document.getElementById('transferThugs').min = -point[5];
                    document.getElementById('transferThugs').value = 0;
                    document.getElementById('transferThugs').max = point[10];
                    document.getElementById('transferLadies').min = -point[6];
                    document.getElementById('transferLadies').value = 0;
                    document.getElementById('transferLadies').max = point[11];
                    document.getElementById('transferDealers').min = -point[7];
                    document.getElementById('transferDealers').value = 0;
                    document.getElementById('transferDealers').max = point[12];
                    $('.friendly_point_container').removeClass('hidden');
                }
            });
        })
    }

    function showWindowE() {
        buttonSnake.on('click', function (event) {
            $('.end_turn_container').removeClass('hidden');
        })
    }

    function showWindowF() {
        buttonSave.on('click', function (event) {
            $('.save_game_container').removeClass('hidden');
        })
    }

    function showWindowG() {
        buttonStats.on('click', function (event) {
            $.post('stats', function (data) {
                let stats = data.split(",");
                document.querySelector('.user').innerHTML = 'User : ' + stats[0];
                document.querySelector('.actions').innerHTML = 'Actions :' + stats[1];
                document.querySelector('.cash').innerHTML = 'Cash :' + stats[2];
                document.querySelector('.thugs').innerHTML = 'Thugs :' + stats[3];
                document.querySelector('.ladies').innerHTML = 'Ladies :' + stats[4];
                document.querySelector('.dealers').innerHTML = 'Dealers :' + stats[5];
                $('.show_stats_container').removeClass('hidden');
            });
        })
    }

    function showWindowH() {
        buttonRecruit.on('click', function (event) {
            $.post('stats', function (data) {
                let stats = data.split(",");
                document.querySelector('.recruitCash').innerHTML = stats[2];
                document.querySelector('.recruitThugs').innerHTML = stats[3];
                document.querySelector('.recruitLadies').innerHTML = stats[4];
                document.querySelector('.recruitDealers').innerHTML = stats[5];
                document.getElementById('recruitThugs').value = 0;
                document.getElementById('recruitLadies').value = 0;
                document.getElementById('recruitDealers').value = 0;
                $('.recruit_container').removeClass('hidden');
                $('.recruitInput').on('change', function () {
                    let recruitThugs = document.getElementById('recruitThugs').value;
                    let recruitLadies = document.getElementById('recruitLadies').value;
                    let recruitDealers = document.getElementById('recruitDealers').value;
                    $('.recruitCash').text(stats[2] - (recruitThugs * 5) - (recruitLadies * 5) - (recruitDealers * 5));
                });
            });
        });
    }

    function showWindowI() {
        buttonGather.on('click', function (event) {
            $.post('checkAP', function (data) {
                if (data == "0") {
                    $('.ap_alert_container').removeClass('hidden');
                } else {
                    $('.gather_container').removeClass('hidden');
                }
            });
        });
    }

//CLOSE BY BUTTON----------------------------------------------------------

    $('.bar_close').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.geos_welcome_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.geos_info_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.desktop_info_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.save_game_container_button').on('click', function (event) {
        $.post('save');
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.gather_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
        let gather = true;
        $.post('endturn', {gather: gather}, function (data) {
            $('#result1').html(data);
        });
        $('.turn_finished_container').removeClass('hidden');
    });

    $('.end_turn_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
        let gather = false;
        $.post('endturn', {gather: gather}, function (data) {
            $('#result1').html(data);
        });
        $('.turn_finished_container').removeClass('hidden');
    });

    $('.turn_finished_container_button').on('click', function (event) {
        $.post('save');
        $(this.closest('.draggable')).addClass('hidden');
        refreshIcons();
    });

    $('.point_container_button').on('click', function (event) {
        // pointNumber = 0;													//?
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.show_stats_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.recruit_container_button').on('click', function (event) {
        let recruitThugs = document.getElementById('recruitThugs').value;
        let recruitLadies = document.getElementById('recruitLadies').value;
        let recruitDealers = document.getElementById('recruitDealers').value;
        $.post('recruit', {recruitThugs: recruitThugs, recruitLadies: recruitLadies, recruitDealers: recruitDealers});
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.attack_container_button').on('click', function (event) {
        if (point[8] < 1) {
            point = '';
            $(this.closest('.draggable')).addClass('hidden');
            $('.ap_alert_container').removeClass('hidden');
        } else {
            let howMany = document.getElementById('attackparty').value;
            let pointNumber = parseInt(point[0].substring(5));
            if (howMany > 0) {
                $.post('attack', {howMany: howMany, pointNumber: pointNumber}, function (data) {
                    $('#result2').html(data);
                });
                $.post('save');
                point = '';
                $(this.closest('.draggable')).addClass('hidden');
                refreshIcons();
                $('.attack_result_container').removeClass('hidden');
            }
        }
    });

    $('.attack_result_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.transfer_container_button').on('click', function (event) {
        if (point[2] < 1) {
            $('.transfer_alert_container').removeClass('hidden');
        } else {
            let transferCash = document.getElementById('transferCash').value;
            let transferThugs = document.getElementById('transferThugs').value;
            let transferLadies = document.getElementById('transferLadies').value;
            let transferDealers = document.getElementById('transferDealers').value;
            let pointNumber = parseInt(point[0].substring(5));
            $.post('transfer', {
                pointNumber: pointNumber,
                transferCash: transferCash,
                transferThugs: transferThugs,
                transferLadies: transferLadies,
                transferDealers: transferDealers
            });
            $.post('save');
        }
        point = '';
        $(this.closest('.draggable')).addClass('hidden');
    });

    $('.alert_container_button').on('click', function (event) {
        $(this.closest('.draggable')).addClass('hidden');
    });

    //RESET SITE BY RESET BUTTON

    $('.reset').on('click', function (event) {
        location.reload();
    });

//CALCULATOR---------------------------------------------------------------

    let key = null;

    $(".clean").click(function () {
        $('.input').val("");
    });

    $(".show").click(function () {
        let eText = $('#result').val();
        if (eText != "0") {
            let val1 = eText;
            let buttonVal = $(this);
            let val2 = buttonVal.text();
            let res = val1 + val2;
            $('#result').val(res);
        } else {
            $('#result').val();
        }
    });

    $(function (e) {
        let interRes = null;
        let operator;
        $('.operators').click(function (e) {
            let value1 = $('#result').val();
            if (interRes != null) {
                let result = ApplyOperation(interRes, value1, operator);
                interRes = result;
            } else {
                interRes = value1;
            }
            operator = $(this).text();
            $('input').val("");
        });
        $('#result').keypress(function (e) {
            if ((e.keyCode == 61)) {
                let op = operator;
                let res;
                let value2 = $('#result').val();
                if ((value2 != "")) {
                    let data = value2.split("+");
                    if (data.length > 2) res = ApplyOperation(interRes, data[data.length - 1], op);
                    else res = ApplyOperation(interRes, data[1], op);
                } else {
                    res = interRes;
                }
                $('#result').val(res);
                interRes = null;
            } else if ((e.keyCode == 43) || (e.keyCode == 45) || (e.keyCode == 42) || (e.keyCode == 47)) {
                let value1 = $('#result').val();
                let inter = (interRes != null);
                if (inter) {
                    let op = operator;
                    let data = value1.split("+");
                    if (data.length > 2) {
                        operator = String.fromCharCode(e.keyCode);
                        result = ApplyOperation(interRes, data[data.length - 1], op);
                        interRes = result;
                    } else {
                        operator = String.fromCharCode(e.keyCode);
                        result = ApplyOperation(interRes, data[1], op);
                        interRes = result;
                    }
                } else {
                    interRes = value1;
                }
                operator = String.fromCharCode(e.keyCode);
                $('.input').text("");
            }
        });
        $('#calculate').click(function (e) {
            let op = operator;
            let res;
            let value2 = $('#result').val();
            if ((value2 != "")) {
                res = ApplyOperation(interRes, value2, op);
            } else {
                res = interRes;
            }
            $('#result').val(res);
            interRes = null;
        });
    });

    function ApplyOperation(value1, value2, operator) {
        let res;
        switch (operator) {
            case "+":
                res = addition(value1, value2);
                break;
            case "-":
                res = subtraction(value1, value2);
                break;
            case "*":
                res = multiplication(value1, value2);
                break;
            case "/":
                res = division(value1, value2);
                break;
        }
        return res;
    }

    function addition(first, second) {
        let a = parseFloat(first);
        let b = parseFloat(second);
        return a + b;
    }

    function subtraction(first, second) {
        let a = parseFloat(first);
        let b = parseFloat(second);
        return a - b;
    }

    function multiplication(first, second) {
        let a = parseFloat(first);
        let b = parseFloat(second);
        return a * b;
    }

    function division(first, second) {
        let a = parseFloat(first);
        let b = parseFloat(second);
        return a / b;
    }

//OTHER--------------------------------------------------------------------

    //DISABLE SCROLL FOR WINDOW/DOCUMENT
    $('html, body').css({
        overflow: 'hidden',
        height: '100%'
    });
//SAVING GAMESTATE---------------------------------------------------------
//setInterval(function(){  
//	let cash = $("#cash").text();
//	let thugs = $("#thugs").text();
//	let ladies = $("#ladies").text();
//	let dealers = $("#dealers").text();
//	$.post("save", {cash: cash, thugs: thugs, ladies: ladies, dealers: dealers});
//	}, 300000);	
//RENDER FUNCTIONS HERE----------------------------------------------------
    renderTime();
    dropdownMenu();
    showWindowA();
    showWindowB();
    showWindowC();
    showWindowD();
    showWindowE();
    showWindowF();
    showWindowG();
    showWindowH();
    showWindowI();
});