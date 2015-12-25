
var $player ="";
var player="";
var totalTime="";
var lyric_wrap="";
var lyric="";

function initMusicPlayer(id,lyricUrl){
	lyric_wrap = $(".lyric_wrap"),
    lyric = lyric_wrap.find("#lyric");
	//音乐播放器
	musicPlayer(lyricUrl);
	
	$player = $(id);
	player = $player.get(0);
	totalTime =player.duration;
	
	//alert(totalTime);
	//shutdownMediaObj(player);
	
	$player.bind("timeupdate",function(){
	        showLyrics();
	   });
	
}

function shutdownMediaObj(obj){
	$(obj).bind("pause",function(){
		
		alert(this.paused);
		
		if(this.paused){
			var id = this.id;
			id=id.replace("audio_id_","");
			id=id.replace("video_id_","");
			$(".controlImg_"+id).attr("src",playsrc);
		}
		
   });
}

function musicPlayer(lyricUrl){
		    $.ajax({
		        url:lyricUrl,
		        headers:{contentType:"application/x-www-form-urlencoded"},
		        success:function(lrc){
		            var lyric = parseLyric(lrc);
		        },
		        error:function(e){
		            alert('Ajax error!');
		        }
		    });
		}
	
	function Lyrics(url){
	    this.url = url;
	    this.fetch = function(success,error){
	        $.ajax({
	            url:this.url,
	            headers:{
	                contentType:"application/x-www-form-urlencoded"
	            },
	            success:function(lrc){
	                var lyric = parseLyric(lrc);
	                if(success)success(lyric);
	            },
	            error:function(e){
	                if(error)error(e);
	            }
	        });
	    };
	}
		
	function parseLyric(lrc) {
		
	    var lyrics = lrc.split("\n");
	    var lrcObj = {};
	    for(var i=0;i<lyrics.length;i++){
	        var lyric = decodeURIComponent(lyrics[i]);
	        var timeReg = /\[\d*:\d*((\.|\:)\d*)*\]/g;
	        var timeRegExpArr = lyric.match(timeReg);
	        if(!timeRegExpArr)continue;
	        var clause = lyric.replace(timeReg,'');

	        for(var k = 0,h = timeRegExpArr.length;k < h;k++) {
	            var t = timeRegExpArr[k];
	            var min = Number(String(t.match(/\[\d*/i)).slice(1)),
	                sec = Number(String(t.match(/\:\d*/i)).slice(1));
	            var time = min * 60 + sec;
	            lrcObj[time] = clause;
	        }
	    }
	    
	    $player['lyric'] = lrcObj;
	    return lrcObj;
	}
	
	//开始计时
	var text_temp;
	function showLyrics(){
		 	var data =  $player['lyric'];
		 	var i=0;
		 	$player['parsed']={};
		 	
		 	for(var k in data){
		 		 	var txt = data[k];
		            if(!txt)txt = "&nbsp;";
		            $player['parsed'][k] = {index:i++,text:txt,top:i*(-0.8)};
		    }
		 	
		 	$player.bind("timeupdate",updateLyrics);
	}
	
	
	
	function updateLyrics(){
		
		var data = $player['parsed'];
	    if(!data)return;
	    var margintop=$(".lyric_wrap").find("#lyric");
	    
	    var currentTime = Math.round(player.currentTime);
	    
	    if(data[currentTime]){
	    	var lrc = data[currentTime].text;
	 	    var tm = data[currentTime].index;
	 	   var top = data[currentTime].top;
	 	    if(!lrc)lrc = "&nbsp;";
	 	    
		    if(text_temp!=lrc){
		    	var li = $("<li>"+lrc+"</li>");
		    	lyric.append(li);
		    	top=3+top;
		    	margintop.css("margin-top",top+"rem");
		    }
		    text_temp = lrc;
	    }
	   
	}
	
	
	function renderLyric(music){
	    lyric.html("");
	    
	    var lyricLineHeight = 27,
	        offset = lyric_wrap.offset().height*0.4;
	    
	    	music.lyric.fetch(
	    			function(data){
				        music.lyric.parsed = {};
				        var i = 0;
				        for(var k in data){
				            var txt = data[k];
				            if(!txt)txt = "&nbsp;";
				            music.lyric.parsed[k] = {
				                index:i++,
				                text:txt,
				                top: i*lyricLineHeight-offset
				            };
				            
				            var li = $("<li>"+txt+"</li>");
				            lyric.append(li);
				        }
				        
	        $player.bind("timeupdate",updateLyric);
	        
	    },function(){
	        lyric.html("<li style='text-align: center'>歌词加载失败</li>");
	    });
	}
	
	
	
	
	
	function updateLyric(){
		
	    var data = $player.music.lyric.parsed;
	    if(!data)return;
	    var currentTime = Math.round(this.currentTime);
	    var lrc = data[currentTime];
	    
	    if(!lrc)return;
	    var text = lrc.text;
	    if(text != text_temp){
	        locationLrc(lrc);
	        text_temp = text;
	    }
	    
	    function locationLrc(lrc){
	        lyric_wrap.find(".lyric_wrap .on").removeClass("on");
	        var li = lyric_wrap.find("li:nth-child("+(lrc.index+1)+")");
	        li.addClass("on");
	        var top = Math.min(0,-lrc.top);
	        //lyric.css({"-webkit-transform":"translate(0,-"+lrc.top+"px)"});
	        lyric.css({"margin-top":top});
	    }
	}
	