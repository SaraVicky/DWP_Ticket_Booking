package uk.gov.dwp.uc.pairtest;

import thirdparty.paymentgateway.TicketPaymentService;
import thirdparty.seatbooking.SeatReservationService;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

public class TicketServiceImpl implements TicketService {
    /**
     * Should only have private methods other than the one below.
     */
    private static int maxTicketCount = 20;

    private TicketPaymentService ticketPaymentService;
    private SeatReservationService seatReservationService;

    @Override
    public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {
        if (accountId != null && accountId > 0
                && hasAnyAdultPerBooking(ticketTypeRequests)
                && isInAllowableLimitPerBooking(ticketTypeRequests)) {
            ticketPaymentService.makePayment(accountId, totalAmount(ticketTypeRequests));
            seatReservationService.reserveSeat(accountId, totalSeatAllocation(ticketTypeRequests));
        } else {
            throw new InvalidPurchaseException("Invalid Request. Please check the eligibility for a booking." +
                    " Max no of tickets allowed per booking is 20." +
                    " Minimum of one adult is mandatory per booking.");
        }
    }

    /*
    Method name : hasAnyAdultPerBooking
    Method accepts varargs of TicketTypeRequest object and verify request has at least one ADULT.
    Returns True if above condition satisfied.
    By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
    */
    private boolean hasAnyAdultPerBooking(TicketTypeRequest... ticketTypeRequests) {
        String ticketType = "";
        for (TicketTypeRequest ticketTypeRequest : ticketTypeRequests) {
            ticketType = String.valueOf(ticketTypeRequest.getTicketType());
            if (ticketType == TicketTypeRequest.Type.ADULT.name()) {
                return true;
            }
        }
        return false;
    }

    /*
    Method name : isInAllowableLimitPerBooking
    Method accepts varargs of TicketTypeRequest object and verify request does not exceed the maximum limit of 20 per booking.
    Returns True if above condition satisfied.
    By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
    */
    private  boolean isInAllowableLimitPerBooking(TicketTypeRequest... ticketTypeRequest) {
        int ticketCount = 0;
        for (int i = 0; i < ticketTypeRequest.length; i++) {
            ticketCount += ticketTypeRequest[i].getNoOfTickets();
        }
        if (ticketCount < maxTicketCount) {
            return true;
        }
        return false;
    }

    /*
    Method name : totalAmount
    Method loops the TicketTypeRequest object and calculate price based on the ticketType and no of Tickets.
    Ticket price will be taken from the enum value assigned in TicketTypeRequest class.
    Returns the total amount per booking.
    By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
    */
    private int totalAmount(TicketTypeRequest... ticketTypeRequests) {
        int amount = 0;
        for (TicketTypeRequest ticketTypeRequest : ticketTypeRequests) {
            amount += ticketTypeRequest.getNoOfTickets() *
                    ticketTypeRequest.getTicketType().getEnumVal();
        }
        return amount;
    }

    /*
    Method name : totalSeatAllocation
    Method accepts TicketTypeRequest object as a param and calculate the no of seats allotted for a booking.
    Infants do not pay for a ticket and are not allocated a seat. They will be sitting on an Adult's lap.
    Returns the total of seats allotted per booking.
    By changing the access modifier to public we can do JUnit test by using TicketServiceTest class.
    */
    private int totalSeatAllocation(TicketTypeRequest... ticketTypeRequest) {
        int noOfSeats = 0;
        for (int i = 0; i < ticketTypeRequest.length; i++) {
            if (ticketTypeRequest[i].getTicketType() != TicketTypeRequest.Type.INFANT) {
                noOfSeats += ticketTypeRequest[i].getNoOfTickets();
            }
        }
        return noOfSeats;
    }
}
