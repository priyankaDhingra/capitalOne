
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).on('ready',function(){
            var username ="priyanka.dhingra";
            var password ="Priyanka@13"; 
            var urlhttp='http://api.reimaginebanking.com:80/customers/';
            function make_base_auth(user, password) {
              var tok = user + ':' + password;
              var hash = btoa(tok);
              return "Basic " + hash;
            }
                $.ajax({
                  url: urlhttp,//'http://api.reimaginebanking.com:80/customers/54b604dfa520e02948a0f6da?key=CUSTef1201a2026ed3eb998e422cf3d63217',
                 data : {key : 'CUSTef1201a2026ed3eb998e422cf3d63217'},
                  dataType: "json",
                  type: "get",
                  success: function(data){
                	  
                	  $.each(data, function(i, item) {
                		  $('#captable').append('<tr><td >'+item['first name']+'</td><td >'+item['last name']+'</td><td >'+item.address.street+' '+item.address.city+' '+item.address.state+' '+item.address.zip+'</td><td >'+item.accounts+'</td></tr>');});​ },
                                    error: function() {         
                                        console.log("error");
                                    },
                });
              
 });
</script>

<table id="captable">
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Address</th>
	<th>Accounts</th>
</tr>
<tr>
<td ></td>
</tr>

</table>
 