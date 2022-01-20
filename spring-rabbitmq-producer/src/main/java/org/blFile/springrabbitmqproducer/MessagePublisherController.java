package org.blFile.springrabbitmqproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;

@RestController
public class MessagePublisherController {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/SendExcelFile")
    public String sendFile1() throws IOException {
        File file = new File("C:\\test.xlsx");
        byte[] bytesFromFile = Files.readAllBytes(file.toPath());
        CustomFile customFile = new CustomFile(bytesFromFile);
        template.convertAndSend(
                UnitQ.EXCHANGE_EXCEL,
                UnitQ.ROUTING_KEY_EXCEL,
                customFile);
        return "Excel File published";
    }

    /*
      @PostMapping ("/publish")
    public String publishMessage(@RequestBody CustomMessage message){
        message.setMessageId(1);
        message.setMessageDate(new Date());
        template.convertAndSend(UnitQ.EXCHANGE,UnitQ.ROUTING_KEY, message);
        System.out.println(message);
        return "Message publisher";
    }

     @PostMapping("/sendFile2")
    public String sendFile2(){
        File file = new File("C:\\test.xlsx");
        template.convertAndSend(UnitQ.EXCHANGE,UnitQ.ROUTING_KEY, file);
        return "File publisher";
    }


    @PostMapping("/sendExcelData")
    public String senData(){
        ExcelToJsonConvertor excelConvertor = new ExcelToJsonConvertor();
        String filePath = "C:\\test.xlsx";
        JSONObject data = excelConvertor.readExcelFileAsJsonObject_RowWise(filePath);
    template.convertAndSend(UnitQ.EXCHANGE,UnitQ.ROUTING_KEY, data);
        return "Excel Data publisher";
    }

     */


}
