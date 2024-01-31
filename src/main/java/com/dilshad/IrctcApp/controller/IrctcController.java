package com.dilshad.IrctcApp.controller;


import com.dilshad.IrctcApp.model.Passenger;
import com.dilshad.IrctcApp.model.PersonalDetail;
import com.dilshad.IrctcApp.model.Refund;
import com.dilshad.IrctcApp.model.Ticket;
import com.dilshad.IrctcApp.service.IrctcInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLOutput;
import java.util.List;

@RestController
public class IrctcController {

    @Autowired
    private IrctcInterface irctcInterface;

    @PostMapping("/book")
    public ResponseEntity<Object> bookTicket(@RequestBody Passenger passenger,WebRequest webRequest){
        Ticket ticket = irctcInterface.bookTicket(passenger);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("/checkPnrStatus")
    public Ticket checkPnrStatus(@RequestParam String pnr){
        return irctcInterface.checkPnrStatus(pnr);
    }
    @DeleteMapping("/cancelTicket")
    public Refund cancelTicket(@RequestBody String pnr) {
        return irctcInterface.cancelTicket(pnr);
    }


    @GetMapping("/getAll")
    List<PersonalDetail> findAllPersonalDetails(){
        return irctcInterface.findAllPersonalDetails();
    }

    @GetMapping("/getPD/{aadhaarNo}")
    public PersonalDetail getPersonalDetailByAadhaarNo(@PathVariable String aadhaarNo){
        return irctcInterface.getPersonalDetailByAadhaarNo(aadhaarNo);
    }

    @GetMapping("/getByAge/{age}")
    List<PersonalDetail> findDetailByAge(@PathVariable int age){
        return irctcInterface.findDetailByAge(age);
    }

    @DeleteMapping("/delete/{aadhaarNo}")
    public String deleteByAadhaarNo(@PathVariable String aadhaarNo){
        System.out.println(aadhaarNo);
        return irctcInterface.deleteByAadhaarNo(aadhaarNo);

    }

}
