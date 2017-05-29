simpleCart( {
    checkout: { 
        type: "SendForm" , 
        url: "https://formspree.io/mikkokraft@gmail.com" ,
        extra_data: {
          	c_email: "" ,
          	c_name: "" ,
          	c_address: "" ,
          	c_phone: "" ,
          	c_message: ""
        }
    } 
});

function validateEmail($email) {
  var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
  return emailReg.test( $email );
}

simpleCart.bind( 'beforeCheckout' , function( data ){
	data.c_email = 'mikko@kraft.fi';
 	if( !validateEmail(data.c_email)) {
		alert('proper email needed');
		data = null;
 	};
 	data.c_name = $('#c_name').val();
 	data.c_address = $('#c_address').val();
 	data.c_phone = $('#c_phone').val();
 	data.c_message = $('#c_message').val();
 	alert('hello');
});