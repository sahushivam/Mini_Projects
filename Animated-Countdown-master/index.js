function animateClock(span){
	span.className = "turn";
	setTimeout(function(){
		span.className = "";
	}, 700);
}



function updateTimer(deadline){
	var time = deadline - new Date();
	return {
		'days': Math.floor(time/(1000*60*60*24)), 
		'hours': Math.floor( (time/(1000*60*60))%24 ), 
		'minutes': Math.floor( (time/(1000*60))%60 ), 
		'seconds': Math.floor( (time/1000)%60 ), 
		'total': time
	};
}


function startTimer(id, deadline){
	var timeInterval = setInterval(function(){
		var clock = document.getElementById(id);
		var timer = updateTimer(deadline);
		clock.innerHTML = '<span>'+ timer.days +'</span>'
							+ '<span>'+ timer.hours +'</span>'
							+ '<span>'+ timer.minutes +'</span>'
							+ '<span>'+ timer.seconds +'</span>'; 
		
		var spans = clock.getElementsByTagName("span");
		animateClock(spans[3]);
		if(timer.seconds == 59) { 
			animateClock(spans[2]);
		}
		if(timer.seconds == 59 && timer.minutes==59) { 
			animateClock(spans[1]);
		}
		if(timer.seconds == 59 && timer.minutes==59 && timer.hours==23) { 
			animateClock(spans[0]);
		}

		if (timer.total < 1){
			clearInterval(timeInterval);
			clock.innerHTML = '<span>0</span><span>0</span><span>0</span><span>0</span>';
		}
	
	}, 1000);
}


window.onload = function() {
	var deadline = new Date("September 15, 2018 12:59:59"); 
	startTimer("clock", deadline);
};