package org.blFile.MQconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class MessageListener {

    /*@RabbitListener(queues = UnitQ.QUEUE)
    public void listener(File file) throws FileNotFoundException {
        System.out.println(file);
        //TelechargerFile(file);
    }*/

    @RabbitListener(queues = UnitQ.QUEUE_EXCEL)
    public void listener(CustomFile customFile) throws IOException {
        File fileDestination = new File("C:\\Users\\Driss ABSIKE\\Documents\\testOut.xls");
        System.out.println("Path: "+fileDestination);
        Files.write(fileDestination.toPath(), customFile.bytesFromFile);
    }

}
