<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<% 
String scripted = renderRequest.getAttribute("cid")+""; 
%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	  
$(document).on('ready',function(){
            var username ="priyanka.dhingra";
            var password ="Priyanka@13"; 
          
            function make_base_auth(user, password) {
              var tok = user + ':' + password;
              var hash = btoa(tok);
              return "Basic " + hash;
            }
            $("#edit_btn").removeAttr( "hidden" );
            var urlhttp='http://api.reimaginebanking.com:80/customers/';
            var urlval=urlhttp + "<%=scripted%>";
                $.ajax({
                  url: urlval,//'http://api.reimaginebanking.com:80/customers/54b604dfa520e02948a0f6da?key=CUSTef1201a2026ed3eb998e422cf3d63217',
                 data : {key : 'CUSTef1201a2026ed3eb998e422cf3d63217'},
                  dataType: "json",
                  type: "get",
               
                  success: function(data){
                	  $('#city').val(data.address.city);
              	 	$('#state').val(data.address.state);
              	 	$('#streetno').val(data.address['street number']);
              		$('#streetnm').val(data.address['street name']);
              	 	$('#zip').val(data.address.zip);
                	 $('#fname').val(data['first name']);
                	 $('#lname').val(data['last name']);
                	 
                	 	
                  },
                                    error: function() {         
                                        console.log("error");
                                    },
                });
                $("#edit_btn").click(function() {
                	 $('#streetno').removeAttr( "readonly" );
              	  $('#streetnm').removeAttr( "readonly" );
              	 $('#city').removeAttr( "readonly" );
              	 $('#state').removeAttr( "readonly" );
              	 $('#zip').removeAttr( "readonly" );
              	  $("#edit_btn").attr("hidden");
              	  $("#save_btn").removeAttr( "hidden" );
              	
              });
                
                $("#save_btn").click(function(){
                	var r = { "address": {
               		    "street number":  $('#streetno').val(),
               		    "street name":$('#streetnm').val(),
               		    "city":  $('#city').val(),
               		    "state": $('#state').val(),
               		    "zip": $('#zip').val(),
               		  } };
                	
                	var ur="http://api.reimaginebanking.com:80/customers/";
                	 var ural=ur + "<%=scripted%>";
                $.ajax({
                    url: ural+"?key=CUSTef1201a2026ed3eb998e422cf3d63217",
                    dataType: "json",
                    headers: { 'Access-Control-Allow-Origin': '*' },
                    data:JSON.stringify(r),
                    type: 'PUT',
                    contentType: 'application/json; charset=utf-8',
                  
                    crossDomain: true,
                   
                    success: function(){
                  		alert("Submitted");
                    },
                                      error: function(err) {         
                                          console.log(err);
                                      },
                }); });
              
 });
</script>

    
 First Name: 
<input type="text" readonly="readonly" id="fname" /><br/><br/>
Last Name: 
<input type="text" readonly="readonly" id="lname" /><br/><br/>
Address <br/><br/>

Street No:
<input type="text" readonly="readonly" id="streetno" class="addr"/><br/><br/>
Street Name:
<input type="text" readonly="readonly" id="streetnm" class="addr"/><br/><br/>
City:
<input type="text" readonly="readonly" id="city" class="addr" /><br/><br/>
State: 
<input type="text" readonly="readonly" id="state" class="addr" /><br/><br/>
Zip: 
<input type="text" readonly="readonly" id="zip" class="addr"/><br/><br/>
<input type="button" value="Edit" id="edit_btn"  hidden=""/><br/><br/>
<input type="submit" value="Save" id="save_btn" hidden="" /><br/><br/>


