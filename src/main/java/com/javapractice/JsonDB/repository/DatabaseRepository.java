package com.javapractice.JsonDB.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javapractice.JsonDB.entity.Table;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class DatabaseRepository  {
    private final static String fileName = "src/main/resources/DataContext.json";
    private Gson gson;

    private Comparator<Table> idComparator = new Comparator<Table>() {
        @Override
        public int compare(Table o1, Table o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    public DatabaseRepository(Gson gson) {
        this.gson = gson;
    }
    @Async
    private ArrayList<Table> loadDataFromFile() {
        var list = new ArrayList<Table>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            list = gson.fromJson(bufferedReader, new TypeToken<ArrayList<Table>>(){}.getType());
            bufferedReader.close();
            list.sort(idComparator);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Async
    private void writeFileData(ArrayList<Table> tables) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            gson.toJson(tables, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Async
    public Table getByID(Long id) {
        ArrayList<Table> tables = loadDataFromFile();
        var buff = tables.stream().filter(x -> x.getId() == Integer.parseInt(id.toString())).findFirst().get();
        return buff;
    }
    @Async
    public void delete(Long myClassId) {
        ArrayList<Table> myClassList = loadDataFromFile();
        myClassList.removeIf(x -> myClassId - 1 >= 0 && x.getId() == myClassId);
        writeFileData(myClassList);
    }
    @Async
    public void save(Table x) {
        ArrayList<Table> myClassList = loadDataFromFile();
        if (myClassList.isEmpty()) {
            x.setId(Long.valueOf(1));
        } else {
            x.setId(Long.valueOf(myClassList.get(myClassList.size() - 1).getId() + 1));
        }
        myClassList.add(x);
        writeFileData(myClassList);
    }
    @Async
    public ArrayList<Table> findAll() {
        ArrayList<Table> myClassList = loadDataFromFile();
        return myClassList;
    }
    @Async
    public Table update(Table table) {
        ArrayList<Table> lightings = loadDataFromFile();
        if (!lightings.isEmpty() && table != null) {
            var id = 0;
            for (var item : lightings) {
                if (item.getId() == table.getId()) {
                    break;
                }
                id = id + 1;
            }
            lightings.set(
                    id,
                    table);
        }
        writeFileData(lightings);
        lightings = loadDataFromFile();
        return lightings.stream().filter(x -> (x.getId()) == table.getId()).toList().get(0);
    }
}
