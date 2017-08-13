
import org.fqj.spd.Diagnosis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fsz
 */
public class Test {

    public static void main(String[] args) {
        try {
            Diagnosis.start("main");
            Thread.sleep(100);
            Diagnosis.start("sleep");
            Thread.sleep(100);
            Diagnosis.start("xxxx");
            Diagnosis.end();
            Diagnosis.end();

            Diagnosis.start("jj");
            Thread.sleep(100);
            Diagnosis.start("mmmmm");
            Thread.sleep(100);
            Diagnosis.end();
            Diagnosis.end();
            Diagnosis.end();

            System.out.println(Diagnosis.getCostMsg());
            Diagnosis.release();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
