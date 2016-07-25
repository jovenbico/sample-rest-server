# sample-rest-server


## how to run
	$ gradle bootRun

## As a customer, i want to order a coffee so that Starbucks can prepare my drink
	POST http://localhost:8181/customers/order
	{"name":"latte"}
	{"id":"...","name":"latte"}

## As a customer, i want to be able to change my drink to suit my tastes
	PUT http://localhost:8181/customers/order
	{"id":"...","name":"latte"}
	{"id":"...","name":"latte"}

## As a barista, i want to see the list of drinks that i need to make, so that i can serve my customers
	GET http://localhost:8181/barista/orders
	[{"id":"...","name":"latte"},...]

	GET http://localhost:8181/customers/order/{id}
	{"id":"...","name":"latte"}