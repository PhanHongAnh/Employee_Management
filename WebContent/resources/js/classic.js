$(document).ready(function(){
	$(".dropdown").hover(            
	    function() {
	        $('.dropdown-menu', this).not('.in .dropdown-menu').stop( true, true ).slideDown("fast");
	        $(this).toggleClass('open');        
	    },
	    function() {
	        $('.dropdown-menu', this).not('.in .dropdown-menu').stop( true, true ).slideUp("fast");
	        $(this).toggleClass('open');       
	    }
	);

	$('#nav-icon2').hover(function(){
		$(this).toggleClass('open');
	});
	
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function (e) {
                $('#imgInp').attr('src', e.target.result);
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }
    
    $("#avt").change(function(){
        readURL(this);
    });
});
