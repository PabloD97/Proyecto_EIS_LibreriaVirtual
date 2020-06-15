function eliminar(isbn) {
	swal({
		  title: "Estas seguro de eliminar el libro?",
		  text: "Una vez eliminado, no podras recuperarlo!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((OK) => {
		  if (OK) {
			  $.ajax({
				  url:"/eliminar/"+isbn,
				  success: function(res) {
					  console.log(res);
				  },
			  });
		    swal("Puf! El libro fue eliminado!", {
		      icon: "success",
		    }).then((ok) => {
		    	if(ok){
		    		location.href="/";
		    	}
		    });
		  } else {
		    swal("No se elimino el libro!");
		  }
		});
}