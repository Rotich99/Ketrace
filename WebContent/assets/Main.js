if ('serviceWorker' in navigator) {
   // Register a service worker hosted at the root of the
   // site using the default scope.
     navigator.serviceWorker.register('./SW.js')
     .then(registration => {
		console.log('Registration of service-worker succesful thats good and what about its installation now?******');	
    	 }).catch(err => {
    	   console.log('Service worker registration failed but why did it fail mehn:', err);
    	  });
  }