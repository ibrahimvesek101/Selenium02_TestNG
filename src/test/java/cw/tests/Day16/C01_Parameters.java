package cw.tests.Day16;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C01_Parameters {

    @Test
    @Parameters ("isim")
    public void parameterizedTest(String isim){

        System.out.println("hello " + isim);

    }

    //parametreler sıra ile okunur
    //parametreleri String dışında veri tipleri ile alabiliriz.(tabiki eğer çevrilebiliyorsa örn:String>int)

    @Test
    @Parameters({"isim","soyisim","yas"})
    public void twoParameterTest(String name,String surname,int age){

        System.out.println("welcome " + name + " " + surname+ " " +age);
    }
}