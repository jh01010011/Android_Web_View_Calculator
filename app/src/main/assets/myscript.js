
function func(x){
	var disp =document.getElementById('disp');
	var text=disp.textContent;
	if(text=="0"){
		disp.innerHTML="";
		text=disp.textContent;
		disp.innerHTML=text+x;
	}
	else{
		disp.innerHTML=text+x;
	}
	
	
	
}


function new_function(){
        android.test();
}

function clear_disp(){

	disp =document.getElementById('disp').innerHTML=0;


}

function del(){

	var disp =document.getElementById('disp');
	var text=disp.textContent;
	if(text.length-1>0){
		var text2=text.substring(0, text.length-1);
		disp.innerHTML=text2;	
	}
	else{
		disp.innerHTML=0;	
	}
}

function result(){
    var disp =document.getElementById('disp');
    	var text=disp.textContent;
    document.getElementById('disp').innerHTML=android.result(text);
}