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


# sample
org.fqj.spd.Diagnosis.Test
