package org.blFile.MQconsumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomFile {
    byte[] bytesFromFile;
}
