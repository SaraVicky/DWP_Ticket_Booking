package uk.gov.dwp.uc.pairtest;

import org.junit.Test;
import uk.gov.dwp.uc.pairtest.TicketServiceImpl;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;

import static org.junit.Assert.*;

public class TicketServiceTest {

    /* To test
        1. Modify the access modifiers of the methods(hasAnyAdultPerBooking,isInAllowableLimitPerBooking ) to public.
        2. Uncomment the assert methods
     */

    @Test
    public void givenValidRequestWithAdultThenReturnTrue()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 5);
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 5);
        TicketTypeRequest ticketTypeRequest2 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 5);
        //assertTrue(ticketServiceImpl.hasAnyAdultPerBooking(ticketTypeRequest,ticketTypeRequest1,ticketTypeRequest2));
    }


    @Test
    public void givenValidRequestWithTwoAdultsThenReturnTrue()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 5);
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 5);
        //assertTrue(ticketServiceImpl.hasAnyAdultPerBooking(ticketTypeRequest,ticketTypeRequest1));
    }

    @Test
    public void givenValidRequestWithOneAdultThenReturnTrue()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 5);
        //assertTrue(ticketServiceImpl.hasAnyAdultPerBooking(ticketTypeRequest));
    }

    @Test
    public void givenInvalidRequestWithoutAdultThenReturnFalse()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);
        TicketTypeRequest ticketTypeRequest2 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 2);
        //assertFalse(ticketServiceImpl.hasAnyAdultPerBooking(ticketTypeRequest1,ticketTypeRequest2));
    }

    @Test
    public void givenInvalidRequestWithOnlyInfantThenReturnFalse()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);
        //assertFalse(ticketServiceImpl.hasAnyAdultPerBooking(ticketTypeRequest1));
    }

    @Test
    public void givenInvalidRequestWithOnlyChildThenReturnFalse()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);
        //assertFalse(ticketServiceImpl.hasAnyAdultPerBooking(ticketTypeRequest1));
    }

    @Test
    public void givenValidTicketCountWhenInLimitReturnTrue()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 5);
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 5);
        TicketTypeRequest ticketTypeRequest2 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 5);
        //assertTrue(ticketServiceImpl.isInAllowableLimitPerBooking(ticketTypeRequest,ticketTypeRequest1,ticketTypeRequest2));
    }

    @Test
    public void givenInvalidTicketCountWhenExceededLimitReturnFalse()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 6);
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 6);
        TicketTypeRequest ticketTypeRequest2 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);
        //assertFalse(ticketServiceImpl.isInAllowableLimitPerBooking(ticketTypeRequest,ticketTypeRequest1,ticketTypeRequest2));
    }

    @Test
    public void givenNoOfTicketsWithTypeThenReturnTotalCost()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 6);
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 6);
        TicketTypeRequest ticketTypeRequest2 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);
        //assertEquals(220,ticketServiceImpl.totalAmount(ticketTypeRequest,ticketTypeRequest1,ticketTypeRequest2));
    }

    @Test
    public void givenBookingDetailsThenReturnNoOfSeatsAllotted()
    {
        TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
        TicketTypeRequest ticketTypeRequest = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 6);
        TicketTypeRequest ticketTypeRequest1 = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 6);
        TicketTypeRequest ticketTypeRequest2 = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);
        //assertEquals(16,ticketServiceImpl.totalSeatAllocation(ticketTypeRequest,ticketTypeRequest1,ticketTypeRequest2));
    }

}
