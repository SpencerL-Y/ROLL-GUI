

const {ipcRenderer} = require("electron");
let $ = require("jquery");
var JSONdata={"MQ":"","EQ":""};// JSON object

	var memNum = 0;
	var equiNum = 0;
	$(function(){
			$("#submitAlpha").click(function(){
					
					ipcRenderer.send("alphabetSubmit",$("#alphabet").val());  	
					//callback function        
					ipcRenderer.once("callback",(event,arg)=>{	          
							JSONdata = JSON.parse(arg);//parse JSON string
							$("#MemQuery").val(JSONdata.MQ);//display Membership Query
							$("#EquiQuery").val(JSONdata.EQ);//display Equivalence Query
							$("#submitAlpha").addClass("disabled");//disable submit btn
							$("#memNum").text("0");
							$("#equiNum").text("0");
							memNum = 0;
							equiNum = 0;
							
						});
					
					
					
				})
		})
	
	$(function(){
			$("#MQButtonY").click(function(){
				
					ipcRenderer.send("MQY","MQY");  	
					ipcRenderer.once("callback",(event,arg)=>{
							JSONdata = JSON.parse(arg);
							$("#MemQuery").val(JSONdata.MQ);
							$("#EquiQuery").val(JSONdata.EQ);
							document.getElementById("memNum").innerHTML= memNum+1;
							memNum+=1;
						});
				})
		})
	
	$(function(){
			$("#MQButtonN").click(function(){
					
					ipcRenderer.send("MQN","MQN");  	
					ipcRenderer.once("callback",(event,arg)=>{
							JSONdata = JSON.parse(arg);
							$("#MemQuery").val(JSONdata.MQ);
							$("#EquiQuery").val(JSONdata.EQ);
							document.getElementById("memNum").innerHTML= memNum+1;
							memNum+=1;
						});
				});
		
		})
		
	$(function(){
			$("#EQButtonY").click(function(){
					
					ipcRenderer.send("EQY","EQY");  	
					ipcRenderer.once("callback",(event,arg)=>{
							JSONdata = JSON.parse(arg);
							$("#MemQuery").val(JSONdata.MQ);
							$("#EquiQuery").val(JSONdata.EQ);
							document.getElementById("equiNum").innerHTML= equiNum+1;
							equiNum+=1;
							$("#submitAlpha").removeClass("disabled");
						});
						
					
				});
		
		})
		//automatic learning
	$(function(){
			$("#EQButtonN").click(function(){
					
					ipcRenderer.send("EQN","EQN");  	
					ipcRenderer.once("callback",(event,arg)=>{
							JSONdata = JSON.parse(arg);
							$("#MemQuery").val(JSONdata.MQ);
							$("#EquiQuery").val(JSONdata.EQ);
							document.getElementById("equiNum").innerHTML= equiNum+1;
							equiNum+=1;
						});
			
		});
	})
		
	$(function(){
			$("#autoRun").click(function(){
				ipcRenderer.send("autoRun",$("#editor").val());  	
				ipcRenderer.once("autoback",(event,arg)=>{
							$("#result").html(arg);
						});
					
					
				});
		})
		
