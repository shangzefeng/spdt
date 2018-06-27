
import java.util.logging.Logger;
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
        test();
    }

    public static void test() {
        try {
            Diagnosis.start("start");

            Diagnosis.start("do1 ..");
            //do1 .....
            Diagnosis.end();

            Diagnosis.start("do2 ..");
            //do2 .....
            Diagnosis.end();

            Diagnosis.start("do3 ..");
            //do3 .....
            Thread.sleep(500);
            {
                Diagnosis.start("do3 in do");
                Thread.sleep(500);
                Diagnosis.end();
            }
            Diagnosis.end();

        } catch (Exception e) {
        } finally {
            Diagnosis.end();
            if (Diagnosis.getTotalCostTime() > 1000) {
                System.out.println(Diagnosis.getCostMsg());
            }
            Diagnosis.release();
        }
    }
}
