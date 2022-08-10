package com.example.demo.controller;

import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglijuan
 * @Data: 2022/4/29  15:34
 * @Decription:
 * @Modified:
 */
// 参数生成类 需要添加注解@DataProvider
public class ParamPro {

    @DataProvider(name = "getAddress")
    public Object[] getParam(){
        Object [] result = null;
        List<FlightAddress> addressList = new ArrayList<FlightAddress>();

        File file = new File("e:\\flight.txt");
        FileReader fileReader;
        FlightAddress address = null;
        try {
            //读成字节
            fileReader = new FileReader(file);
            //二进制转换成字符
            BufferedReader reader = new BufferedReader(fileReader);
            String row = "";
            while ((row = reader.readLine()) != null){
                System.out.println(row);
                address = new FlightAddress();
                String [] adds = row.split(";");
                address.setFromAdd(adds[0]);
                address.setToAdd(adds[1]);
                addressList.add(address);
            }
            reader.close();
            result = new Object[addressList.size()];
            for (int i = 0; i < addressList.size(); i++) {
                result[i] = addressList.get(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }


}
