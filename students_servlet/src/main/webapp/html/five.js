
var store={
    users:[],
    
    addUser:function(inputElementId,nameElementId){
          console.log("inside addUser");
          var idElement=document.getElementById(inputElementId);
          var usernameElement=document.getElementById(nameElementId);
          console.log("id="+idElement.value +" name="+usernameElement.value);
          var idElementVal=idElement.value;
          var usernameVal=usernameElement.value;
          var user1={"userid":idElementVal,"username":usernameVal};
          this.users.push(user1);
          idElement.value="";
          usernameElement.value="";
          
       },
    
     displayUsers:function(displayElementId){
      var display= document.getElementById(displayElementId) ;
      console.log("users="+JSON.stringify(this.users));
      var newElement='';
      for(var i=0;i<this.users.length;i++){
          var userData=this.users[i];
          console.log("index="+i+" user="+JSON.stringify(userData));
          var userId=userData.userid;
          var username=userData.username;
          newElement=newElement+"<div>"+ userId+","+username +"</div>";
       
      }
      display.innerHTML=newElement;   
     }
    
    };
    
    