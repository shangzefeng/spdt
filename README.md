# spdt


# 用于分析服务哪个阶段耗时

基础api

开始检测
Diagnosis.start("main");  

结束检测
Diagnosis.end(); 


获取服务总耗时
Diagnosis.getTotalCostTime()  

获取服务各阶段耗时时间
Diagnosis.getCostMsg()   

资源释放
Diagnosis.release();


# 使用实例
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
	    //切记需要释放资源不然会产生内存泄露
            Diagnosis.release();
        }
    }

输出
start [1002ms    100.00%  ]
    do1 .. [0ms    0%  ]
    do2 .. [0ms    0%  ]
    do3 .. [1001ms    100.00%  ]
        do3 in do [501ms    50.00%  ]


