package com.carpark.view;

import com.carpark.controller.Post;
import com.carpark.controller.SavedCarPark;
import com.carpark.model.CarPark;

import java.io.*;

public class WriteSavedPost {
    public static void setCarPark(CarPark carPark) throws IOException {
        SavedCarPark savedCarPark = new SavedCarPark(carPark);
        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // сохраняем игру в файл
        objectOutputStream.writeObject(savedCarPark);
        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
    }
    public static CarPark getCarPark() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

       return ((SavedCarPark) objectInputStream.readObject()).getCarPark();
    }
}
