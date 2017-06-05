function changeVisibility(id) {
	
	var x = document.getElementById(id); 
	var yy = document.querySelectorAll(".simpleCart_shelfItem");
	
	if (x.style.display === 'block') {
		x.style.display = "none";
	}
	else {
		for (var i = 0; i < yy.length; i++) {
    		if (yy[i].style.display === 'block') {
     			yy[i].style.display = "none";
    		}
		}
		x.style.display = 'block';
	}
}