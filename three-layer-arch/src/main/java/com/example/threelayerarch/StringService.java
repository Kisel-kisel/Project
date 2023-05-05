package com.example.threelayerarch;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "java")
public class StringService {
    public List<String> getList(){
        List<String> list = new ArrayList<>();
        list.add("qqq www eee");
        list.add("eee www eee");
        list.add("qqq eee eee");
        return list;
    }
}
