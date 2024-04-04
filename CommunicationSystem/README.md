Design a system that acts as a communication layer in your organization.

Request:
Your system should be able to take different type of communication requests

Email request
Sms request
Soundbox request
And so on..
Each request will take different inputs as per the requirement for that request type.
E.g. Email requests need to have a sender, receiver, subject and message as mandatory fields.
While a sms request may require a mobile number and the message as mandatory fields.

Provider:
Your system will be integrating with external providers and call their API in order to be able to send out the required communication. So, your system needs to onboard these providers.

A provider can support multiple channels (SMS, Email, Soundbox) and you can have multiple providers for a single channel.
There should be an authentication mechanism present when making calls to the provider (either in the headers or in the request, we should pass the required username and password)
Each provider will provide a separate API endpoint for each channel (SMS/Email) to send the request to.
Each provider can have multiple accounts, with each account handling a single or multiple channel requests. Account segregation is done in order to be able to handle some critical communications in a better way (like OTP comms)
On receiving a request, you need to randomly choose one of the eligible active providers for processing the request.

Mandatory Implementations

addProvider(Provider provider)
This function is to create and store the provider.
It can only be created if it passes all necessary validations.

getProvider(String providerId)
To get the provider details for the given providerId.

updateState(String providerId, boolean active)
To update the state of the provider to active/inactive

updateProvider(Provider provider)
To update the details of an existing provider.

processRequest(Request)
To process the incoming request

Optional
Set up a mechanism via which you will receive callbacks for each request sent to these providers when the corresponding communication was delivered by the external provider.

Points to note

Your code should cover all the mandatory functionalities explained above.
Your code should be executable and clean.
All necessary validations must be present.
In case of an exception, proper errorCode must be present.
Store the data in-memory for journeys and the user-transitions within the journey.
How will you be evaluated?

Code should be working.
Code readability and testability
Separation Of Concerns
Object-Oriented concepts.
Language proficiency.
SOLID principles
[execution time limit] 4 seconds (js)

[memory limit] 1 GB
