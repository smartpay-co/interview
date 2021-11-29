# Checkout

Build an API for creating checkout.

# Requirements

Build an API endpoint to simulate checkout creation.

A sample JSON body is as follows:

```json
POST /v1/checkouts
{
	"amount": 550000,
	"currency": "JPY",
	"lineItems": [
		{
			"description": "Full frame mirrorless camera",
			"amount": 250000,
			"currency": "JPY",
			"quantity": 1
		},
		{
			"description": "24-70mm f/2.8 camera lens",
			"amount": 300000,
			"currency": "JPY",
			"quantity": 1
		}
	],
	"card": {
	    "holderName": "Peter Parker",
		"number": 4242424242424242,
	    "securityCode": 242,
		"expMonth": 4,
	    "expYear": 2024
	}
}
```

Note that all fields are required and the `"lineItems"` must consist of at least one object.

The API endpoint should persist the checkout data in the `CheckoutStore` using your preferred choice of in-memory data structure.

The API endpoint should return the following response:
```json
200 OK
{
    "id" -> "checkout_g696FQQqKkoRkncDW4MXgd",
    "object" -> "checkout",
    "amount": 550000,
	"currency": "JPY",
	"lineItems": [
		{
            "id": "li_2Zkwkq95xObmqXdYj9h5XS",
            "object": "lineItem",
			"description": "Full frame mirrorless camera",
			"amount": 250000,
			"currency": "JPY",
			"quantity": 1
		},
		{
            "id": "li_nZUDIZZ5A6lZuROJ21AYXJ",
            "object": "lineItem",
			"description": "24-70mm f/2.8 camera lens",
			"amount": 300000,
			"currency": "JPY",
			"quantity": 1
		}
	],
	"card": {
        "id": "card_YQhIRPemQFXsKsiEIPIwSG",
        "object": "card",
		"last4": 4242,
		"expMonth": 4,
	    "expYear": 2024
	}
}
```

While this may be obvious, please do not use any real credit card details for testing.

### Error response

In the event of an error, your JSON response should include the following fields:

1. `statusCode`: HTTP status code, eg. `400`.
2. `errorCode`: A dot notation indicating the error, eg. `request.invalid`.

### Validation

You should build in basic validations including but not limited to the following:

1. All fields must be present and line items must not be empty.
2. Total amount of all line items must be equal to the checkout amount.
3. Card number provided must be in 16 digits and card must not be expired.

For any of the validation failures, you should return the suitable status code and error code.

### Scaffold

You should use the project scaffold and implement the following:

1. Implement the in-memory CheckoutStore.
2. Implement the CheckoutService.
3. Implement the CheckoutRoutes.
