const CACHE_NAME ='v1';
const urlsToCache=[
	'ketrace/INDEX.html',
	'./assets/css/style-starter.css',
	'./assets/images/b1.jpg',
	'./assets/images/192.png',
	'./assets/images/logo-icon.png',
	'./assets/js/theme-change.js',
	'./assets/js/bootstrap.min.js',
	'./assets/js/jquery-3.3.1.min.js',	
];
// call the install event
self.addEventListener('install', function(event) {
	console.log('SERVICE-=WORKER INSTALLED');
	self.skipWaiting();
	event.waitUntil( 
		caches.open(CACHE_NAME)
		.then(cache => {
			return cache.addAll(urlsToCache);
		})
		);
		});	
self.addEventListener('fetch', event => {
	event.respondWith(
		caches.match(event.request)
		.then(response => { 
			return response || fetch(event.request);
		})	
	);
});		

