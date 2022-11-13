•	Made the TicketTypeRequest as an Immutable class.
•	Implemented a separate method for every constraint and tested using Junit testcases written under Java class TestServiceTest
•	Due to constraint ("Should only have private methods other than the one below.") mentioned in the Ticket Service class, all methods are written with private access modifier.
•	To make the Junit tests work we need to change it to public and also the assert methods has to be uncommented in the test class.
•	Method name : hasAnyAdultPerBooking
- Method accepts varargs of TicketTypeRequest object and verify request has at least one ADULT.
- Returns True if above condition satisfied.
- By changing the access modifier to public we can do JUnit test by using TicketServiceTest   class.
•	Method name : isInAllowableLimitPerBooking
- Method accepts varargs of TicketTypeRequest object and verify request does not exceed the maximum limit of 20 per booking.
- Returns True if above condition satisfied.
- By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
•	Method name : isInAllowableLimitPerBooking
- Method accepts varargs of TicketTypeRequest object and verify request does not exceed the maximum limit of 20 per booking.
- Returns True if above condition satisfied.
- By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
•	Method name : totalAmount
- Method loops the TicketTypeRequest object and calculate price based on the ticketType and no of Tickets.
- Ticket price will be taken from the enum value assigned in TicketTypeRequest class.
- Returns the total amount per booking.
- By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
•	Method name : totalAmount
- Method accepts TicketTypeRequest object as a param and calculate the no of seats allotted for a booking.
- Infants do not pay for a ticket and are not allocated a seat. They will be sitting on an Adult's lap.
- Returns the total of seats allotted per booking.
- By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
