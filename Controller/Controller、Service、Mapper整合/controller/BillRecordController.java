package com.hotelpms.controller;

import com.hotelpms.pojo.BillRecord;
import com.hotelpms.service.Impl.BillRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BillRecordController {

    @Autowired
    private BillRecordServiceImpl billRecordService;

//    @RequestMapping(value = "/addBillRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String addBillRecord(
//            @RequestParam("id") int id,
//            @RequestParam("bill_number") int bill_num,
//            @RequestParam("staff_id") int staff_id,
//            @RequestParam("type") String type,
//            @RequestParam("time")Date time,
//            @RequestParam("amount") BigDecimal amount,
//            @RequestParam("details") String details,
//            @RequestParam("auditing") boolean auditing
//            ){
//        if (billRecordService.addBillRecord(id,bill_num,
//                staff_id,type,time,amount,details,auditing))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/addBillRecord",method = RequestMethod.GET)
    @ResponseBody
    public String addBillRecord(
            @RequestParam("id") String id,
            @RequestParam("bill_number") String bill_num,
            @RequestParam("staff_id") String staff_id,
            @RequestParam("type") String type,
            @RequestParam("time")String time,
            @RequestParam("amount") String amount,
            @RequestParam("details") String details,
            @RequestParam("auditing") String auditing
    ){

        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (billRecordService.addBillRecord(Integer.parseInt(id),Integer.parseInt(bill_num),
                Integer.parseInt(staff_id),type,date, new BigDecimal(amount),details,
                Boolean.parseBoolean(auditing)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/updateBillRecord",method = RequestMethod.GET)
//    @ResponseBody
//    public String updateBillRecord(
//            @RequestParam("id") int id,
//            @RequestParam("bill_number") int bill_num,
//            @RequestParam("staff_id") int staff_id,
//            @RequestParam("type") String type,
//            @RequestParam("time")Date time,
//            @RequestParam("amount") BigDecimal amount,
//            @RequestParam("details") String details,
//            @RequestParam("auditing") boolean auditing
//    ){
//        if (billRecordService.updateBillRecord(id,bill_num,staff_id,
//                type,time,amount,details,auditing))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/updateBillRecord",method = RequestMethod.GET)
    @ResponseBody
    public String updateBillRecord(
            @RequestParam("id") String id,
            @RequestParam("bill_number") String bill_num,
            @RequestParam("staff_id") String staff_id,
            @RequestParam("type") String type,
            @RequestParam("time")String time,
            @RequestParam("amount") String amount,
            @RequestParam("details") String details,
            @RequestParam("auditing") String auditing
    ){

        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (billRecordService.updateBillRecord(Integer.parseInt(id),Integer.parseInt(bill_num),
                Integer.parseInt(staff_id),type,date, new BigDecimal(amount),details,
                Boolean.parseBoolean(auditing)))
            return "success";
        return "failed";
    }


//    @RequestMapping(value = "/deleteBillById",method = RequestMethod.GET)
//    @ResponseBody
//    public String deleteBillById(
//            @RequestParam("id") int id
//            ){
//        if (billRecordService.deleteBillRecord(id))
//            return "success";
//        return "failed";
//    }

    @RequestMapping(value = "/deleteBillById",method = RequestMethod.GET)
    @ResponseBody
    public String deleteBillById(
            @RequestParam("id") String id
    ){
        if (billRecordService.deleteBillRecord(Integer.parseInt(id)))
            return "success";
        return "failed";
    }

//    @RequestMapping(value = "/queryBillById",method = RequestMethod.GET)
//    @ResponseBody
//    public BillRecord queryBillById(
//            @RequestParam("id") int id){
//        return billRecordService.QueryRecordById(id);
//    }

    @RequestMapping(value = "/queryBillById",method = RequestMethod.GET)
    @ResponseBody
    public BillRecord queryBillById(
            @RequestParam("id") String id){
        return billRecordService.QueryRecordById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/queryAllBill",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryAllBill(){
        return billRecordService.QueryAllRecord();
    }

//    @RequestMapping(value = "/queryBillByTime",method = RequestMethod.GET)
//    @ResponseBody
//    public List<BillRecord> QueryBillByTime(
//            @RequestParam("start") Date start_date,
//            @RequestParam("end") Date end_date){
//        return billRecordService.QueryRecordByTime(start_date,end_date);
//    }

    @RequestMapping(value = "/queryBillByTime",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> QueryBillByTime(
            @RequestParam("start") String start_date,
            @RequestParam("end") String end_date){

        Date start = new Date();
        try {
            start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date end = new Date();
        try {
            end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(end_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return billRecordService.QueryRecordByTime(start,end);
    }

//    @RequestMapping(value = "/queryBillByStaffId",method = RequestMethod.GET)
//    @ResponseBody
//    public List<BillRecord> queryBillByStaffId(
//            @RequestParam("staff_id") int staff_id){
//        return billRecordService.QueryRecordByStaffId(staff_id);
//    }

    @RequestMapping(value = "/queryBillByStaffId",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByStaffId(
            @RequestParam("staffId") String staff_id){
        return billRecordService.QueryRecordByStaffId(Integer.parseInt(staff_id));
    }

    @RequestMapping(value = "/queryBillByStaffType",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("type") String type){
        return billRecordService.QueryRecordByType(type);
    }

//    @RequestMapping(value = "/queryBillByStaffAmount",method = RequestMethod.GET)
//    @ResponseBody
//    public List<BillRecord> queryBillByTime(
//            @RequestParam("min") BigDecimal min,
//            @RequestParam("max") BigDecimal max){
//        return billRecordService.QueryRecordByAmount(min,max);
//    }

    @RequestMapping(value = "/queryBillByStaffAmount",method = RequestMethod.GET)
    @ResponseBody
    public List<BillRecord> queryBillByTime(
            @RequestParam("min") String min,
            @RequestParam("max") String max){
        return billRecordService.QueryRecordByAmount(
                new BigDecimal(min),
                new BigDecimal(max));
    }
}
