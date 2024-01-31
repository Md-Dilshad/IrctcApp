package com.dilshad.IrctcApp.service;

import com.dilshad.IrctcApp.model.Passenger;
import com.dilshad.IrctcApp.model.PersonalDetail;
import com.dilshad.IrctcApp.model.Refund;
import com.dilshad.IrctcApp.model.Ticket;

import java.util.List;

public interface IrctcInterface {

    Ticket bookTicket(Passenger passenger);
    Refund cancelTicket(String pnr);
    Ticket checkPnrStatus(String pnr);

    List<PersonalDetail> findAllPersonalDetails();
    PersonalDetail getPersonalDetailByAadhaarNo(String aadhaarNo);
    List<PersonalDetail> findDetailByAge(int age);
    String deleteByAadhaarNo(String aadhaarNo);

}
