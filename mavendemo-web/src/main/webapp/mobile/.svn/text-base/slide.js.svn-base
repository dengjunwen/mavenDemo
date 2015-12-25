

	//第一种方式
    $(document).on('click','.pb-standalone-captions',function (obj) {
    	currID = obj.currentTarget.id;
    	var phoBrowser = $.photoBrowser({photos : addOPhoto(),theme: 'light',type: 'standalone',initialSlide:"0",ofText:"/",zoom:"!1",navbar:"!1",spaceBetween:10});
    	phoBrowser.open();
    });
    
	//添加'refresh'监听器
	$(document).on('refresh', '.pull-to-refresh-content',function(e) {
	    // 模拟2s的加载过程
	    setTimeout(function() {
	        var cardNumber = $(e.target).find('.card').length + 1;
	        var cardHTML = '<div class="card posi" >' +
	                            '<div class="card-content blackbacg" >' +
	                            	"<img class='card-cover zoomin pb-standalone-captions' src='${path}/demoH5/img/gallery/"+cardNumber+".png' alt=''>"+
	                            	"<div class='card-content-inner'>"+
	                            	"<p>使用纸杯蛋糕的制作之南</p><p class='color-gray'>发表于 2015/01/15</p>"+
	                            	'</div>'+
	                            	'</div>' +
	                          '</div>' +
	                      '</div>';
	        $(e.target).find('.card-container').prepend(cardHTML);
	        // 加载完毕需要重置
	        $.pullToRefreshDone('.pull-to-refresh-content');
	    }, 2000);
	});
	
	//图片浏览器
    function addOPhoto(){
    	var arr = new Array();
    	for(var i=0;i<3;i++){
    		var photo={};
    		var texthtml ="<div style='text-align:left;font-size:0.7rem;overflow:hidden;margin-top:-8rem;word-break:break-all '>"+
    				"<span style='font-size:14px;font-weight:bold'>深圳，自由的手机设计</span><br/>"+
    				"<span class=''>记录 236</span>"+
    				"<div style='font-size:12px;'>「Knotty Objects: Phone」是麻省理工媒体实验室 Knotty Objects 峰会的系列视频之一。手机带给人们自由的通信，却也反过来产生控制。</div>"+
    				"<br/><br/>"+
    				"<div style='margin-left:3rem;font-size:12px;' conclik='transferHtml()'>"+
	    				"<img src='${path}/img/comment_24.png' style='vertical-align:middle' onclick='comment()'>&nbsp;&nbsp;"+
	    				"<img src='${path}/img/comment_24.png' style='vertical-align:middle'>&nbsp;&nbsp;"+
	    				"<img src='${path}/img/comment_24.png' style='vertical-align:middle'>&nbsp;&nbsp;"+
	    				"<img src='${path}/img/comment_24.png' style='vertical-align:middle'>&nbsp;&nbsp;"+
	    				"<img src='${path}/img/comment_24.png' style='vertical-align:middle'>&nbsp;&nbsp;"+
    				"</div>"+
    				"</div>";
    		var imgHtml="";
    		if(i==2){
    			//imgHtml='<video style="height:15rem;width:18rem;margin-top:-10rem" src="${path}/mobile/test.mp4" controls="controls" poster="${path}/demoH5/img/gallery/3.png" >';
    			imgHtml="<iframe src='${path}/mobile/video' frameborder='0' allowfullscreen='allowfullscreen'></iframe>";
    		}else if(i==1){
    			imgHtml="<iframe src='${path}/mobile/audio' frameborder='0' allowfullscreen='allowfullscreen'></iframe>";
    		}else if(i==0){
    			imgHtml="<div style='height:15rem;width:18rem;margin-top:-8rem;'>"+
    					"<img src='${path}/demoH5/img/gallery/4.png'></div>";
    		}
    		photo["html"] = imgHtml;
    		photo["caption"] =texthtml;
    		arr.push(photo);
    	}
    	return arr;
    }
    
 //初始化载入
    function defaultCard(){
    	var cardHTML ="";
    	for(var i=3;i<8;i++){cardHTML+=createHtmlTest(i);}
    		cardHTML += '<div class="card"  >' +
		        '<div class="card-content" >' +
		        '<div class="card-content-inner">'+
		        	"<img class='card-cover zoomin' src='${path}/img/end.jpg' alt=''>"+
		      		'</div>' +
		      		'</div>' +
		  		'</div>';
    	$(document).find('.card-container').prepend(cardHTML);
    }
    
    function createHtmlTest(num){
        var cardHTML = '<div class="card posi" id=00'+num+' >' +
                            '<div class="card-content blackbacg" >' +
                            	"<img id='img_"+num+"'  class='card-cover zoomin open-about' src='${path}/demoH5/img/gallery/"+num+".png' alt=''>"+
                            	"<div class='card-content-inner'>"+
                            	"<p>使用纸杯蛋糕的制作之南</p><p class='color-gray'>发表于 2015/01/15</p>"+
                            	'</div>'+
                            	'</div>' +
                          '</div>' +
                      '</div>';
          return cardHTML;
}    