# Machine instance prices API

*** Important: Do NOT fork this repository if you want to submit a solution ***

Imagine we run our infrastructure on a fictional cloud provider smartcloud. As their machine instance prices fluctuate all the time, Smartcloud provides an API for us to retrieve their prices in real time. This helps us in managing our cost.

# Requirements

Implement an API for fetching and returning machine instance prices from [smartcloud](https://hub.docker.com/r/smartpayco/smartcloud).

```
GET /prices?kind=sc2-micro
{"kind":"sc2-micro","amount":0.42}, ... (omitted)
```

The scaffold project provides an end-to-end implementation for returning instance kinds from smartcloud. You should try to follow the same code structure.

You should implement `SmartcloudPriceService` to call the [smartcloud](https://hub.docker.com/r/smartpayco/smartcloud) endpoint and return the price data. Once done, you should implement an endpoint and update the wiring that your endpoint will return data from the smartcloud.

You should also include a README file to document:-
1. Any assumptions you make
1. Any design decisions you make
1. Instruction on how to run your code

You should use git and make small commits with meaningful commit messages as you write your code.

# Setup

Follow the instruction at [smartcloud](https://hub.docker.com/r/smartpayco/smartcloud) to run the docker container on your machine.

Clone or download this project onto your machine and run

```
$ sbt run
```

The API should be running on your port 8080.

# How to submit

Please push your code to a public repository and submit the link via email. Please do not fork this repository.
